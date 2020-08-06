
public class WaterVehicle extends Vehicle {
	
	public double displacement;
	
	public void anchor() {
		System.out.println("Water vehicle anchored");
	}
	
	public void move() {
		System.out.println("Water vehicle floating away");
		super.move();
	}
	
	public void checkMoving() {
		if(!this.isMoving)
			System.out.println("In dead waters");
		else System.out.println("River run!");
	}
}
