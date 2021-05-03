import java.text.NumberFormat;

public class Item {
	private String name;
	private double price;
	private int bulkQuantity;
	private double bulkPrice;

	public Item(String name, double price) {
		super();
		if (price < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.price = price;
	}

	public Item(String name, double price, int bulkQuantity, double bulkPrice) {
		super();
		if (price < 0 || bulkQuantity < 0 || bulkPrice < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.price = price;
		this.bulkQuantity = bulkQuantity;
		this.bulkPrice = bulkPrice;
	}

	public double priceForQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException();
		}
		if (bulkQuantity > 0 && quantity >= bulkQuantity) {
			return quantity / this.bulkQuantity * this.bulkPrice + quantity % this.bulkQuantity * this.price;
		} else {
			return this.price * quantity;
		}
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		if (bulkQuantity == 0) {
			return this.name + ", " + nf.format(this.price);
		} else {
			return this.name + ", " + nf.format(this.price) + " (" + this.bulkQuantity + " for " + this.bulkPrice + ")";
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}

}
