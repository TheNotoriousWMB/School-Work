import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChessBoardPanel extends JPanel {
	private final int DEFAULT_WIDTH = 750;
	private final int DEFAULT_HEIGHT = 750;

	private final int DIMENSION = 5;

	ChessBoard board;

	ChessPiece piece;

	boolean moves;

	public ChessBoardPanel() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

		board = new ChessBoard(DEFAULT_WIDTH, DEFAULT_HEIGHT, DIMENSION);

		piece = new King();

		moves = false;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		board.draw(g);

		piece.draw(this, g);

		if (moves == true) {
			piece.drawMoves(g);
		}
	}

	public ChessBoard getBoard() {
		return board;
	}

	public void setBoard(ChessBoard board) {
		this.board = board;
	}

	public ChessPiece getPiece() {
		return piece;
	}

	public void setPiece(ChessPiece piece) {
		this.piece = piece;
	}

	public boolean isMoves() {
		return moves;
	}

	public void setMoves(boolean moves) {
		this.moves = moves;
	}
}
