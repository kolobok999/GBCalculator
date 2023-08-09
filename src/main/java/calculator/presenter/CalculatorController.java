package calculator.presenter;

import calculator.view.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalculatorController {
    private final CalculatorView view;
//    private final CalculatorModel model;

    public CalculatorController(CalculatorView view) {
        this.view = view;

//        this.view.onClear(()-> {
//            this.view.setText("");
//        });
//
//        this.view.onAdd(()-> {
//
//            this.view.setText(result);
//        });
    }

    public Action getNumberAction() {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField display = view.getDisplay();
                display.setCaretPosition(display.getDocument().getLength());
                display.replaceSelection(e.getActionCommand());
            }
        };
    }

}
