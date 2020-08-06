
public class Program {

	public static void main(String[] args) {
		GroundVehicle g = new GroundVehicle();
		WaterVehicle w = new WaterVehicle();
		Paddleboard p = new Paddleboard();
		AirVehicle a = new AirVehicle(10000);
		Vehicle v = new Vehicle();

		// Slide 4
//		g.park();
//		w.stop();
//		p.pack();
//		p.anchor();
//		p.move();
//		a.taxi();
//		a.move();

		// Slide 5
//		Yacht y = new Yacht();
//		p.move();
//		w.move();
//		a.move();
//		y.move();

//		w.move();
//		w.checkMoving();
//		w.stop();
//		w.checkMoving();
		
		Balloon b = new Balloon(100);
	}
}
