import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

	// compare points by slope
	public final Comparator<Point> SLOPE_ORDER = new ComparePoints();

	private final int x; // x coordinate
	private final int y; // y coordinate

	// create the point (x, y)
	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	// plot this point to standard drawing
	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	// draw line between this point and that point to standard drawing
	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	// slope between this point and that point
	public double slopeTo(Point that) {
		if (this.compareTo(that) == 0)
			return -(1.0 / 0);
		else if (this.x == that.x)
			return (1.0 / 0);
		else if (this.y == that.y)
			return 0.0;
		else
			return ((1.0 * (that.y - this.y)) / (1.0 * (that.x - this.x)));
	}

	// is this point lexicographically smaller than that one?
	// comparing y-coordinates and breaking ties by x-coordinates
	public int compareTo(Point that) {
		if (this.y < that.y)
			return -1;
		else if (this.y > that.y)
			return 1;
		else {
			if (this.x < that.x)
				return -1;
			else if (this.x > that.x)
				return 1;
			else
				return 0;
		}
	}

	// Check if 4 points are collinear
	public boolean areCollinear(Point a, Point b, Point c) {
		return (this.slopeTo(a) == this.slopeTo(b)
				&& this.slopeTo(b) == this.slopeTo(c) 
				&& this.slopeTo(a) == this.slopeTo(c));
	}

	// Check if 5 points are collinear
	public boolean areCollinear(Point a, Point b, Point c, Point d) {
		return (this.slopeTo(a) == this.slopeTo(b)
				&& this.slopeTo(b) == this.slopeTo(c)
				&& this.slopeTo(c) == this.slopeTo(d)
				&& this.slopeTo(a) == this.slopeTo(c)
				&& this.slopeTo(b) == this.slopeTo(d) 
				&& this.slopeTo(a) == this.slopeTo(d));
	}

	// return string representation of this point
	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}

	public class ComparePoints implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			if (slopeTo(o1) < slopeTo(o2))
				return -1;
			else if (slopeTo(o1) > slopeTo(o2))
				return 1;
			else {
				if (o1.compareTo(o2) == -1)
					return -1;
				else if (o1.compareTo(o2) == 1)
					return 1;
				else
					return 0;
			}
		}

	}

	// unit test
	public static void main(String[] args) {
		/* YOUR CODE HERE */
	}
}
