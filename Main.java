package com.poject;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.*;

import static com.poject.FileLocation.*;

public class Main {

    private static final String BASE_URL = "https://dog.ceo/api/";

    // -------------------------------
    public static String sendGetRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();
        return result.toString();
    }

    // -------------------------------
    public static List<String> listAllBreeds() {
        try {
            String response = sendGetRequest(BASE_URL + "breeds/list/all");
            JsonObject json = JsonParser.parseString(response).getAsJsonObject();
            JsonObject message = json.getAsJsonObject("message");

            List<String> breeds = new ArrayList<>();
            for (String breed : message.keySet()) {
                breeds.add(breed);
            }
            return breeds;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // -------------------------------
    public static String getRandomDogImage() {
        try {
            String response = sendGetRequest(BASE_URL + "breeds/image/random");
            JsonObject json = JsonParser.parseString(response).getAsJsonObject();
            return json.get("message").getAsString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // -------------------------------
    public static String getRandomImageByBreed(String breed) {
        try {
            String response = sendGetRequest(BASE_URL + "breed/" + breed + "/images/random");
            JsonObject json = JsonParser.parseString(response).getAsJsonObject();
            return json.get("message").getAsString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }


    // -------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "all_dogs.csv";

        while (true) {
            System.out.println("===  Dog API App ===");
            System.out.println("1. List all breeds");
            System.out.println("2. Get random dog image");
            System.out.println("3. Get random image by breed");
            System.out.println("4. Save one random image URL");
            System.out.println("5. Save 5 random image URLs");
            System.out.println("6. Save 5 random breed images");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("All Breeds: " + listAllBreeds());
                    break;

                case 2:
                    System.out.println("Random Dog Image: " + getRandomDogImage());
                    break;

                case 3:
                    System.out.print("Enter breed name: ");
                    String breed = sc.nextLine();
                    System.out.println("Random " + breed + " Image: " + getRandomImageByBreed(breed));
                    break;

                case 4:
                    saveURLToFile(List.of(getRandomDogImage()), fileName);
                    break;

                case 5:
                    saveURLToFile(getFiveRandomImages(), fileName);
                    break;

                case 6:
                    System.out.print("Enter breed name: ");
                    String b = sc.nextLine();
                    List<String> imgs = getFiveRandomImagesByBreed(b);
                    System.out.println("5 images of " + b + ": " + imgs);
                    saveURLToFile(imgs, fileName);
                    break;

                case 7:
                    System.out.println("Thank you! Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
