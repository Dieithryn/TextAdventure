package org.example;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Events {

private String content;
    private FileReader readFile;
    private FileWriter writeFile;
    private String eventStorage;;
    private String eventInitial = "You are in a rainforest. The trees sway in the wind of an oncoming storm.The surrounding area grows silent as the wildlife takes shelter.There is no one around. You have a dead walkie-talkie, two matches, and a small pocket knife. \n";

    public Events() throws IOException {
    }

    public String Events() throws IOException {

        return eventInitial;

    }

    public void setEvent(String event) throws IOException {

        writeFile = new FileWriter("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\java\\org\\example\\newSaves\\newFile.txt", true);
        writeFile.write(event);
        eventStorage = event;
        writeFile.close();
    }

    public String getEvent() {

        return eventStorage;

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
