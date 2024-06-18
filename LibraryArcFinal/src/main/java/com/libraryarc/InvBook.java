package com.libraryarc;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * @author Samsung
 * This File is the second frame after the login frame, this is where the user can view
 * respective books sorted by genre.
 */
public class InvBook extends JFrame {

    private JPanel mainPanel;
    private JButton backButton, nextButton;
    private JButton thrillerButton, romanceButton, fictionButton, fairyTaleButton, novelButton;
    private JLabel thrillerLabel, romanceLabel, fictionLabel, fairyTaleLabel, novelLabel;
    private JTextField headerTextField;

    public InvBook() {
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        backButton = new JButton();
        nextButton = new JButton();
        thrillerButton = new JButton();
        romanceButton = new JButton();
        fictionButton = new JButton();
        fairyTaleButton = new JButton();
        novelButton = new JButton();
        thrillerLabel = new JLabel();
        romanceLabel = new JLabel();
        fictionLabel = new JLabel();
        fairyTaleLabel = new JLabel();
        novelLabel = new JLabel();
        headerTextField = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("Back");
        backButton.addActionListener(evt -> backButtonActionPerformed(evt));

        nextButton.setText("Next");
        nextButton.addActionListener(evt -> nextButtonActionPerformed(evt));

        //thrillerButton.setIcon(new ImageIcon(getClass().getResource("/inventory/books/1thriller.jpg")));
        //romanceButton.setIcon(new ImageIcon(getClass().getResource("/inventory/books/2romance.jpg")));
        //fictionButton.setIcon(new ImageIcon(getClass().getResource("/inventory/books/3fiction.jpg")));
        //fairyTaleButton.setIcon(new ImageIcon(getClass().getResource("/inventory/books/4fairy tale.jpg")));
        //novelButton.setIcon(new ImageIcon(getClass().getResource("/inventory/books/5novel.jpg")));

        thrillerLabel.setText("Thriller");
        romanceLabel.setText("Romance");
        fictionLabel.setText("Fiction");
        fairyTaleLabel.setText("Fairy Tale");
        novelLabel.setText("Novel");

        headerTextField.setText("BOOKS AVAILABLE");
        headerTextField.setEditable(false);
        headerTextField.setHorizontalAlignment(JTextField.CENTER);

        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(thrillerButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(romanceButton)
                                    .addGap(57, 57, 57)
                                    .addComponent(fictionButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(thrillerLabel)
                                    .addGap(200, 200, 200)
                                    .addComponent(romanceLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fictionLabel)))
                            .addGap(41, 41, 41))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(fairyTaleButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(novelButton)
                            .addGap(128, 128, 128))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(backButton)
                            .addGap(18, 18, 18)
                            .addComponent(nextButton))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(165, 165, 165)
                            .addComponent(fairyTaleLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(novelLabel)
                            .addGap(197, 197, 197)))
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(headerTextField, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                    .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(headerTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(romanceButton, GroupLayout.Alignment.TRAILING)
                        .addComponent(fictionButton, GroupLayout.Alignment.TRAILING)
                        .addComponent(thrillerButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(thrillerLabel)
                        .addComponent(romanceLabel)
                        .addComponent(fictionLabel))
                    .addGap(73, 73, 73)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(fairyTaleButton)
                        .addComponent(novelButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(fairyTaleLabel)
                        .addComponent(novelLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton)
                        .addComponent(nextButton))
                    .addGap(51, 51, 51))
        );

        getContentPane().add(mainPanel);

        pack();
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        // Handle Back button action
    }

    private void nextButtonActionPerformed(ActionEvent evt) {
        // Handle Next button action
    }
}
