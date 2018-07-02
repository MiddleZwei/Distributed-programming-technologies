package pl.edu.pjwstk.tpr.jaxws.client.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import pl.edu.pjwstk.tpr.jaxws.client.Sample;

public class SampleAction extends PrintMessageActionBase {

	private static final long serialVersionUID = 2162164203579637936L;
	
	public static final String REPLY = "reply";
	
	private final Sample _sample;
	
	public SampleAction(Sample sample, JTextArea output, String actionName) {
		super(output, actionName);
		_sample = sample;
	}

	public void actionPerformed(ActionEvent ev) {
		String request = "REQUEST";
		String response = _sample.reply(request);
		print(response);
	}
}