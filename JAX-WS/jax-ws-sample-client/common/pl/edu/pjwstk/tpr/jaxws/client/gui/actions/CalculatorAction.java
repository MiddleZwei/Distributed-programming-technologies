package pl.edu.pjwstk.tpr.jaxws.client.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import pl.edu.pjwstk.tpr.jaxws.client.Calculator;

public class CalculatorAction extends PrintMessageActionBase {

	private static final long serialVersionUID = 2162164203579637936L;
	
	public static final String ADD = "add";
	public static final String SUBTRACT = "subtract";
	
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