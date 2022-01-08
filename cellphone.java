
public class cellphone extends electronic_device{

	private int nbOfCameras;
	
	public cellphone(final String brand, final String serial_number, final String color, 
					 final double price, final String dateOfPurchase, final int nbOfCameras) {
		
		super(brand, serial_number, color, price, dateOfPurchase);
		this.nbOfCameras = nbOfCameras;
	}

	public int getNbOfCameras() {
		return nbOfCameras;
	}

	public void setNbOfCameras(final int nbOfCameras) {
		this.nbOfCameras = nbOfCameras;
	}

	@Override
	public void print() {
		System.out.println(this.getBrand() + "\n" + 
						   this.getSerial_number() + "\n" + 
						   this.getColor() + "\n" + 
						   this.getPrice() + "\n" +
						   this.getDateOfPurchase() + "\n" + 
						   this.getNbOfCameras());
		
		System.out.println();
	}
}
