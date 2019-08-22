package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.util.Objects;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public final class OutputWriter {
    private final BufferedWriter bufferedWriter;

    OutputWriter(final String filename) {
        bufferedWriter = new BufferedWriter(Objects.requireNonNull(getWriterForFile(filename)));
    }

    public void write(final String content) {
        try {
            this.bufferedWriter.write(content);
            this.bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Writer getWriterForFile(final String file) {
        if (file == null || file.isEmpty()) {
            return new OutputStreamWriter(System.out);
        } else {
            try {
                return new FileWriter(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
