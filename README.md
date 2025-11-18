
# 🐶 Dog API - File Handler

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.java.com/) 
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)




## Overview  
The **Dog API - File Handler** is a Java console application that interacts with the [Dog API](https://dog.ceo/api/) to fetch and display dog-related data such as breed lists and random dog images.  
It demonstrates handling **HTTP requests**, **JSON parsing**, and **file writing** in Java, providing hands-on experience with **API integration** and **data management**.



## Objectives 
- Connect Java programs with REST APIs.  
- Parse JSON responses using the **Gson** library.  
- Save API responses, such as image URLs, into text files.  
- Provide an interactive console menu for easy user interaction.  
- Encourage modular programming with reusable methods and clean logic.



## Features / Application Flow

The application menu offers:

1. **List All Breeds** – Fetches and displays all dog breeds.  
2. **Get Random Dog Image** – Fetches a single random dog image.  
3. **Get Random Image by Breed** – Fetches a random image of a specific breed.  
4. **Save One Random Image URL** – Saves a random image URL to a file.  
5. **Save 5 Random Image URLs** – Saves 5 random image URLs to a file.  
6. **Get 5 Random Images by Breed** – Fetches 5 images of a breed and saves URLs.  
7. **Exit Application** – Closes the program.
   
## Implementation Details

**Package Name:** `org.example`

**Libraries Used:**  
- `com.google.gson.*` – JSON parsing  
- `java.io.*` – File operations  
- `java.net.*` – HTTP requests  
- `java.util.*` – Lists and user input  

**Classes & Methods:**  

**1. DogResponse**  
- Fields: `Object message`, `String status`  
- Maps JSON responses from the API.  

**2. DogAPIHandler**  
- `sendGetRequest(String urlString)` – Sends GET request, returns response.  
- `listAllBreeds()` – Fetches all dog breeds.  
- `getRandomDogImage()` – Fetches one random dog image URL.  
- `getRandomImageByBreed(String breed)` – Fetches random image for a breed.  
- `saveURLToFile(List<String> urls, String fileName)` – Saves image URLs to a file.  
- `getFiveRandomImages()` – Fetches 5 random images.  
- `getFiveRandomImagesByBreed(String breed)` – Fetches 5 images of a breed.  
- `main(String[] args)` – Entry point: menu display and user interaction.



## Benefits / Learning Outcomes
- Understand connecting Java applications with REST APIs.  
- Learn JSON parsing using Gson.  
- Practice saving API data to text files.  
- Gain experience with modular and reusable Java programming.  
- Build an interactive console-based application.  



## Future Enhancements
- Automatically save images to local directories.  
- Add a GUI interface for easier usage.  
- Integrate more API endpoints like dog facts or sub-breed images.  
- Enable cloud storage support for images.  






