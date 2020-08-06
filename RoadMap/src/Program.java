import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Hello to Road Map!");

		RoadMap rmap = new RoadMap();
		File roadsDb = new File("roads.txt");
		Scanner input = new Scanner(roadsDb);
		while (input.hasNextLine()) {
			Scanner parser = new Scanner(input.nextLine());
			parser.useDelimiter("-");
			City fromCity = rmap.addCity(new City(parser.next()));
			City toCity = rmap.addCity(new City(parser.next()));

			fromCity.addVec(toCity);
			toCity.addVec(fromCity);
			parser.close();
		}
		input.close();
		String connectedMessage = (rmap.isConnected() ? "connected" : "not connected");
		System.out.printf("Road map is %s\n", connectedMessage);
		System.out.println("Goodbye!");

	}

}
