import java.util.ArrayList;

public class CitiesMap {
	private ArrayList<BigCity> v;

	public CitiesMap() {
		v = new ArrayList<BigCity>();
	}

	public void add(BigCity b) {
		v.add(b);
	}

	public BigCity metropola() {
		BigCity ans = v.get(0);
		for (int i = 1; i < v.size(); ++i)
			if (ans.ultraPopulat(v.get(i)))
				ans = v.get(i);
		return ans;
	}

	public BigCity closestToTall(Mountain t) {
		double dist = v.get(0).dist2(t);
		BigCity ans = v.get(0);
		for (int i = 1; i < v.size(); ++i)
			if (dist > v.get(i).dist2(t)) {
				ans = v.get(i);
				dist = v.get(i).dist2(t);
			}
		return ans;
	}
}
