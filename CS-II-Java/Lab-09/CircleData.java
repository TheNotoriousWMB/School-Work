import java.awt.Color;
import java.util.Random;

public class CircleData {
	private Random rand = new Random();

	private double xDbl, yDbl;
	private double radiusDbl;
	private double redDbl, greenDbl, blueDbl;

	public CircleData() {
		this.xDbl = rand.nextDouble();
		this.yDbl = rand.nextDouble();

		this.radiusDbl = rand.nextDouble();

		this.redDbl = rand.nextDouble();
		this.greenDbl = rand.nextDouble();
		this.blueDbl = rand.nextDouble();
	}

	public CircleData(double xDbl, double yDbl, double radiusDbl,
			double redDbl, double greenDbl, double blueDbl) {
		this.xDbl = xDbl;
		this.yDbl = yDbl;

		this.radiusDbl = radiusDbl;

		this.redDbl = redDbl;
		this.greenDbl = greenDbl;
		this.blueDbl = blueDbl;
	}

	public Circle interpolate(int DEFAULT_WIDTH, int DEFAULT_HEIGHT) {
		int width = (DEFAULT_WIDTH / 2);

		Color color;
		int r, g, b;
		int x, y;
		int radius;

		x = (int) (xDbl * DEFAULT_WIDTH);
		y = (int) (yDbl * DEFAULT_HEIGHT);

		radius = (int) (radiusDbl * width);

		r = (int) (redDbl * 255);
		g = (int) (greenDbl * 255);
		b = (int) (blueDbl * 255);

		color = new Color(r, g, b, 100);

		Circle tmp = new Circle(x, y, radius, color);

		return tmp;
	}

	public String toString() {
		return (xDbl + " " + yDbl + " " + radiusDbl + " " + redDbl + " "
				+ greenDbl + " " + blueDbl);
	}

	public double getxDbl() {
		return xDbl;
	}

	public void setxDbl(double xDbl) {
		this.xDbl = xDbl;
	}

	public double getyDbl() {
		return yDbl;
	}

	public void setyDbl(double yDbl) {
		this.yDbl = yDbl;
	}

	public double getRadiusDbl() {
		return radiusDbl;
	}

	public void setRadiusDbl(double radiusDbl) {
		this.radiusDbl = radiusDbl;
	}

	public double getRedDbl() {
		return redDbl;
	}

	public void setRedDbl(double redDbl) {
		this.redDbl = redDbl;
	}

	public double getGreenDbl() {
		return greenDbl;
	}

	public void setGreenDbl(double greenDbl) {
		this.greenDbl = greenDbl;
	}

	public double getBlueDbl() {
		return blueDbl;
	}

	public void setBlueDbl(double blueDbl) {
		this.blueDbl = blueDbl;
	}
}
