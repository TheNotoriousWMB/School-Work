import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChessPiecesControlPanel extends JPanel {
	private final int DEFAULT_WIDTH = 120;
	private final int DEFAULT_HEIGHT = 750;

	private final int KING = 0;
	private final int QUEEN = 1;
	private final int BISHOP = 2;
	private final int KNIGHT = 3;
	private final int ROOK = 4;
	private final int PAWN = 5;

	private ChessBoardPanel cbpanel;
	private JButton moveButton;
	private JRadioButton[] pieceButtons;

	public ChessPiecesControlPanel() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

		cbpanel = new ChessBoardPanel();

		pieceButtons = new JRadioButton[6];
		pieceButtons[KING] = new JRadioButton("King", true);
		pieceButtons[QUEEN] = new JRadioButton("Queen");
		pieceButtons[BISHOP] = new JRadioButton("Bishop");
		pieceButtons[KNIGHT] = new JRadioButton("Knight");
		pieceButtons[ROOK] = new JRadioButton("Rook");
		pieceButtons[PAWN] = new JRadioButton("Pawn");

		ButtonGroup group = new ButtonGroup();

		for (int i = 0; i < pieceButtons.length; ++i) {
			group.add(pieceButtons[i]);
			add(pieceButtons[i]);
			pieceButtons[i].addActionListener(new PieceButtonListener());
		}

		moveButton = new JButton("Show Moves");
		add(moveButton);
		moveButton.addActionListener(new MoveButtonListener());
	}

	public class PieceButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == pieceButtons[KING]) {
				ChessPiece c = new King();

				cbpanel.setPiece(c);

				cbpanel.setMoves(false);
			} else if (source == pieceButtons[QUEEN]) {
				ChessPiece c = new Queen();

				cbpanel.setPiece(c);

				cbpanel.setMoves(false);
			} else if (source == pieceButtons[BISHOP]) {
				ChessPiece c = new Bishop();

				cbpanel.setPiece(c);

				cbpanel.setMoves(false);
			} else if (source == pieceButtons[KNIGHT]) {
				ChessPiece c = new Knight();

				cbpanel.setPiece(c);

				cbpanel.setMoves(false);
			} else if (source == pieceButtons[ROOK]) {
				ChessPiece c = new Rook();

				cbpanel.setPiece(c);

				cbpanel.setMoves(false);
			} else if (source == pieceButtons[PAWN]) {
				ChessPiece c = new Pawn();

				cbpanel.setPiece(c);

				cbpanel.setMoves(false);
			}

			cbpanel.repaint();
		}
	}

	public class MoveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cbpanel.setMoves(true);

			cbpanel.repaint();
		}
	}

	public ChessBoardPanel getCbpanel() {
		return cbpanel;
	}

	public void setCbpanel(ChessBoardPanel cbpanel) {
		this.cbpanel = cbpanel;
	}
}
