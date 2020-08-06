
public class Paddleboard extends WaterVehicle {

	public String material;

	public void pack() {
		System.out.println("Paddleboard packed");
	}

	public void move() {
		System.out.println("Paddle in and pulling");
		super.move();
	}

}
