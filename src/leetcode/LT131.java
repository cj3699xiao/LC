package leetcode;

import java.util.*;

public class LT131 {
	private int Length;
	private String S;

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<int[]> list = new ArrayList<>();
		Length = s.length() - 1;
		S = s;

		dfs(0, 0, list, res);

		return res;
	}

	private void dfs(int pre, int cur, List<int[]> list, List<List<String>> res) {
		if (cur == Length) {
			list.add(new int[] { pre, cur });

			if (valid(list)) {
				addResult(list, res);
			}
			list.remove(list.size() - 1);
			return;
		}

		// Split
		list.add(new int[] { pre, cur });
		dfs(cur + 1, cur + 1, list, res);
		list.remove(list.size() - 1);

		// Not
		dfs(pre, cur + 1, list, res);

	}

	private boolean valid(List<int[]> list) {
		for (int[] cur : list) {
			int start = cur[0];
			int end = cur[1];

			while (start < end) {
				if (S.charAt(start) != S.charAt(end)) {
					return false;
				}
				start++;
				end--;
			}
		}

		return true;
	}

	private void addResult(List<int[]> list, List<List<String>> res) {
		List<String> tmp = new ArrayList<>();

		for (int[] cur : list) {
			tmp.add(S.substring(cur[0], cur[1] + 1));
		}

		res.add(tmp);
	}

	// With Early return, only continue if palidrome exist

	public List<List<String>> partition2(String s) {
		int n = s.length();
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> list = new ArrayList<>();
		helper(s, 0, res, list);
		return res;
	}

	private void helper(String s, int pos, List<List<String>> res, List<String> list) {
		if (pos == s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = pos; i < s.length(); i++) {
			String curr = s.substring(pos, i + 1);
			if (isValid(curr)) {
				list.add(curr);
				helper(s, i + 1, res, list);
				// return true;
				// }

				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isValid(String s) {
		char[] st = s.toCharArray();
		int l = 0;
		int r = st.length - 1;
		while (l < r) {
			if (st[l] != st[r]) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT131 a = new LT131();
		a.partition("aab");
	}

}
