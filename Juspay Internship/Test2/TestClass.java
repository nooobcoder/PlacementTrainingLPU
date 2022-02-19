import java.io.*;

import java.util.*;

class TestClass {
	static Dictionary status = new Hashtable();
	static ArrayList<String> d = new ArrayList<>();
	static String nodes[];
	static String queries[];
	static int n, m;

	public static void precompute(String[] queries) {

		for (String q : queries) {
			String[] i = q.split(" ");
			d.add(i[1]);
			d.add(i[0]);

		}

		for (int j = 0; j < d.size() - 1; j += 2) {
			status.put(d.get(j), 0);
		}

	}

	public static Dictionary returnStatus(Dictionary status) {
		return status;
	}

	public static ArrayList<String> returnD(ArrayList<String> d) {
		return d;
	}

	public static String lock(String name) {
		int ind = -1;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].equalsIgnoreCase(name)) {
				ind = i;
				break;
			}
		}
		ind += 1;
		int c1 = ind * 2;
		int c2 = ind * 2 + 1;
		if (status.get(name) == "lock" || status.get(name) == "fail")
			return "false";
		else {
			int p = ind / 2;
			status.put(nodes[p - 1], "fail");
			status.put(name, "lock");
			return "true";
		}
	}

	public static String unlock(String name) {
		if (status.get(name) == "lock") {
			status.put(name, "unlock");
			return "true";
		} else
			return "false";
	}

	public static String upgrade(String name) {
		int ind = -1;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].equalsIgnoreCase(name)) {
				ind = i;
				break;
			}
		}
		ind += 1;
		int c1 = ind * 2;
		int c2 = ind * 2 + 1;

		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; ++i)
			nums.add(i);
		if (nums.contains(c1) && nums.contains(c2)) {
			if (status.get(nodes[c1 - 1]) == "lock" && status.get(nodes[c2 - 1]) == "lock") {

				status.put(nodes[c1 - 1], "unlock");
				status.put(nodes[c2 - 1], "unlock");
				status.put(nodes[ind - 1], "lock");

				return "true";
			} else {
				return "false";
			}
		}
		return "";
	}

	public static String operation(String name, int code) {
		String result = "false";

		if (code == 1)
			result = lock(name);
		else if (code == 2)
			result = unlock(name);
		else if (code == 3)
			result = upgrade(name);
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int apis;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		apis = Integer.parseInt(br.readLine());

		nodes = new String[n];
		queries = new String[apis];

		for (int a = 0; a < n; ++a) {
			nodes[a] = br.readLine();
		}

		for (int a = 0; a < apis; ++a) {
			queries[a] = br.readLine();
		}

		precompute(queries);

		for (int j = 0; j < d.size() - 1; j += 2) {
			System.out.println(operation(d.get(j), Integer.parseInt(d.get(j + 1))) + " ");
		}
	}
}
