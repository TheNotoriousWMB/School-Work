import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Fast {
	public static void main(String[] args) {
		// rescale coordinates and turn on animation mode
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		StdDraw.show(0);

		// read in the input
		int N = StdIn.readInt();
		Point points[] = new Point[N];
		for (int i = 0; i < N; ++i) {
			int x = StdIn.readInt();
			int y = StdIn.readInt();
			points[i] = new Point(x, y);

			// Draw all of the points we read in
			StdDraw.setPenRadius(0.015);
			StdDraw.setPenColor(StdDraw.BLACK);
			points[i].draw();
		}

		// Create a copy of our primary array of points which we can freely
		//  manipulate
		Point[] pointsCopy = new Point[points.length];
		pointsCopy = Arrays.copyOf(points, points.length);

		// For each point in the primary array of points, sort the copy array
		//  based upon the slope of each point with reference to the origin
		//  points from the primary array of points
		for (Point origin : points) {
			Arrays.sort(pointsCopy, origin.SLOPE_ORDER);

			// Find all lines from the origin to other points
			lines(pointsCopy);
		}

		// display to screen all at once
		StdDraw.show(0);
	}

	public static void lines(Point[] points) {
		// Designate origin point for use in referencing other points
		Point origin = points[0];

		// Create an array of points which will be used to store collinear
		//  points. Use length of points array as the length for this array just
		//  to account for potential worst-case
		Point[] collinear = new Point[points.length];
		collinear[0] = origin;

		// Reusable variables for storing the last known slope and the current
		//  tabulation of collinear points
		double prevSlope = 0.0;
		int count = 0;

		// For each point in the points array aside from the origin point
		for (int i = 1; i < points.length; ++i) {
			// If the slope from the origin to this point is equal to the
			//  previously noted slope, increase the tabulation of collinear
			//  points and add this point to the array of collinear points
			//
			// Otherwise, if the tabulation of collinear points of the
			//  previously noted slope is greater than or equal to 3 (meaning 4
			//  or more collinear points while also accounting for the origin),
			//  we display the array of collinear points. Then, reset the
			//  tabulation of of collinear points to 1, referring to the slope of
			//  the current point
			if (origin.slopeTo(points[i]) == prevSlope) {
				++count;

				collinear[count] = points[i];
			} else {
				if (count >= 3)
					displayCollinearPoints(collinear, ++count);

				count = 1;

				collinear[1] = points[i];
			}

			// Set the slope from the origin to the current point as the
			//  previously noted slope
			prevSlope = origin.slopeTo(points[i]);
		}

		// If the tabulation of collinear points of the previously noted slope
		//  is greater than or equal to 3 (meaning 4 or more collinear points
		//  while also accounting for the origin), we display the array of
		//  collinear points. We repeat this process here, outside of the loop,
		//  to account for the case in which the last 3 (or more) points to be
		//  processed in the array are collinear and we don't have the breaking
		//  of this trend to act as a sentinel
		if (count >= 3)
			displayCollinearPoints(collinear, ++count);
	}

	public static void displayCollinearPoints(Point[] collinear, int size) {
		// Sort points in string after origin
		Arrays.sort(collinear, 1, size);

		// Minimal representation check. Eliminates redundancy of sets of
		//  collinear points by ensuring the origin point is lesser by our
		//  definition (check for smaller y-value, then for smaller x-value)
		if (collinear[0].compareTo(collinear[1]) < 0) {
			StdOut.print(size + ": " + collinear[0]);

			for (int i = 1; i < size; ++i)
				StdOut.print(" -> " + collinear[i]);

			StdOut.println();

			// Draw lines to all of the collinear points
			for (int i = 1; i < size; ++i) {
				StdDraw.setPenRadius(0.005);
				StdDraw.setPenColor(StdDraw.RED);
				collinear[0].drawTo(collinear[i]);
			}
		}
	}
}
