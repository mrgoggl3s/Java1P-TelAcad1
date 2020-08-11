package Stream.entity;

public class OrderLine {
	
	public enum Status {
	}

	private Product product;
	private int count;
	private boolean specialOffer;
	private Status status;

	public OrderLine(Product product, int items) {
		this.product = product;
		this.count = items;
	}
	public OrderLine() {
	}
	
	public OrderLine(Status status) {
		this.status = status;
	}
	public boolean isSpecialOffer() {
		return specialOffer;
	}

	public OrderLine setSpecialOffer(boolean specialOffer) {
		this.specialOffer = specialOffer;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public boolean wasDelivered() {
		return true;
	}
	
	
	
}
