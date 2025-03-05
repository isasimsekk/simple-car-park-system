//İsa ŞİMŞEK 150122038
// testing our classes with random time values
public class Test {

	public static void main(String[] args) {
		CarPark carPark = new CarPark(10,5);
		
		Vehicle v1 = new Vehicle("34KG3916",4);
		Vehicle v2 = new Vehicle("34GV8993",2);
		Vehicle v3 = new Vehicle("34AN4876",1);
		Vehicle v4 = new Vehicle("50FF444",2);
		Vehicle v5 = new Vehicle("07GZP1923",4);
		
		java.util.Date now = new java.util.Date();
		long NOW = now.getTime();
		Ticket t1 = carPark.parkVehicle(v1, new java.util.Date(NOW + 3600000));
		Ticket t2 = carPark.parkVehicle(v2, new java.util.Date(NOW + 7200000));
		Ticket t3 = carPark.parkVehicle(v3, new java.util.Date(NOW + 10800000));
		Ticket t4 = carPark.parkVehicle(v4, new java.util.Date(NOW + 14400000));
		carPark.parkVehicle(v5, new java.util.Date(NOW));
		System.out.println();
		carPark.printVehicleList();
		
		carPark.exitVehicle(t2, new java.util.Date(NOW + 14400000));
		
		carPark.exitVehicle(t3, new java.util.Date(NOW + 21600000));
		Ticket t5 = carPark.parkVehicle(v5, new java.util.Date(NOW));
		carPark.printVehicleList();
		
		carPark.exitVehicle(t1, new java.util.Date(NOW + 25200000));
		carPark.exitVehicle(t4, new java.util.Date(NOW + 25200000));
		carPark.exitVehicle(t5, new java.util.Date(NOW + 25200000));
		System.out.println();
		System.out.println("The total income is: " + carPark.getTotalIncome()); 
		System.out.println();
		System.out.println("The total number of tickets is: " + Ticket.numberOfTickets);
		System.out.println();
		carPark.printTickets();
	}

}
