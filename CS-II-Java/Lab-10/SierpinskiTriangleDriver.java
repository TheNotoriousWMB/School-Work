import javax.swing.JFrame;

public class SierpinskiTriangleDriver {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lab 10 – Sierpinski Triangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new TrianglePrimaryPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
