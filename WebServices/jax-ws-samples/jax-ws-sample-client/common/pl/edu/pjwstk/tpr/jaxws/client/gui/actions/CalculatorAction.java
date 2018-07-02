package pl.edu.pjwstk.tpr.jaxws.client.gui.actions;

import pl.edu.pjwstk.tpr.jaxws.client.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalculatorAction extends PrintMessageActionBase {

    public static final String ADD = "add";
    public static final String SUBTRACT = "subtract";
    private static final long serialVersionUID = 2162164203579637936L;
    private final Calculator _calculator;

    public CalculatorAction(Calculator calculator, JTextArea output, String actionName) {
        super(output, actionName);
        _calculator = calculator;
    }

    public void actionPerformed(ActionEvent ev) {
        switch (ev.getActionCommand()) {
            case ADD:
                add();
            case SUBTRACT:
                subtract();
        }
    }

    private void add() {
        int component1 = 3;
        int component2 = 2;
        int sum = _calculator.add(component1, component2);
        print(String.format("sum: %d", sum));
    }

    private void subtract() {
        int minuend = 3;
        int subtrahend = 2;
        int difference = _calculator.add(minuend, subtrahend);
        print(String.format("difference: %d", difference));
    }
}