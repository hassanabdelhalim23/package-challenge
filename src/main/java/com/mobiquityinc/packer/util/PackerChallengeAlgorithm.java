
package com.mobiquityinc.packer.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.mobiquityinc.packer.bo.Item;

/**
 * The Class PackerChallengeAlgorithm. the solution we used is call DP since the
 * the problems are overlapping we use a bottom up technique we use table to
 * track the previous solutions so we can select which the best solution that we
 * will use and this a known poblem called a knapsack problem.
 * 
 */
public class PackerChallengeAlgorithm {

	/**
	 * Knap sack.
	 *
	 * @param weight
	 *            the weight
	 * @param items
	 *            the items
	 * @return the double
	 */
	public double knapSack(final Double weight, final List<Item> items) {

		Collections.sort(items);
		final double matrix[][] = new double[items.size() + 1][weight.intValue() + 1];

		for (int elment = 0; elment <= items.size(); elment++) {
			for (int w = 0; w <= weight; w++) {

				if (elment == 0 || w == 0) {
					continue;
				}
				if (items.get(elment - 1).getWeight() <= w) {
					matrix[elment][w] = Math.max(
							items.get(elment - 1).getCost()
									+ matrix[elment - 1][w - items.get(elment - 1).getWeight().intValue()],
							matrix[elment - 1][w]);
				} else {
					matrix[elment][w] = matrix[elment - 1][w];
				}

			}

		}
		getItemsFromknapSack(matrix, weight, items);

		return matrix[matrix.length - 1][matrix[0].length - 1];

	}

	/**
	 * Gets the items fromknap sack.
	 *
	 * @param matrix
	 *            the matrix
	 * @param weight
	 *            the weight
	 * @param items
	 *            the items
	 * @return the items fromknap sack
	 */
	private static void getItemsFromknapSack(final double matrix[][], final Double weight, final List<Item> items) {

		String indexItems = "";
		double response = matrix[matrix.length - 1][matrix[0].length - 1];
		int i;
		int w = weight.intValue();

		for (i = matrix.length-1 ; i > 0 && response > 0; i--) {

			if (response == matrix[i - 1][w]) {
				continue;
			} else {
				indexItems += items.get(i-1).getIndex()+",";
				response = response - items.get(i - 1).getCost();
				w = w - items.get(i - 1).getWeight().intValue();
			}

		}

		if (indexItems.isEmpty()) {
			System.out.println("-");
		} else {
			System.out.println(indexItems.substring(0, indexItems.length() - 1));
		}

	}

}
