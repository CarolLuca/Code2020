
public class Location {
	private double lat;
	private double lon;

	public Location(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public String toString() {
		return String.format("[Lat=%f, Lon=%f]", lat, lon);
	}

	public double distance(double lat, double lon) {
		double dlat = this.lat - lat;
		double dlon = this.lon - lon;
		return Math.sqrt(dlat * dlat + dlon * dlon);
	}

	public double distance(Location other) {
		return distance(other.lat, other.lon);
	}
}
