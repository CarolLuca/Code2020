import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("Hello Mountains Map!");

		File f = new File("mountains2.txt");
		Scanner file = new Scanner(f);

		MountainsMap m = new MountainsMap();

		while (file.hasNextLine()) {
			String line = file.nextLine();
			Scanner parser = new Scanner(line);
			parser.useDelimiter(",");
			m.add(new Mountain(parser.next(), parser.nextInt(), parser.nextDouble(), parser.nextDouble()));
			parser.close();
		}

		Mountain inalt = m.tallestMountain();
		System.out.println("Tallest one and description >: " + inalt.toString());

		System.out.println("Home location >: ");

		Scanner console = new Scanner(System.in);
		String line = console.nextLine();
		Scanner cursor = new Scanner(line);
		cursor.useDelimiter(" ,|, |,");

		Location house = new Location(cursor.nextDouble(), cursor.nextDouble());

		System.out.println(
				"Closest to " + house.toString() + " is identified by >: " + m.closestMountain(house).toString());

		File g = new File("cities.txt");
		Scanner orasel = new Scanner(g);

		CitiesMap c = new CitiesMap();
		while (orasel.hasNextLine()) {
			String row = orasel.nextLine();
			Scanner park = new Scanner(row);
			park.useDelimiter(",");
			c.add(new BigCity(park.next(), park.next(), park.nextInt(), park.nextDouble(), park.nextDouble()));
		}

		System.out.println("The most populated city is described as following >: " + c.metropola().toString());
		System.out.println("The closest city to the tallest mountain is >: " + c.closestToTall(inalt).toString());
		file.close();
		console.close();
		cursor.close();

		System.out.println("Goodbye!");
	}

}
