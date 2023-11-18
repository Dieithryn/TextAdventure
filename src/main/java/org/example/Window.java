package org.example;

import jdk.jfr.Event;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class Window {

    private int width = 640;
    private int height = 320;
    private JFrame frame = new JFrame("Text Adventure");
    private JTextField textField = new JTextField(20);
    private JTextArea textArea = new JTextArea();
    private String event = String.valueOf(new Events());

    public Window() throws IOException {

        //new frame
        frame.setSize(width, height);
        frame.setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout(20,20));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //new text field attributes

        textField.setBackground(Color.WHITE);
        textField.setVisible(true);



        //new text area attributes
        textArea.setBackground(Color.WHITE);
        textArea.setSize(130,130);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(event);
        textArea.setVisible(true);

        //add text field to frame
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(textField, BorderLayout.PAGE_END);


    }

}

