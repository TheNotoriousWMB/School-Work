import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class TrianglePrimaryPanel extends JPanel {
	private TriangleControlPanel control;
	private TrianglePanel tpanel;

	public TrianglePrimaryPanel() {
		setLayout(new BorderLayout());

		setBackground(Color.white);

		control = new TriangleControlPanel();
		tpanel = new TrianglePanel();

		control.setTpanel(tpanel);

		add(control, BorderLayout.NORTH);
		add(tpanel, BorderLayout.CENTER);
	}
}
