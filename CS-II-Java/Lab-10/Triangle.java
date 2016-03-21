import java.awt.Color;
import java.awt.Graphics;

public class Triangle {
	Color color;
	private int[] x;
	private int[] y;

	public Triangle(int[] x, int[] y) {
		this.x = x;
		this.y = y;

		this.color = Color.darkGray;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(x, y, 3);
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}
}
