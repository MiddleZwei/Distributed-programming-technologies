package pl.edu.pjwstk.tpr.jaxws.client.gui.actions;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

public abstract class PrintMessageActionBase extends AbstractAction {

	private static final long serialVersionUID = -1691736913658662569L;

	private final JTextArea _output;

	protected PrintMessageActionBase(JTextArea output, String actionName) {
		super(actionName);
		_output = output;
	}

	protected final void print(String message) {
		_output.append(message + "\n");
	}
	
	protected final void print(String format, Object... values) {
	    String message = String.format(format, values);
	    print(message);
	}

	protected final void printAwaitingResponse() {
		print("Awaiting response...");
		sleep();
	}

	protected final void sleep() {
		try {
			Thread.sleep(1000);
		} catch (Throwable ex) {
			print(ex.toString());
		}
	}
	
	protected final void print(Throwable ex) {
	    print(ex.toString());
	}
}