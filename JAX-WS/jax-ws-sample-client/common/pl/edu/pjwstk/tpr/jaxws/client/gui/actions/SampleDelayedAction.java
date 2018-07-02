package pl.edu.pjwstk.tpr.jaxws.client.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import pl.edu.pjwstk.tpr.jaxws.client.delayed.ReplyDelayedResponse;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.SampleDelayed;

public class SampleDelayedAction extends PrintMessageActionBase {

    private static final long serialVersionUID = 2162164203579637936L;

    public static final String REPLY_DELAYED = "replyDelayed";
    public static final String REPLY_DELAYED_ASYNC = "replyDelayedAsync";
    public static final String REPLY_DELAYED_ASYNC_WITH_HANDLER = "replyDelayedAsyncWithHandler";

    private static final String REQUEST = "REQUEST";

    private final SampleDelayed _sampleDelayed;
    private final ReplyHandler _handler;

    public SampleDelayedAction(SampleDelayed sampleDelayed, JTextArea output, String actionName) {
        super(output, actionName);
        _sampleDelayed = sampleDelayed;
        _handler = new ReplyHandler();
    }

    public void actionPerformed(ActionEvent ev) {
        switch (ev.getActionCommand()) {
            case REPLY_DELAYED:
                replyDelayed();
                break;
            case REPLY_DELAYED_ASYNC:
                replyDelayedAsync();
                break;
            case REPLY_DELAYED_ASYNC_WITH_HANDLER:
                replyDelayedAsyncWithHandler();
                break;
        }
    }

    private void replyDelayed() {
        try {
            String response = _sampleDelayed.replyDelayed(REQUEST);
            print(response);
        } catch (Throwable ex) {
            print(ex);
        }
    }

    private void replyDelayedAsync() {
        try {
            Response<ReplyDelayedResponse> response = _sampleDelayed.replyDelayedAsync(REQUEST);
            _handler.handleResponse(response);
        } catch (Throwable ex) {
            print(ex);
        }
    }

    private void replyDelayedAsyncWithHandler() {
        try {
            _sampleDelayed.replyDelayedAsync(REQUEST, _handler);
        } catch (Throwable ex) {
            print(ex);
        }
    }

    private final class ReplyHandler implements AsyncHandler<ReplyDelayedResponse> {

        public void handleResponse(Response<ReplyDelayedResponse> response) {
            try {
                while (!response.isDone()) {
                    printAwaitingResponse();
                }
                String message = response.get().getReturn();
                SampleDelayedAction.this.print(message);
            } catch (Throwable ex) {
                print(ex.toString());
            }
        }
    }
}