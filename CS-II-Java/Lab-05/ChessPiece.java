import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

abstract public class ChessPiece {
	protected final int DEFAULT_WIDTH = 750;
	protected final int DEFAULT_HEIGHT = 750;

	protected final int DIMENSION = 5;

	protected int width, height;
	protected int x, y;

	protected ImageIcon icon;

	protected Circle[] circles;

	public ChessPiece() {
		this.width = (DEFAULT_WIDTH / DIMENSION);
		this.height = (DEFAULT_HEIGHT / DIMENSION);

		this.x = ((DEFAULT_WIDTH / 2) - (this.width / 2));
		this.y = ((DEFAULT_HEIGHT / 2) - (this.height / 2));
	}

	abstract public void draw(Component c, Graphics g);

	abstract public void drawMoves(Graphics g);

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Circle[] getCircles() {
		return circles;
	}

	public void setCircles(Circle[] circles) {
		this.circles = circles;
	}
}
