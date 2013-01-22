package com.natpryce.wordcloud;

import processing.core.PApplet;
import processing.core.PGraphics;
import wordcram.Anglers;
import wordcram.Colorers;
import wordcram.Placers;
import wordcram.WordCram;

import java.util.Arrays;
import java.util.List;

import static processing.core.PConstants.JAVA2D;

public class CLI {
    public static void main(String[] argv) {
        List<String> args = Arrays.asList(argv);

        if (args.size() % 2 == 1 || args.contains("--help") || args.contains("-h")) {
            usage();
            return;
        }

        PApplet processing = new PApplet();

        processing.init();
        processing.start();

        try {
            WordCram wordCram = new WordCram(processing)
                    .fromTextString(PApplet.loadStrings(System.in))
                    .withColorer(Colorers.twoHuesRandomSats(processing))
                    .withAngler(Anglers.mostlyHoriz())
                    .withWordPadding(4)
                    .withPlacer(Placers.centerClump());

            ImageConfiguration imageConfig = parseArgs(args, wordCram);

            PGraphics image = processing.createGraphics(imageConfig.width, imageConfig.height, JAVA2D);
            try {
                wordCram.withCustomCanvas(image);

                image.beginDraw();
                wordCram.drawAll();
                image.endDraw();

                image.save(imageConfig.fileName);

            } finally {
                image.dispose();
            }

            processing.stop();
            System.exit(0);

        } catch (Throwable t) {
            System.err.println(t.getMessage());
            System.exit(1);
        }
    }

    public static void usage() {
        String programName = System.getProperty("argv0", "java " + CLI.class.getName());
        System.err.println("usage: " + programName + "<options>");
        System.err.println("options:");
        System.err.println("  -f|--font <font>[,<font>,...]");
        System.err.println("  -o|--output <filename>");
        System.err.println("  -p|--padding <pixels>");
        System.err.println("  -s|--size <width>x<height>");
        System.err.println("  -h|--help");
    }

    private static class ImageConfiguration {
        public String fileName = "output.png";
        public int width = 640;
        public int height = 480;
    }

    private static ImageConfiguration parseArgs(List<String> args, WordCram wordCram) {
        ImageConfiguration imageConfiguration = new ImageConfiguration();

        for (int i = 0; i < args.size(); i += 2) {
            String argName = args.get(i);
            String argValue = args.get(i + 1);

            if (argName.equals("-o") || argName.equals("--output")) {
                imageConfiguration.fileName = argValue;
            } else if (argName.equals("-s") || argName.equals("--size")) {
                parseSize(argValue, imageConfiguration);
            } else if (argName.equals("-f") || argName.equals("--font")) {
                parseFonter(argValue, wordCram);
            } else if (argName.equals("-p") || argName.equals("--padding")) {
                parsePadding(argValue, wordCram);
            } else {
                usage();
                System.exit(1);
            }
        }
        return imageConfiguration;
    }

    private static void parseSize(String argValue, ImageConfiguration imageConfiguration) {
        String[] parts = argValue.split("x");
        if (parts.length != 2) {
            usage();
            System.exit(1);
        }

        imageConfiguration.width = Integer.parseInt(parts[0]);
        imageConfiguration.height = Integer.parseInt(parts[1]);
    }

    private static void parsePadding(String argValue, WordCram wordCram) {
        wordCram.withWordPadding(Integer.parseInt(argValue));
    }

    private static void parseFonter(String argValue, WordCram wordCram) {
        wordCram.withFonts(argValue.split(","));
    }
}
