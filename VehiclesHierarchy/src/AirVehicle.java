
public class AirVehicle extends Vehicle {
	
	public int maxAltitude;
	
	public AirVehicle(int maxAltitude) {
		this.maxAltitude=maxAltitude;
	}
	
	public void taxi() {
		System.out.println("Air vehicle taxiing");
	}
}
