package com.natpryce.wordcloud;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;
import wordcram.WordCram;

public class CLI {
    public static void main(String[] args) {
        PApplet processing = new PApplet();
        processing.start();

        PGraphics image = processing.createGraphics(640, 480, PConstants.JAVA2D);

        WordCram wordCram = new WordCram(processing)
                .fromTextString(args)
                .withCustomCanvas(image);
        image.beginDraw();
        wordCram.drawAll();
        image.endDraw();
        image.save("output.png");

        processing.stop();
        System.exit(0);
    }
}
