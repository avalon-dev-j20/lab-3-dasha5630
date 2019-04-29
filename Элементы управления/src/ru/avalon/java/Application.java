/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java;

import javax.swing.JFrame;
import ru.avalon.java.frames.*;

public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //JFrame frame = new MouseEventsExample();
        JFrame frame = new SliderExample();

        frame.setVisible(true);
    }

}
