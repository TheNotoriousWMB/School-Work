import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {
	private final int DEFAULT_WIDTH = 450;
	private final int DEFAULT_HEIGHT = 450;

	ArrayList<Circle> circles;

	int circlesDrawn;

	boolean circlesDrawnPrinted; // To prevent reprinting

	public CirclePanel(ArrayList<Circle> circles) {
		this.circles = circles;

		this.circlesDrawn = 0;

		this.circlesDrawnPrinted = false;

		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

		setBackground(Color.darkGray);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		circlesDrawn = 0;

		for (int i = 0; i < circles.size(); ++i) {
			if (circles.get(i).drawn(DEFAULT_WIDTH, DEFAULT_HEIGHT) == true) {
				circles.get(i).draw(g);

				circlesDrawn++;
			}
		}

		if (!circlesDrawnPrinted) // Prevents reprinting
		{
			System.out.println("Number of circles drawn: " + circlesDrawn);
		}

		circlesDrawnPrinted = true;
	}

	public ArrayList<Circle> getCircles() {
		return circles;
	}

	public void setCircles(ArrayList<Circle> circles) {
		this.circles = circles;
	}

	public int getCirclesDrawn() {
		return circlesDrawn;
	}

	public void setCirclesDrawn(int circlesDrawn) {
		this.circlesDrawn = circlesDrawn;
	}

	public int getDEFAULT_WIDTH() {
		return DEFAULT_WIDTH;
	}

	public int getDEFAULT_HEIGHT() {
		return DEFAULT_HEIGHT;
	}
}
