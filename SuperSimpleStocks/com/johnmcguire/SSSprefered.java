
public class SSSprefered extends SSS {

	int fixedDividend;

	public SSSprefered (String symbol, int divi, int parv, int tickerp) {
		
		super(symbol, divi, parv, tickerp);
		
		stockSymbol = symbol;
		fixedDividend = divi;
		parValue = parv;
		tickerPrice = tickerp;

	}

	public float dividendYield() {
System.out.println(fixedDividend);
System.out.println(parValue);
System.out.println(tickerPrice);

		return ((float) fixedDividend/100 * (float) parValue / (float) tickerPrice);
	}

}
