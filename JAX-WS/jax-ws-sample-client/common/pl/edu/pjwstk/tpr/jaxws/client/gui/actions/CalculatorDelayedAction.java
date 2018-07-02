package pl.edu.pjwstk.tpr.jaxws.client.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayedResponse;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.CalculatorDelayed;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayedResponse;

public class CalculatorDelayedAction extends PrintMessageActionBase {

    private static final long serialVersionUID = 2162164203579637936L;

    public static final String ADD_DELAYED = "addDelayed";
    public static final String ADD_DELAYED_ASYNC = "addDelayedAsync";
    public static final String ADD_DELAYED_ASYNC_WITH_HANDLER = "addDelayedAsyncWithHandler";

    public static final String SUBTRACT_DELAYED = "subtract";
    public static final String SUBTRACT_DELAYED_ASYNC = "subtractDelayedAsync";
    public static final String SUBTRACT_DELAYED_ASYNC_WITH_HANDLER = "subtractDelayedAsyncWithHandler";

    private final CalculatorDelayed _calculatorDelayed;
    private final AddHandler _addHandler;
    private final SubtractHandler _subtractHandler;

    public CalculatorDelayedAction(CalculatorDelayed calculatorDelayed, JTextArea output, String actionName) {
        super(output, actionName);
        _calculatorDelayed = calculatorDelayed;
        _addHandler = new AddHandler();
        _subtractHandler = new SubtractHandler();
    }

    public void actionPerformed(ActionEvent ev) {
        switch (ev.getActionCommand()) {
            case ADD_DELAYED:
                addDelayed();
                break;
            case ADD_DELAYED_ASYNC:
                addDelayedAsync();
                break;
            case ADD_DELAYED_ASYNC_WITH_HANDLER:
                addDelayedAsyncWithHandler();
                break;
            case SUBTRACT_DELAYED:
                subtract();
                break;
            case SUBTRACT_DELAYED_ASYNC:
                subtractDelayedAsync();
                break;
            case SUBTRACT_DELAYED_ASYNC_WITH_HANDLER:
                subtractDelayedAsyncWithHandler();
                break;
        }
    }

    private void addDelayed() {
        try {
            int component1 = 3;
            int component2 = 2;
            int sum = _calculatorDelayed.addDelayed(component1, component2);
            print(String.format("sum: %d", sum));
        } catch (Throwable ex) {
            print(ex);
        }
    }

    private void addDelayedAsync() {
        try {
            int component1 = 3;
            int component2 = 2;
            Response<AddDelayedResponse> response = _calculatorDelayed.addDelayedAsync(component1, component2);
            _addHandler.handleResponse(response);
        } catch (Throwable ex) {
            print(ex);
        }
    }
    
    private void addDelayedAsyncWithHandler() {
        try {
            int component1 = 3;
            int component2 = 2;
            _calculatorDelayed.addDelayedAsync(component1, component2, _addHandler);
        } catch (Throwable ex) {
            print(ex);
        }
    }

    private void subtract() {
        try {
            int minuend = 3;
            int subtrahend = 2;
            int difference = _calculatorDelayed.subtractDelayed(minuend, subtrahend);
            print(String.format("difference: %d", difference));
        } catch (Throwable ex) {
            print(ex);
        }
    }
    
    private void subtractDelayedAsync() {
        try {
            int minuend = 3;
            int subtrahend = 2;
            Response<SubtractDelayedResponse> response = _calculatorDelayed.subtractDelayedAsync(minuend, subtrahend);
            _subtractHandler.handleResponse(response);
        } catch (Throwable ex) {
            print(ex);
        }
    }
    
    private void subtractDelayedAsyncWithHandler() {
        try {
            int minuend = 3;
            int subtrahend = 2;
            _calculatorDelayed.subtractDelayedAsync(minuend, subtrahend, _subtractHandler);
        } catch (Throwable ex) {
            print(ex);
        }
    }
    

    private final class AddHandler implements AsyncHandler<AddDelayedResponse> {

        public void handleResponse(Response<AddDelayedResponse> response) {
            try {
                while (!response.isDone()) {
                    printAwaitingResponse();
                }
                int sum = response.get().getReturn();
                CalculatorDelayedAction.this.print("sum: %d", sum);
            } catch (Throwable ex) {
                print(ex);
            }
        }
    }

    private final class SubtractHandler implements AsyncHandler<SubtractDelayedResponse> {

        public void handleResponse(Response<SubtractDelayedResponse> response) {
            try {
                while (!response.isDone()) {
                    printAwaitingResponse();
                }
                int difference = response.get().getReturn();
                CalculatorDelayedAction.this.print("difference: %d", difference);
            } catch (Throwable ex) {
                print(ex);
            }
        }
    }
}