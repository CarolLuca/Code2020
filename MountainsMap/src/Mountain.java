
public class Mountain {
	private String name;
	private int elevation;
	private Location loc;

	public String toString() {
		return String.format("[Name: " + name + ", Elevation: " + elevationInM() + "] " + loc.toString());
	}

	public Mountain(String name, int elevation, double lat, double lon) {
		this.name = name;
		this.elevation = elevation;
		this.loc = new Location(lat, lon);
	}

	public double distance(Location loc) {
		return loc.distance(this.loc);
	}

	public double elevationInM() {
		return elevation * 0.3048;
	}

	public boolean taller(Mountain other) {
		return this.elevation < other.elevation;
	}
}
