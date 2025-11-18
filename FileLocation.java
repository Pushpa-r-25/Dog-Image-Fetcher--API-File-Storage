package com.poject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.poject.Main.getRandomDogImage;
import static com.poject.Main.getRandomImageByBreed;

public class FileLocation {
    // -------------------------------
    public static void saveURLToFile(List<String> urls, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String url : urls) {
                writer.write(url);
                writer.newLine();
            }
            System.out.println(" URLs saved to " + fileName);
            System.out.println(" File location: " + new File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // -------------------------------
    public static List<String> getFiveRandomImages() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(getRandomDogImage());
        }
        return list;
    }

    public static List<String> getFiveRandomImagesByBreed(String breed) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(getRandomImageByBreed(breed));
        }
        return list;
    }

}
