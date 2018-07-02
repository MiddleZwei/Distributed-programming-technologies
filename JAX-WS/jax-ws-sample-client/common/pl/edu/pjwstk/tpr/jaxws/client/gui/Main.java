package pl.edu.pjwstk.tpr.jaxws.client.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import pl.edu.pjwstk.tpr.jaxws.client.Calculator;
import pl.edu.pjwstk.tpr.jaxws.client.Sample;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.CalculatorDelayed;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.SampleDelayed;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy.CalculatorDelayedProxy;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy.SampleDelayedProxy;
import pl.edu.pjwstk.tpr.jaxws.client.gui.actions.CalculatorAction;
import pl.edu.pjwstk.tpr.jaxws.client.gui.actions.CalculatorDelayedAction;
import pl.edu.pjwstk.tpr.jaxws.client.gui.actions.SampleAction;
import pl.edu.pjwstk.tpr.jaxws.client.gui.actions.SampleDelayedAction;
import pl.edu.pjwstk.tpr.jaxws.client.proxy.CalculatorProxy;
import pl.edu.pjwstk.tpr.jaxws.client.proxy.SampleProxy;

public final class Main extends JFrame {

	private static final long serialVersionUID = -3938761182479817335L;
	
	private static final Dimension SIZE = new Dimension(800, 600);

	private final JScrollPane _txt;
	private final JTextArea _txtOutput;

	private final ButtonPanel _pnlSampleCalculator;
	private final ButtonPanel _pnlSampleCalculatorDelayed;
	private final ButtonPanel _pnlSampleCalculatorDelayedAsync;
	private final ButtonPanel _pnlSampleCalculatorDelayedAsyncWithHandler;

	private final Sample _sample;
	private final SampleDelayed _sampleDelayed;
	private final Calculator _calculator;
	private final CalculatorDelayed _calculatorDelayed;

	private Main() {
		_txtOutput = new JTextArea(20, 60);
		DefaultCaret caret = (DefaultCaret)_txtOutput.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		_txt = new JScrollPane(_txtOutput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		_sample = new SampleProxy();
		_sampleDelayed = new SampleDelayedProxy();
		_calculator = new CalculatorProxy();
		_calculatorDelayed = new CalculatorDelayedProxy();

		_pnlSampleCalculator = new ButtonPanel();
		_pnlSampleCalculator.add(new SampleAction(_sample, _txtOutput, SampleAction.REPLY));
		_pnlSampleCalculator.add(new CalculatorAction(_calculator, _txtOutput, CalculatorAction.ADD));
		_pnlSampleCalculator.add(new CalculatorAction(_calculator, _txtOutput, CalculatorAction.SUBTRACT));

		_pnlSampleCalculatorDelayed = new ButtonPanel();
		_pnlSampleCalculatorDelayed
				.add(new SampleDelayedAction(_sampleDelayed, _txtOutput, SampleDelayedAction.REPLY_DELAYED));
		_pnlSampleCalculatorDelayed
				.add(new CalculatorDelayedAction(_calculatorDelayed, _txtOutput, CalculatorDelayedAction.ADD_DELAYED));
		_pnlSampleCalculatorDelayed.add(
				new CalculatorDelayedAction(_calculatorDelayed, _txtOutput, CalculatorDelayedAction.SUBTRACT_DELAYED));

		_pnlSampleCalculatorDelayedAsync = new ButtonPanel();
		_pnlSampleCalculatorDelayedAsync
				.add(new SampleDelayedAction(_sampleDelayed, _txtOutput, SampleDelayedAction.REPLY_DELAYED_ASYNC));
		_pnlSampleCalculatorDelayedAsync.add(
				new CalculatorDelayedAction(_calculatorDelayed, _txtOutput, CalculatorDelayedAction.ADD_DELAYED_ASYNC));
		_pnlSampleCalculatorDelayedAsync.add(new CalculatorDelayedAction(_calculatorDelayed, _txtOutput,
				CalculatorDelayedAction.SUBTRACT_DELAYED_ASYNC));

		_pnlSampleCalculatorDelayedAsyncWithHandler = new ButtonPanel();
		_pnlSampleCalculatorDelayedAsyncWithHandler.add(new SampleDelayedAction(_sampleDelayed, _txtOutput,
				SampleDelayedAction.REPLY_DELAYED_ASYNC_WITH_HANDLER));
		_pnlSampleCalculatorDelayedAsyncWithHandler.add(new CalculatorDelayedAction(_calculatorDelayed, _txtOutput,
				CalculatorDelayedAction.ADD_DELAYED_ASYNC_WITH_HANDLER));
		_pnlSampleCalculatorDelayedAsyncWithHandler.add(new CalculatorDelayedAction(_calculatorDelayed, _txtOutput,
				CalculatorDelayedAction.SUBTRACT_DELAYED_ASYNC_WITH_HANDLER));
		layoutComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return SIZE;
	}
	
	@Override
	public Dimension getMinimumSize() {
		return SIZE;
	}

	private void layoutComponents() {
		Container container = getContentPane();
		JPanel buttons = buttons();
		GridLayout layout = new GridLayout(2, 1);
		container.setLayout(layout);
		container.add(_txt);
		container.add(buttons);
	}
	
	private JPanel buttons() {
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(1, 4);
		panel.setLayout(layout);
		panel.add(_pnlSampleCalculator);
		panel.add(_pnlSampleCalculatorDelayed);
		panel.add(_pnlSampleCalculatorDelayedAsync);
		panel.add(_pnlSampleCalculatorDelayedAsyncWithHandler);
		return panel;
	}

	public static void main(String... args) {
		Main main = new Main();
		main.setVisible(true);
	}
}