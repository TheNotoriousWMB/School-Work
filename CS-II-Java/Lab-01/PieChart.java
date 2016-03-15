/******************************************************************************
 * Write an applet that draws a pie chart with eight equal slices, all colored 
 * differently with random colors and black outlines as shown.
 ******************************************************************************/

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.util.Random;
import java.lang.Math;

public class PieChart extends JApplet {
	public void paint(Graphics page) {
		Random generator = new Random();

		int red, green, blue;

		final int width = 400;
		final int height = 400;

		setSize(width, height);

		final int x = width / 6;
		final int y = height / 6;
		int dimX = 2 * width / 3;
		int dimY = 2 * height / 3;

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		Color color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 0, 45);

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 45, 45);

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 90, 45);

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 135, 45);

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 180, 45);

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 225, 45);

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 270, 45);

		red = generator.nextInt(256);
		green = generator.nextInt(256);
		blue = generator.nextInt(256);
		color = new Color(red, green, blue);
		page.setColor(color);
		page.fillArc(x, y, dimX, dimY, 315, 45);

		double dimX_45_dbl = ((dimX / 2) + x)
				+ ((dimX / 2) * Math.cos(Math.toRadians(45)));
		double dimY_45_dbl = ((dimY / 2) + y)
				+ ((dimX / 2) * Math.sin(Math.toRadians(45)));
		int dimX_45 = (int) dimX_45_dbl;
		int dimY_45 = (int) dimY_45_dbl;

		double dimX_135_dbl = ((dimX / 2) + x)
				+ ((dimX / 2) * Math.cos(Math.toRadians(135)));
		double dimY_135_dbl = ((dimY / 2) + y)
				+ ((dimX / 2) * Math.sin(Math.toRadians(135)));
		int dimX_135 = (int) dimX_135_dbl;
		int dimY_135 = (int) dimY_135_dbl;

		double dimX_225_dbl = ((dimX / 2) + x)
				+ ((dimX / 2) * Math.cos(Math.toRadians(225)));
		double dimY_225_dbl = ((dimY / 2) + y)
				+ ((dimX / 2) * Math.sin(Math.toRadians(225)));
		int dimX_225 = (int) dimX_225_dbl;
		int dimY_225 = (int) dimY_225_dbl;

		double dimX_315_dbl = ((dimX / 2) + x)
				+ ((dimX / 2) * Math.cos(Math.toRadians(315)));
		double dimY_315_dbl = ((dimY / 2) + y)
				+ ((dimX / 2) * Math.sin(Math.toRadians(315)));
		int dimX_315 = (int) dimX_315_dbl;
		int dimY_315 = (int) dimY_315_dbl;

		page.setColor(Color.black);
		page.drawOval(x, y, dimX, dimY);
		page.drawLine(x, (dimY / 2) + y, dimX + x, (dimY / 2) + y);
		page.drawLine((dimX / 2) + x, y, (dimX / 2) + x, dimY + y);
		page.drawLine(dimX_45, dimY_45, dimX_225, dimY_225);
		page.drawLine(dimX_135, dimY_135, dimX_315, dimY_315);
	}
}
