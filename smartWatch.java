
public class smartWatch extends electronic_device {

	private int batteryLife;
	
	public smartWatch(final String brand, final String serial_number, final String color, final double price,
					  final String dateOfPurchase, final int batteryLife) {
		
		super(brand, serial_number, color, price, dateOfPurchase);
		this.batteryLife = batteryLife;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(final int batteryLife) {
		this.batteryLife = batteryLife;
	}

	@Override
	public void print() {
		System.out.println(this.getBrand() + "\n" + 
						   this.getSerial_number() + "\n" + 
						   this.getColor() + "\n" + 
						   this.getPrice() + "\n" +
						   this.getDateOfPurchase() + "\n" + 
						   this.getBatteryLife());
		
		System.out.println();
	}
}
