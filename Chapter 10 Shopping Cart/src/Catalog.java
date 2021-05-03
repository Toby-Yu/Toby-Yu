import java.util.ArrayList;

public class Catalog {

	private String name;
	private ArrayList<Item> items = new ArrayList<Item>();

	public Catalog(String name) {
		super();
		this.name = name;
	}

	public void add(Item item) {
		this.items.add(item);
	}

	public int size() {
		return this.items.size();
	}

	public Item get(int index) {
		return this.items.get(index);
	}

	public String getName() {
		return this.name;
	}
}
