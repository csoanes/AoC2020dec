package com.nebulaworx;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoadInputFile {

    private static void printPaths(File file) throws IOException {
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Canonical Path: " + file.getCanonicalPath());
        System.out.println("Path: " + file.getPath());
    }

    List<String> loadInputFileFromPath(final String pathString) throws IOException {
        File file = new File(pathString);
        try {

            printPaths(file);

            System.out.println(file.toURI());
            System.out.println(file.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> input = new ArrayList<>();
        Path path = null;


        Stream<String> lines = Files.lines(file.toPath());
        input = lines.collect(Collectors.toList());
        lines.close();

        return input;
    }
}
