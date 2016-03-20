import java.awt.Color;
import java.awt.Graphics;

public class ChessBoard {
	ChessBoardSpace[] spaces;

	int width, height;
	int columns, rows;
	int total_spaces;

	public ChessBoard(int width, int height, int dimension) {
		this.width = width;
		this.height = height;
		this.columns = this.rows = dimension;
		this.total_spaces = (columns * rows);

		spaces = new ChessBoardSpace[total_spaces];
	}

	public void draw(Graphics g) {
		int space_width = (width / rows);
		int space_height = (height / columns);

		int space = 0;

		Color tmp;

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j) {
				if ((space % 2) == 0) {
					tmp = new Color(64, 64, 64);
				} else {
					tmp = new Color(192, 192, 192);
				}

				spaces[space] = new ChessBoardSpace((j * space_width),
						(i * space_height), space_width, space_width, tmp);

				++space;
			}
		}

		for (int k = 0; k < total_spaces; ++k) {
			spaces[k].draw(g);
		}
	}

	public ChessBoardSpace[] getSpaces() {
		return spaces;
	}

	public void setSpaces(ChessBoardSpace[] spaces) {
		this.spaces = spaces;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal_spaces() {
		return total_spaces;
	}

	public void setTotal_spaces(int total_spaces) {
		this.total_spaces = total_spaces;
	}
}
