package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api") // Base path for all API endpoints
public class TextFileController {

    @GetMapping("/text-files")
    public List<String> getTextFiles() throws IOException {
        // Replace with your actual directory path
        String textFolderPath = "C:/Users/anuraggupta47/Desktop/Claude/demo/src/main/java/com/example/demo/text"; // Adjust as needed src/main/java/com/example/demo/text
        File directory = new File(textFolderPath);

//        System.out.println("Hello World " + directory);
//        Logger.info("Text file directory path: {} " + textFolderPath); // Add logging statement


        if (!directory.exists()) {
            throw new FileNotFoundException("Text file directory not found");
        }

        return Arrays.stream(directory.listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(".txt")))
                .map(File::getName)
                .collect(Collectors.toList());
    }
}
