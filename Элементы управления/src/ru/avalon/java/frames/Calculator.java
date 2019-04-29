package ru.avalon.java.frames;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import ru.avalon.java.ui.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;

public class Calculator extends AbstractFrame {

    private JButton[] buttonArray = {
        new JButton("7"), new JButton("8"), new JButton("9"), new JButton("+"),
        new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
        new JButton("1"), new JButton("2"), new JButton("3"), new JButton("*"),
        new JButton("CE"), new JButton("0"), new JButton("."), new JButton("/")};

    JButton buttonEq = new JButton("=");

    JLabel label = new JLabel("0");

    private JPanel numbersButtonPanel = new JPanel();

    private JPanel numbersPanel = new JPanel();

    private JPanel buttonEqPanel = new JPanel();

   

    @Override
    protected void onCreate() {
        setTitle("Calculator");

        setLayout(new GridLayout(3, 1));
        setSize(600, 600);
        add(onCreateNumbersPanel());
        add(onCreateNumbersButtonPanel());
        add(onCreateButtonEqPanel());
        setMaximumSize(new Dimension(600, 600));
        
        
        Integer index = 0;
        for (JButton button : buttonArray) {
            button.addActionListener(this::onButtonClick);
               index++;
        }

        buttonEq.setActionCommand("16");
    }
 
     private void onButtonClick(ActionEvent e) {
         e.getActionCommand();
        switch (e.getActionCommand()){
            case "1":{
            
            }
        }

    }

    private JPanel onCreateNumbersButtonPanel() {
        numbersButtonPanel.setLayout(new GridLayout(4, 4));

        for (JButton button : buttonArray) {
            numbersButtonPanel.add(button);
        }
        
        return numbersButtonPanel;

    }

    private JPanel onCreateNumbersPanel() {
        numbersPanel.add(label);
        return numbersPanel;
    }

    private JPanel onCreateButtonEqPanel() {
        buttonEqPanel.add(buttonEq);
        return buttonEqPanel;
    }

}
