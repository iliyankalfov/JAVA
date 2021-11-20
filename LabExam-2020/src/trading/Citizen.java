package trading;

import java.util.HashMap;
import java.util.Map;

public class Citizen {

	private int gems;
	private Map<Goods, Integer> inventory;
	
	public Citizen(int gems) {
		this.gems = gems;
		this.inventory = new HashMap<Goods, Integer>();
	}
	
	public int getGems() {
		return this.gems;
	}
	
	public int getAmount (Goods goods) {
		return this.inventory.getOrDefault(goods, 0);
	}
	
	public boolean executeTrade (Trade trade) {
		if (this.gems < trade.getGems()) {
			return false;
		}
		else {
			this.gems -= trade.getGems();
			int amountOfGoods = this.getAmount(trade.getGoods());
			
			this.inventory.put(trade.getGoods(), amountOfGoods + trade.getAmount());
			return true;
		}
	}
}
