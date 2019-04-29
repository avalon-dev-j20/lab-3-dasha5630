/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.frames;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import ru.avalon.java.ui.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;

public class SliderExample extends AbstractFrame {

    private JLabel labeltest = new JLabel("test");
    private JLabel labelRed = new JLabel("Red");
    private JLabel labelGreen = new JLabel("Green");
    private JLabel labelBlue = new JLabel("Blue");
    private JSlider sliderRed = new JSlider(0, 255, 125);
    private JSlider sliderGreen = new JSlider(0, 255, 125);
    private JSlider sliderBlue = new JSlider(0, 255, 125);

    private JPanel colorPanel = new JPanel();

    private JPanel sliderPanel = new JPanel();

    private Clipboard clipboard = Toolkit
            .getDefaultToolkit()
            .getSystemClipboard();

    @Override
    protected void onCreate() {
        Border border = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Container contentPane = getContentPane();
        if (contentPane instanceof JComponent) {
            JComponent comp = (JComponent) contentPane;
            comp.setBorder(border);
        }
        setTitle("Color Picker");
        setSize(300, 300);
        setLayout(new GridLayout(1, 2));

        add(onCreateColorPanel());
        add(onCreateSlidersPanel());

  

        sliderRed.addChangeListener(this::onSliderChange);
        sliderGreen.addChangeListener(this::onSliderChange);
        sliderBlue.addChangeListener(this::onSliderChange);

        updateColor();
    }

    // создаем холст
    private JPanel onCreateColorPanel() {
        colorPanel.setLayout(new BorderLayout());
        Color color = new Color(sliderRed.getX(), sliderGreen.getX(), sliderBlue.getX());
        colorPanel.setBackground(color);
        Border border;
        border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        colorPanel.setBorder(border);
        colorPanel.setToolTipText("#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase()); // устанавливаем всплывающую подсказку по начальному цвету   
        return colorPanel;
    }

    //и
    private void updateColor() {

        int Red = sliderRed.getValue();
        int Green = sliderGreen.getValue();
        int Blue = sliderBlue.getValue();

        Color color = new Color(Red, Green, Blue);
        colorPanel.setBackground(color);
        String hexColor = "#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase();
        colorPanel.setToolTipText(hexColor);
        if (!isBlank(hexColor)) {
            copyToClipboard(hexColor);
        }
    }

    private void onSliderChange(ChangeEvent e) {
        updateColor();
    }

    private JPanel onCreateSlidersPanel() {

        sliderPanel.setLayout(new GridLayout(3, 1));
        Border border = BorderFactory.createEmptyBorder(25, 25, 25, 25);

        JPanel slidersPanelBlue = new JPanel();
        JPanel slidersPanelGreen = new JPanel();
        JPanel slidersPanelRed = new JPanel();

        slidersPanelRed.setLayout(new BorderLayout());
        slidersPanelGreen.setLayout(new BorderLayout());
        slidersPanelBlue.setLayout(new BorderLayout());

        slidersPanelBlue.setBorder(border);
        slidersPanelRed.setBorder(border);
        slidersPanelGreen.setBorder(border);

        sliderRed.setPaintTicks(true);
        sliderGreen.setPaintTicks(true);
        sliderBlue.setPaintTicks(true);
        
        sliderBlue.setMajorTickSpacing(20);
        sliderRed.setMajorTickSpacing(20);
        sliderGreen.setMajorTickSpacing(20);
        
        slidersPanelRed.add(labelRed, BorderLayout.LINE_START); 
        slidersPanelGreen.add(labelGreen, BorderLayout.LINE_START);
        slidersPanelBlue.add(labelBlue, BorderLayout.LINE_START);    

        slidersPanelRed.add(sliderRed);
        slidersPanelBlue.add(sliderBlue);
        slidersPanelGreen.add(sliderGreen);    

        sliderPanel.add(slidersPanelBlue);
        sliderPanel.add(slidersPanelGreen);
        sliderPanel.add(slidersPanelRed);

        return sliderPanel;
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }

    private boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    private class MouseEventListener extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            colorPanel.setToolTipText("0");
        }

    }

}
