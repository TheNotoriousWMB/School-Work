import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	int x, y;
	int width, height;

	Circle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g) {
		Color tmp = new Color(255, 51, 51);

		g.setColor(tmp);
		g.fillOval(x, y, width, height);
	}
}
