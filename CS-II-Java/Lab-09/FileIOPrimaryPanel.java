import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FileIOPrimaryPanel extends JPanel {
	private final int DEFAULT_WIDTH = 450;
	private final int DEFAULT_HEIGHT = 450;

	ArrayList<Circle> circles;

	CirclePanel cpanel;

	public FileIOPrimaryPanel(ArrayList<Circle> circles) {
		this.circles = circles;

		setBackground(Color.lightGray);

		cpanel = new CirclePanel(circles);

		add(cpanel);
	}

	public ArrayList<Circle> getCircles() {
		return circles;
	}

	public void setCircles(ArrayList<Circle> circles) {
		this.circles = circles;
	}

	public CirclePanel getCpanel() {
		return cpanel;
	}

	public void setCpanel(CirclePanel cpanel) {
		this.cpanel = cpanel;
	}

	public int getDEFAULT_WIDTH() {
		return DEFAULT_WIDTH;
	}

	public int getDEFAULT_HEIGHT() {
		return DEFAULT_HEIGHT;
	}
}
