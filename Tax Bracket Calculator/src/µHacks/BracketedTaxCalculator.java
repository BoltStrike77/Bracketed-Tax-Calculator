package µHacks;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BracketedTaxCalculator {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BracketedTaxCalculator taxCalculator = new BracketedTaxCalculator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private int income;
	private int bracketCount;
	private double avgTax;
	private List<Integer> maximumAmounts, incomeAllotments;
	private List<Double> taxRates, taxAmounts; // per bracket // per bracket
	private double totalTax = 0;

	public BracketedTaxCalculator() {
		setBrackets();
		calculateAllotments();
		calculateTax();
		printResults();
	}

	private void printResults() {
		avgTax = calculateAvgTax();
		JOptionPane.showMessageDialog(null, "The total tax is: $" + totalTax, "Total Tax Due",
				JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "The total income is: $" + income, "Total Income",
				JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "The average tax rate is: " + String.format("%.1f", avgTax) + "%",
				"Average Tax Rate", JOptionPane.INFORMATION_MESSAGE);
		for (int i = 1; i <= bracketCount; i++) {
			JOptionPane.showMessageDialog(null,
					"Bracket #" + i + "'s tax is: $" + String.format("%.2f", taxAmounts.get(i - 1)),
					"Bracket " + i + " Tax Due", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,
					"Bracket #" + i + "'s income allotment is: $" + incomeAllotments.get(i - 1),
					"Bracket " + i + " Allotment Given", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void calculateTax() {
		double taxAmount;
		for (int i = 0; i < bracketCount; i++) {
			taxAmount = incomeAllotments.get(i) * (taxRates.get(i) / 100);
			taxAmounts.add(taxAmount);
			totalTax += taxAmounts.get(i);
		}

	}

	private void calculateAllotments() {
		int temp;
		for (int i = 0; i < bracketCount; i++) {
			if (i == 0) {
				incomeAllotments.add(maximumAmounts.get(i));
			} else {
				temp = maximumAmounts.get(i) - maximumAmounts.get(i - 1);
				incomeAllotments.add(temp);
			}
		}

	}

	private void setBrackets() {
		bracketCount = Integer.parseInt(
				JOptionPane.showInputDialog(null, "How many brackets?", "Bracket Count", JOptionPane.QUESTION_MESSAGE));
		int tempTax1;
		int tempTax2;
		int maxAmt1;
		int maxAmt2;
		maximumAmounts = new ArrayList<Integer>(bracketCount);
		taxRates = new ArrayList<Double>(bracketCount);
		taxAmounts = new ArrayList<Double>(bracketCount);
		incomeAllotments = new ArrayList<Integer>(bracketCount);

		for (int i = 1; i <= bracketCount; i++) {
			try {
				tempTax1 = Integer.parseInt(JOptionPane.showInputDialog(null,
						"What is the tax rate for bracket #" + i + "? (in percentages, 1-100)", "Bracket Tax Rate",
						JOptionPane.QUESTION_MESSAGE));
				if (tempTax1 <= 100 && tempTax1 >= 0) {
					taxRates.add((double) (tempTax1));
				}
			} catch (NumberFormatException e) {
				tempTax2 = Integer.parseInt(JOptionPane.showInputDialog(null,
						"What is the tax rate for bracket #" + i + "? (in percentages, 1-100)",
						"Please reenter the input due to incorrect input", JOptionPane.ERROR_MESSAGE));
				if (tempTax2 <= 100 && tempTax2 > 0) {
					taxRates.add((double) (tempTax2));
				} else {
					JOptionPane.showMessageDialog(null, "Too many failed attempts, system exiting", "Error",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}

			try {
				maxAmt1 = Integer.parseInt(JOptionPane.showInputDialog(null,
						"What is the maximum amount for bracket #" + i + "? (if none, state the total income)",
						"Bracket Max", JOptionPane.QUESTION_MESSAGE));
				if (i == 1) {
					maximumAmounts.add(maxAmt1);
					System.out.println(maximumAmounts.get(0));
					System.out.println(maximumAmounts.get(1-1));
				} else if (maxAmt1 > maximumAmounts.get(i-2)) {
					maximumAmounts.add(Integer.parseInt(JOptionPane.showInputDialog(null,
							"What is the maximum amount for bracket #" + i + "? (if none, state the total income)",
							"Bracket Max", JOptionPane.QUESTION_MESSAGE)));
				} else {
					maxAmt2 = Integer.parseInt(JOptionPane.showInputDialog(null,
							"What is the maximum amount for bracket #" + i + "? (if none, state the total income)",
							"Please reenter the input due to incorrect input", JOptionPane.ERROR_MESSAGE));
					if (maxAmt2 > maximumAmounts.get(i - 1)) {
						maximumAmounts.add(maxAmt2);
					} else {
						JOptionPane.showMessageDialog(null, "Too many failed attempts, system exiting", "Error",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Input was not in number format...", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		income = Integer.parseInt(
				JOptionPane.showInputDialog(null, "What is your income?", "Income", JOptionPane.QUESTION_MESSAGE));

	}

	private double calculateAvgTax() {
		double taxSum = 0;
		for (int i = 0; i < taxRates.size(); i++) {
			taxSum += taxRates.get(i);
		}
		return (taxSum) / (taxRates.size());
	}

}
