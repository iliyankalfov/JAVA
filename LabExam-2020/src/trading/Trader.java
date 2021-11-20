package trading;

import java.util.ArrayList;
import java.util.Random;

public class Trader {
	
	private ArrayList<Trade> trades;
	private Random rand;
	
	public Trader() {
		this.trades = new ArrayList<Trade>();
		addRandomTrade();
	}
	
	public void addRandomTrade() {
		this.rand = new Random();
		int randomGems = rand.nextInt(5) + 1;
		int randomAmount = rand.nextInt(5) + 1;
		
		Goods[] goodsArray = Goods.values();
		int randomIndex = rand.nextInt(goodsArray.length);
		Goods randomGoods = goodsArray[randomIndex];
		
		this.trades.add(new Trade(randomGems, randomAmount, randomGoods));
	}
	public ArrayList<Trade> getTrades() {
		return this.trades;
	}
	
}
