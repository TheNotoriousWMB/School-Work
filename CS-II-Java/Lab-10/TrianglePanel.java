import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TrianglePanel extends JPanel {
	private final int DEFAULT_WIDTH = 375;
	private final int DEFAULT_HEIGHT = 375;

	private int x1, x3, x5;
	private int y1, y3;

	private int current;

	public TrianglePanel() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setBackground(Color.lightGray);

		this.x1 = 0;
		this.x5 = DEFAULT_WIDTH;
		this.x3 = (x5 / 2);

		this.y1 = DEFAULT_HEIGHT;
		this.y3 = 0;

		this.current = 0;
	}

	public void drawTriangles(int iteration, int x1, int x3, int x5, int y1,
			int y3, Graphics g) {
		int x2, x4;
		int y2;

		if (iteration == 0) // Base case
		{
			int[] x = new int[] { x1, x3, x5 };
			int[] y = new int[] { y1, y3, y1 };

			Triangle tmp = new Triangle(x, y);
			tmp.draw(g);
		} else // Recursive definition
		{
			x2 = averageOf(x1, x3);
			x4 = averageOf(x3, x5);

			y2 = averageOf(y1, y3);

			drawTriangles((iteration - 1), x1, x2, x3, y1, y2, g);
			drawTriangles((iteration - 1), x2, x3, x4, y2, y3, g);
			drawTriangles((iteration - 1), x3, x4, x5, y1, y2, g);
		}
	}

	public int averageOf(int a, int b) {
		return ((a + b) / 2);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawTriangles(current, x1, x3, x5, y1, y3, g);
	}

	public int getIteration() {
		return current;
	}

	public void setIteration(int iteration) {
		this.current = iteration;
	}
}
