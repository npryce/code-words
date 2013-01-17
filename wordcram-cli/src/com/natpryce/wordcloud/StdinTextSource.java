package com.natpryce.wordcloud;

import wordcram.text.TextSource;

import java.io.IOException;

public class StdinTextSource implements TextSource {
    public String getText() {
        StringBuilder builder = new StringBuilder();
        try {
            int ch;
            while ((ch = System.in.read()) != -1) {
                builder.append((char)ch);
            }
        } catch (IOException e) {
            // just return what we've got
        }
        return builder.toString();
    }
}
