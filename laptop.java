
public class laptop extends electronic_device {

	private int nbOfCores;
	private boolean touchScreen;
	
	public laptop(final String brand, final String serial_number, final String color, final double price, 
				  final String dateOfPurchase, final int nbOfCores, final boolean touchScreen) {
		
		super(brand, serial_number, color, price, dateOfPurchase);
		this.nbOfCores = nbOfCores;
		this.touchScreen = touchScreen;
	}

	public int getNbOfCores() {
		return nbOfCores;
	}

	public void setNbOfCores(final int nbOfCores) {
		this.nbOfCores = nbOfCores;
	}

	public boolean isTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(final boolean touchScreen) {
		this.touchScreen = touchScreen;
	}

	@Override
	public void print() {
		System.out.println(this.getBrand() + "\n" + 
						   this.getSerial_number() + "\n" + 
						   this.getColor() + "\n" + 
						   this.getPrice() + "\n" +
						   this.getDateOfPurchase() + "\n" + 
						   this.getNbOfCores() + "\n" +
						   this.isTouchScreen());
		
		System.out.println();
	}
}
