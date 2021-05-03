
public class ItemOrder {
	private Item item;
	private int quantity;
	public ItemOrder(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
	public double getPrice() {
		return this.item.priceForQuantity(this.quantity);
	}
	public Item getItem() {
		return this.item;
	}
}
