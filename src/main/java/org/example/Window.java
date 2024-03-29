package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

interface InputHandler {
    public void op(String input);
}
public class Window {

    private int width = 640;
    private int height = 480;
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private JPanel panel;
    private JScrollPane scrollPane;
    private File newFile;
    protected String input;


    public Window(InputHandler inputHandler) {


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
                writer.append("> ").append(input).append("\n");
                writer.close();

                //update text area text continually
                textField.setText("");

                inputHandler.op(input);

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

    public void setTextArea(String text) {

        textArea.append(text);
    }

}

