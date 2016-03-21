import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class FileIODriver {
	public static void main(String[] args) throws NegativeValueException {
		final String outputFile = ("circles.txt");

		final int DEFAULT_WIDTH = 450;
		final int DEFAULT_HEIGHT = 450;

		ArrayList<CircleData> dataInput = new ArrayList<CircleData>();

		ArrayList<Circle> circles = new ArrayList<Circle>();

		Scanner scan = new Scanner(System.in);

		Random rand = new Random();

		int circleInput;

		String filename = null;

		int circlesRead, circlesDrawn;

		circlesRead = circlesDrawn = 0;

		System.out.print("Please enter an amount of circles: ");
		circleInput = scan.nextInt();

		try {
			if (circleInput < 0) {
				NegativeValueException exception = new NegativeValueException(
						"CAUGHT NEGATIVE VALUE EXCEPTION: Negative value exception");

				throw exception;
			}

			try {
				FileWriter fw = new FileWriter(outputFile);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);

				for (int i = 0; i < circleInput; ++i) {
					pw.println(new CircleData());
				}

				pw.close();

				System.out.println("Output file written: " + outputFile);
				System.out.print("Enter file name: ");
				scan.nextLine();
				filename = scan.nextLine();

				FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				scan = new Scanner(br);
				while (scan.hasNextLine()) {
					String str = scan.nextLine();

					String data[] = str.split(" ");

					double dataDouble[] = new double[data.length];

					for (int j = 0; j < data.length; ++j) {
						dataDouble[j] = Double.parseDouble(data[j]);
					}

					dataInput.add(new CircleData(dataDouble[0], dataDouble[1],
							dataDouble[2], dataDouble[3], dataDouble[4],
							dataDouble[5]));

					circlesRead++;
				}

				br.close();

				for (int k = 0; k < dataInput.size(); ++k) {
					Circle tmp = dataInput.get(k).interpolate(DEFAULT_WIDTH,
							DEFAULT_HEIGHT);

					circles.add(tmp);
				}

				JFrame frame = new JFrame("Lab 9 - File I/O");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				FileIOPrimaryPanel fioppanel = new FileIOPrimaryPanel(circles);
				frame.getContentPane().add(fioppanel);

				frame.pack();
				frame.setVisible(true);

				System.out.println("Number of circles read: " + circlesRead);
			} catch (IOException e) {
				System.err.println("CAUGHT I/O EXCEPTION: " + filename
						+ "(The system cannot find the file specified)");
			}
		} catch (NegativeValueException e) {
			e.printStackTrace();
		}
	}
}
