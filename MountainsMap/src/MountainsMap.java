import java.util.ArrayList;

public class MountainsMap {
	private ArrayList<Mountain> v;

	public MountainsMap() {
		v = new ArrayList<Mountain>();
	}

	public void add(Mountain some) {
		v.add(some);
	}

	public Mountain tallestMountain() {
		Mountain ans = v.get(0);
		for (int i = 1; i < v.size(); ++i)
			if (ans.taller(v.get(i)))
				ans = v.get(i);
		return ans;
	}

	public Mountain closestMountain(Location home) {
		Mountain ans = v.get(0);
		for (int i = 1; i < v.size(); ++i)
			if (v.get(i).distance(home) < ans.distance(home))
				ans = v.get(i);
		return ans;
	}

}
