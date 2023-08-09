package calculator;

import calculator.view.impl.CalcFrame;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new CalcFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
        frame.setSize(250, 200);
    }
}
