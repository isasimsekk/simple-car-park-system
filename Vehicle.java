//İsa ŞİMŞEK 150122038
//creating a vehicle class
public class Vehicle {
	private String plateNumber;
	private int size;
	
	public Vehicle (String plateNumber, int size) {
		if (size == 1 || size == 2 || size == 4) {
		this.plateNumber = plateNumber;
		this.size = size;
		}
		else
			System.out.println("Invalid size for " + plateNumber);
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public int getSize() {
		return size;
	}
	public String getVehicleInfo () {
		return "Vehicle Info" + "\n" + "Plate number : " 
				+ plateNumber + "\n" + "Size : " + size;
	}
}
