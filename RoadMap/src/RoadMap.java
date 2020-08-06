import java.util.ArrayList;

public class RoadMap {
	private ArrayList<City> cities;

	public RoadMap() {
		cities = new ArrayList<City>();
	}

	public City addCity(City city) {
		int iCity = cities.indexOf(city);
		if (iCity == -1) {
			cities.add(city);
		} else {
			city = cities.get(iCity);
		}
		return city;
	}

	public boolean isConnected() {
		if (cities.size() == 0)
			return true;
		for (City city : cities) {
			city.setViz(false);
		}
		cities.get(0).df();
		for (City city : cities)
			if (!city.getVisited()) {
				return false;
			}
		return true;
	}
}
