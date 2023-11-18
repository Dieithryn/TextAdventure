package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Events {

private String content;
    private FileReader readFile;
    private String eventInitial = "You are in a rainforest. The trees sway in the wind of an oncoming storm.The surrounding area grows silent as the wildlife takes shelter.There is no one around. You have a dead walkie-talkie, two matches, and a small pocket knife.";
    public String Events() throws IOException {


        return content;
    }

    @Override
    public String toString() {

        try {
            content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\java\\org\\example\\newSaves\\newFile.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content;
    }
}
