//İsa ŞİMŞEK 150122038
//creating a parkplace class
public class ParkPlace {
	private int size;
	private Vehicle vehicle;
	
	public ParkPlace (Vehicle vehicle){
		this.vehicle = vehicle;
		this.size = vehicle.getSize(); 
	}
	public int getSize() {
		return size;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
}
