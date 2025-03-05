//İsa ŞİMŞEK 150122038
//creating a ticket class
public class Ticket {
	private Vehicle vehicle;
	private java.util.Date entryDate;
	private java.util.Date exitDate;
	private double totalPrice;
	public static int numberOfTickets = 0;
	
	public Ticket (Vehicle vehicle, java.util.Date entryDate){
		this.entryDate = entryDate;
		this.vehicle = vehicle;
	}
	public double calculatePrice (double hourlyPrice, java.util.Date exitDate) {
		this.exitDate = exitDate;
		totalPrice = (int)((exitDate.getTime() - entryDate.getTime())/3600000.0 + 1) * hourlyPrice * vehicle.getSize();
		return totalPrice;
	}
	public String getTicketInfo() {
		if(exitDate == null) {
			return "Ticket Info" + "\nPlate Number: " + vehicle.getPlateNumber() + "\nEntery: " + entryDate;
		}
		else
		 return "Ticket Info" + "\nPlate Number: " + vehicle.getPlateNumber() + "\nEntery: " + entryDate + "\nExit: " 
		+ exitDate +"\nHour: " + (int)((exitDate.getTime() - entryDate.getTime())/3600000 + 1) + "\nFee: " + totalPrice + "TLs"; 
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public double getPrice() {
		return totalPrice;
	}
}
