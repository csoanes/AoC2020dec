package com.nebulaworx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> input = null;
        LoadInputFile inputFile = new LoadInputFile();



        try {
            input = inputFile.loadInputFileFromPath("/Users/root1/IdeaProjects/AoC2020/input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // convert to list of ints
        List<Integer> intList = input.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        List<Integer> candidates = new ArrayList<>();
        for (Integer sum1: intList) {
            for (Integer sum2: intList) {
                for (Integer sum3: intList) {
                    if (sum1 + sum2 + sum3 == 2020) {
                        System.out.println("candidate: " + sum1 * sum2 * sum3);
                        candidates.add(sum1 * sum2*sum3);
                    }
                }
            }
        }

        Integer product = candidates.stream().reduce(1, (a,b) -> a*b);
        System.out.println("Product: " + product);
    }
}
