import java.util.ArrayList;

public class City {
	private String name;
	private ArrayList<City> vec;
	private boolean visited = false;

	public boolean getVisited() {
		return visited;
	}

	public void setViz(boolean val) {
		this.visited = val;
	}

	public City(String name) {
		this.name = name;
		vec = new ArrayList<City>();
	}

	public void addVec(City other) {
		vec.add((City) other);
	}

	public void df() {
		this.visited = true;
		for (City city : vec)
			if (!city.visited) {
				city.df();
			}
	}

	@Override
	public boolean equals(Object other) {
		return (boolean) ((other instanceof City) && (this.name.equals(((City) other).name)));
	}
}