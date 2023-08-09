package calculator.view.impl;

import calculator.presenter.CalculatorController;
import calculator.view.CalculatorView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CalcFrame extends JFrame implements CalculatorView {
    CalculatorController presenter = new CalculatorController(this);
    private JPanel operationsPanel = new JPanel();
    private JPanel numbersPanel = new JPanel();
    private JTextField display;
//    JButton numBtn[] = new JButton[10];
//    JButton equals = new JButton("=");
//    JButton addBtn = new JButton("+");
//    JButton subtractBtn = new JButton("-");
//    JButton multiplyBtn = new JButton("*");
//    JButton divideBtn = new JButton("/");
//    JButton cls = new JButton("C");


    public JTextField getDisplay() {
        return display;
    }

    public CalcFrame() {
        super("Calculator");

        setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        numbersPanel.setLayout(new GridLayout(4, 3));
        operationsPanel.setLayout(new GridLayout(3, 2));

        for (int i = 0; i < 10; i++) {
            String text = String.valueOf(i);
            JButton button = new JButton(text);
            button.addActionListener(presenter.getNumberAction());
            button.setBorder(new LineBorder(Color.BLACK));
            button.setPreferredSize(new Dimension(50, 50));
            numbersPanel.add(button);

            KeyStroke pressed = KeyStroke.getKeyStroke(text);
            InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            inputMap.put(pressed, text);
            button.getActionMap().put(text, presenter.getNumberAction());
        }

        add(numbersPanel, BorderLayout.CENTER);
//        add(operationsPanel, BorderLayout.WEST);
    }

}
