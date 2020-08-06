
public class BigCity {
	private String state;
	private String city;
	private int population;
	private Location poz;

	public BigCity(String a, String b, int p, double lat, double lon) {
		this.state = a;
		this.city = b;
		this.population = p;
		this.poz = new Location(lat, lon);
	}

	public boolean ultraPopulat(BigCity c) {
		return c.population > this.population;
	}

	public String toString() {
		return String.format("[State: %s, City: %s, Population: %d], %s", state, city, population, poz.toString());
	}

	public double dist2(Mountain t) {
		return t.distance(poz);
	}
}
