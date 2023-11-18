package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private File newFile;
    private Events events = new Events();

    public Writer() throws IOException {

        newFile = new File("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\java\\org\\example\\newSaves\\newFile.txt");
        if (!newFile.exists()) {
            newFile.createNewFile();
        }

    }
}
