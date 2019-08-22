package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Objects;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
final class InputReader {
    private final BufferedReader bufferedReader;

    InputReader(final String filename) {
        bufferedReader = new BufferedReader(Objects.requireNonNull(getReaderForFile(filename)));
    }

    String readLine() {
        String line = null;

        try {
            line = this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }


    private Reader getReaderForFile(final String file) {
        if (file == null || file.isEmpty()) {
            return new InputStreamReader(System.in);
        } else {
            try {
                return new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
