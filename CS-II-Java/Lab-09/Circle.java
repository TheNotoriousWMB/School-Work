import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	private Color color;
	private int x, y;
	private int radius;

	public Circle(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}

	public boolean drawn(int DEFAULT_WIDTH, int DEFAULT_HEIGHT) {
		if ((x + radius) <= DEFAULT_WIDTH) {
			if ((x - radius) >= 0) {
				if ((y + radius) <= DEFAULT_HEIGHT) {
					if ((y - radius) >= 0) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, radius, radius);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
