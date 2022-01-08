
public abstract class electronic_device {

	private String brand;
	private String serial_number;
	private String color;
	private double price;
	private String dateOfPurchase;
	
	
	public electronic_device(final String brand, final String serial_number, final String color,
							 final double price, final String dateOfPurchase) {
		
		this.brand = brand;
		this.serial_number = serial_number;
		this.color = color;
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(final String brand) {
		this.brand = brand;
	}


	public String getSerial_number() {
		return serial_number;
	}


	public void setSerial_number(final String serial_number) {
		this.serial_number = serial_number;
	}

	public String getColor() {
		return color;
	}


	public void setColor(final String color) {
		this.color = color;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(final double price) {
		this.price = price;
	}


	public String getDateOfPurchase() {
		return dateOfPurchase;
	}


	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	
	public abstract void print();
}
