import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Pawn extends ChessPiece {
	public Pawn() {
		super();

		this.icon = new ImageIcon(this.getClass().getResource("pawn.png"));

		circles = new Circle[1];
	}

	public void draw(Component c, Graphics g) {
		Image image = icon.getImage().getScaledInstance(width, height,
				Image.SCALE_SMOOTH);
		icon.setImage(image);

		icon.paintIcon(c, g, x, y);
	}

	public void drawMoves(Graphics g) {
		int circle_width = (this.width / 2);
		int circle_height = (this.height / 2);

		circles[0] = new Circle((int) (width * 2.25), (int) (height * 1.25),
				circle_width, circle_height);

		for (int i = 0; i < circles.length; ++i) {
			circles[i].draw(g);
		}
	}
}
