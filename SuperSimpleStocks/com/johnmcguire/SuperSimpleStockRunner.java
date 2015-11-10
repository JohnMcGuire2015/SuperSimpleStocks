import java.util.LinkedList;

public class SuperSimpleStockRunner {
	public static void main(String[] args) {

		SSS tea = new SSS("TEA", 0, 100, 213);
		SSS pop = new SSS("POP", 8, 100, 194);
		SSS ale = new SSS("ALE", 23, 60, 97);
		SSS joe = new SSS("JOE", 13, 250, 472);
		SSSprefered gin = new SSSprefered("GIN", 2, 100, 112);

		System.out.format("GIN dividend yield = %f%n", gin.dividendYield());
		System.out.format("POP dividend yield = %f%n", pop.dividendYield());
		System.out.format("POP Price/Earnings ratio = %f%n", pop.PERatio());
		pop.recordTrade(14, 191, true);

		/*
		 * create a list of (fictitious) recent trades for the calculation of a
		 * stock price example.
		 */
		LinkedList recentTrades = new LinkedList();
		int[] tradePrices = { 99, 94, 91, 95, 97, 101 };
		for (int item : tradePrices) {
			recentTrades.add(new SSS("ALE", 23, 60, item));
		}

		System.out.format("ALE stock price: %d%n", ale.calcStockPrice(recentTrades));

		LinkedList GBCEAllShares = new LinkedList();
		GBCEAllShares.add(tea);
		GBCEAllShares.add(pop);
		GBCEAllShares.add(ale);
		GBCEAllShares.add(joe);
		GBCEAllShares.add(gin);
		
		System.out.print("GBCE All Share Index: ");
		System.out.println(SSS.geoMean(GBCEAllShares));
	}
}
