package com.natpryce.wordcloud;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;
import wordcram.Anglers;
import wordcram.Colorers;
import wordcram.Placers;
import wordcram.WordCram;

import java.util.Arrays;
import java.util.List;

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
            PGraphics image = processing.createGraphics(640, 480, PConstants.JAVA2D);

            WordCram wordCram = new WordCram(processing)
                    .withCustomCanvas(image)
                    .fromTextString(PApplet.loadStrings(System.in))
                    .withColorer(Colorers.twoHuesRandomSats(processing))
                    .withAngler(Anglers.mostlyHoriz())
                    .withWordPadding(4)
                    .withPlacer(Placers.centerClump());

            String outputFile = parseArgs(args, wordCram);

            image.beginDraw();
            wordCram.drawAll();
            image.endDraw();

            image.save(outputFile);

            processing.stop();
            System.exit(0);

        } catch (Throwable t){
            System.err.println(t.getMessage());
            System.exit(1);
        }
    }

    public static void usage() {
        String programName = System.getProperty("argv0", "java " + CLI.class.getName());
        System.err.println("usage: " + programName + "<options>");
        System.err.println("options:");
        System.err.println("  -f|--font <font>[,<font>,...]");
        System.err.println("  -p|--padding <pixels>");
        System.err.println("  -o|--output <filename>");
        System.err.println("  -h|--help");
    }

    private static String parseArgs(List<String> args, WordCram wordCram) {
        String outputFile = "output.png";

        for (int i = 0; i < args.size(); i += 2) {
            String argName = args.get(i);
            String argValue = args.get(i+1);

            if (argName.equals("-o") || argName.equals("--output")) {
                outputFile = argValue;
            }
            else if (argName.equals("-f") || argName.equals("--font")) {
                parseFonter(argValue, wordCram);
            }
            else if (argName.equals("-p") || argName.equals("--padding")) {
                parsePadding(argValue, wordCram);
            }
            else {
                usage();
                System.exit(1);
            }
        }
        return outputFile;
    }

    private static void parsePadding(String argValue, WordCram wordCram) {
        wordCram.withWordPadding(Integer.parseInt(argValue));
    }

    private static void parseFonter(String argValue, WordCram wordCram) {
        wordCram.withFonts(argValue.split(","));
    }
}
