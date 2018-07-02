package pl.edu.pjwstk.tpr.jaxws.client.gui;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private static final long serialVersionUID = -3067287486381503784L;

    protected ButtonPanel() {
        GridLayout layout = new GridLayout(0, 1, 5, 5);
        setLayout(layout);
    }

    public void add(Action action) {
        JButton button = new JButton(action);
        add(button);
    }
}