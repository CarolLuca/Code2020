
public class Vehicle {
	
	public double length;
	public double maxSpeed;
	public boolean isMoving;
	
	public void move() {
		isMoving = true;
		System.out.println("Vehicle moving");
	}
	
	public void stop() {
		isMoving = false;
		System.out.println("Vehicle stopped");
	}
}
