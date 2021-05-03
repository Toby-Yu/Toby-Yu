import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<ItemOrder> itemOrders;
	private boolean hasDiscount;

	public ShoppingCart() {
		super();
		this.itemOrders = new ArrayList<ItemOrder>();
	}

	public void add(ItemOrder itemOrder) {

		for (int i = 0; i < this.itemOrders.size(); i++) {
			if (this.itemOrders.get(i).getItem().equals(itemOrder.getItem())) {
				this.itemOrders.set(i, itemOrder);
				return;
			}
		}

		this.itemOrders.add(itemOrder);
	}

	public void setDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	public double getTotal() {

		double total = 0;

		for (int i = 0; i < this.itemOrders.size(); i++) {
			total += itemOrders.get(i).getPrice();
		}

		return total;
	}
}
