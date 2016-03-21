import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TriangleControlPanel extends JPanel {
	private final int DEFAULT_WIDTH = 375;
	private final int DEFAULT_HEIGHT = 45;

	private TrianglePanel tpanel;
	private JButton[] iterationButtons;
	private JLabel iterationLabel;

	private int iteration;

	public TriangleControlPanel() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setBackground(new Color(224, 224, 224));

		tpanel = new TrianglePanel();

		iterationButtons = new JButton[2];
		iterationButtons[0] = new JButton("increase");
		iterationButtons[1] = new JButton("decrease");
		add(iterationButtons[0]);
		add(iterationButtons[1]);
		iterationButtons[0].addActionListener(new IterationButtonListener());
		iterationButtons[1].addActionListener(new IterationButtonListener());

		iteration = 0;
		iterationLabel = new JLabel("Iteration: " + iteration);
		add(iterationLabel);
	}

	public class IterationButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == iterationButtons[0]) {
				if (iteration < 8) {
					++iteration;

					tpanel.setIteration(iteration);
				}
			}
			if (source == iterationButtons[1]) {
				if (iteration > 0) {
					--iteration;

					tpanel.setIteration(iteration);
				}
			}

			iterationLabel.setText("Iteration: " + iteration);
			tpanel.repaint();
		}
	}

	public TrianglePanel getTpanel() {
		return tpanel;
	}

	public void setTpanel(TrianglePanel tpanel) {
		this.tpanel = tpanel;
	}
}
