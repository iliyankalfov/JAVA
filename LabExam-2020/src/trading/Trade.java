package trading;

import java.util.List;
import java.util.Objects;

public class Trade {

	private int gems;
	private int amount;
	private Goods goods;
	
	public Trade(int gems, int amount, Goods goods) {
		this.gems = gems;
		this.amount = amount;
		this.goods = goods;
	}

	public int getGems() {
		return gems;
	}

	public int getAmount() {
		return amount;
	}

	public Goods getGoods() {
		return goods;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, gems, goods);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return amount == other.amount && gems == other.gems && goods == other.goods;
	}

	@Override
	public String toString() {
		return this.gems + " gems for " + this.amount + " " + this.goods; 
	}
	
	public void execute(Trader trader, Citizen citizen) {
		List<Trade> traderList = trader.getTrades();
		
		if (traderList.contains(this) == false) {
			throw new IllegalArgumentException();
		}
		else {
			if (citizen.executeTrade(this) == true) {
				trader.addRandomTrade();
			}
		}
			
	}

}
