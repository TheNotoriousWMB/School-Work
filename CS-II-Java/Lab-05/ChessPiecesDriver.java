import javax.swing.JFrame;

public class ChessPiecesDriver {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lab 5 - Chess Pieces");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new ChessPiecesPrimaryPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
