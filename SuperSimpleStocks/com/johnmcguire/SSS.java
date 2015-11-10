
import java.util.*;
//import java.util.Date;

public class SSS {

	protected String stockSymbol;

	protected int lastDividend; // All prices are in (whole) pennies, hence int
	protected int parValue;
	protected int tickerPrice;

	public SSS(String symbol, int divi, int parv, int tickerp) {
		stockSymbol = symbol;
		lastDividend = divi;
		parValue = parv;
		tickerPrice = tickerp;
	}

	public float dividendYield() { // this method overridden for Preferred
									// Stock

		return ((float) lastDividend / (float) tickerPrice);
	}

	public float PERatio() {

		return ((float) tickerPrice / (float) lastDividend);
	}

	public void recordTrade(int quantity, int price, boolean sell) {

		String indicator = "bought";
		if (sell) {
			indicator = "sold";
		}
		Date date = new Date();
		System.out.format("Trade recorded at: %s %s Quantity: %d Price: %d %s%n", date.toString(), stockSymbol,
				quantity, price, indicator);
	}

	public int calcStockPrice(LinkedList latestTrades) {

		int sumofTrades = 0;
		Iterator it = latestTrades.iterator();
		while (it.hasNext()) {
			sumofTrades += ((SSS) it.next()).tickerPrice;
		}
		return (sumofTrades / latestTrades.size()); // TODO verify list size !=0
	}

	public static double geoMean(LinkedList stockList) {
		/*
		 * TODO ask a responsible adult, or a mathematician, to verify that the
		 * implementation of the formula is correct. This programmer has a less
		 * than complete understanding of the mathematical notation (sigma) used
		 * in the exercise
		 */
		int runningMean = 1;
		Iterator it = stockList.iterator();
		while (it.hasNext()) {
			runningMean *= ((SSS) it.next()).parValue; // TODO Perhaps this
														// should be ticker
														// price - seek advice
		}
		double d = java.lang.Math.pow(runningMean, 1 / stockList.size());
		// TODO verify list size is !=0
		return (d);
	}

};