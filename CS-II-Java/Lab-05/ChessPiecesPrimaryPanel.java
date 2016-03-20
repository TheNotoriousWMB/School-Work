import java.awt.Color;

import javax.swing.JPanel;

public class ChessPiecesPrimaryPanel extends JPanel {
	private ChessPiecesControlPanel control;
	private ChessBoardPanel cbpanel;

	public ChessPiecesPrimaryPanel() {
		setBackground(Color.white);

		control = new ChessPiecesControlPanel();
		cbpanel = new ChessBoardPanel();

		control.setCbpanel(cbpanel);

		add(control);
		add(cbpanel);
	}
}
