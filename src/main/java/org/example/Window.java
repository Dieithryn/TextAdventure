package org.example;

import jdk.jfr.Event;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;


public class Window {

    private int width = 640;
    private int height = 480;
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private JPanel panel;
    private JScrollPane scrollPane;
    private String event = String.valueOf(new Events());
    private File newFile;
    protected String input;


    public Window() throws IOException {

        //make frame
        frame = new JFrame("Text Adventure");

        //set panel to content plane
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setSize(width, height);
        panel.setLayout(new BorderLayout(20,20));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.setOpaque(true);


        //new text field attributes
        textField = new JTextField(20);
        textField.setBackground(Color.WHITE);
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField.addActionListener(e -> {
           input = textField.getText();
            try {
                newFile = new File("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\java\\org\\example\\newSaves\\newFile.txt");
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                FileWriter writer = new FileWriter(newFile.getAbsoluteFile(), true);
                writer.append(input + "\n");

                //update text area text continually
                textArea.append(input + "\n");

                writer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //new text area attributes

        textArea = new JTextArea();
        textArea.setBackground(Color.WHITE);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10,10,10,10));
        textArea.setText(event.toString());

        //new scrollPane
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //add elements to frame/panel
        frame.add(panel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.PAGE_END);

        //set frame visibility and functions
        frame.setSize(width, height);
        frame.setAlwaysOnTop(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }



}

