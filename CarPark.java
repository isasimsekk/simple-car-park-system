//İsa ŞİMŞEK 150122038
//creating a carpark class
public class CarPark {
	private int capacity;
	public ParkPlace[] parkPlaceArray = new ParkPlace[0];
	public Ticket [] ticketArray = new Ticket[0]; 
	private double hourlyPrice;
	
	public CarPark (int capacity, double hourlyPrice) {
		this.capacity = capacity;
		this.hourlyPrice = hourlyPrice;
	}
	public Ticket parkVehicle (Vehicle vehicle, java.util.Date entryDate) {
		if (capacity < vehicle.getSize()) {
			System.out.println("Car park is full!");
		return null;
		}
		else {
			ParkPlace parkPlace = new ParkPlace(vehicle); 
			Ticket ticket = new Ticket (vehicle , entryDate);
			Ticket.numberOfTickets++;
			System.out.println("The vehicle with " + vehicle.getPlateNumber() + " plate number is parked.");
			
			//update parkPlaceArray
			ParkPlace[] temp = new ParkPlace[parkPlaceArray.length + 1];
			if (parkPlaceArray.length != 0) {
			for (int i = 0; i < parkPlaceArray.length; i++) {
				temp[i] = parkPlaceArray[i];
			}
			}
			temp[parkPlaceArray.length] = parkPlace; 
			parkPlaceArray = temp;
			
			//decrease capacity because there is a new vehicle enterence to the park place
			capacity -= vehicle.getSize();
			return ticket;
		}
	}
	public Vehicle exitVehicle (Ticket ticket, java.util.Date exitDate) {
		//update park place array since one of the cars have left
		int index = 0;
		for (int i = 0; i < parkPlaceArray.length; i++) {
			if(parkPlaceArray[i].getVehicle().getPlateNumber().equals(ticket.getVehicle().getPlateNumber()));
			index = i;
		}
		ParkPlace[] temp = new ParkPlace[parkPlaceArray.length-1];
		for (int i = 0, j = 0; i < parkPlaceArray.length; i++, j++) {
			if (index == i) {
				j--;
				continue;
			}
			temp[j] = parkPlaceArray[i];
		}
		parkPlaceArray = temp;
		
		//create a ticket object and update the ticketArray
		Ticket [] tempT = new Ticket[ticketArray.length + 1];
		if (ticketArray.length != 0) {
			for (int i = 0; i < ticketArray.length; i++) {
				tempT[i] = ticketArray[i];
			}
			}
		tempT[ticketArray.length] = ticket;
		ticketArray = tempT;
		
		ticket.calculatePrice(hourlyPrice, exitDate);
		System.out.println("The price for vehicle with " + ticket.getVehicle().getPlateNumber() +" plate number is: " + ticket.getPrice() + " TLs");
		
		capacity += ticket.getVehicle().getSize();
		return ticket.getVehicle();
		
	}
	public double getTotalIncome () {
		double sum = 0;
		for (int i = 0; i < ticketArray.length; i++) {
			sum += ticketArray[i].getPrice();
		}
		return sum;
	}
	public void printVehicleList() {
		for(int i = 0; i < parkPlaceArray.length; i++) {
			System.out.println(parkPlaceArray[i].getVehicle().getVehicleInfo());
			System.out.println();
		}
	}
	public void printTickets () {
	    for(int i = 0; i < ticketArray.length; i++) {
	    	System.out.println(	ticketArray[i].getTicketInfo());
	    	System.out.println();
	    }
	}
}
