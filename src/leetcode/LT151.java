package leetcode;

public class LT151 {
	public String reverseWords(String s) {
		StringBuilder res = new StringBuilder();

		// #1 Reverse whole input String
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && i != s.length() - 1 && s.charAt(i + 1) == ' ') {
				// Continues spaces, skip
				continue;
			}
			res.append(s.charAt(i));
		}

		if (res.charAt(0) == ' ')
			res.deleteCharAt(0);
		if (res.charAt(res.length() - 1) != ' ')
			// Intentionally add extra space for convenience
			res.append(' ');

		// #2 Reverse each world one by one
		int end = 0;
		int start = 0;
		char tmp;

		while (end <= res.length() - 1) {
			if (res.charAt(end) == ' ') {
				// Do reverse
				int target = end + 1;
				end--;

				while (start < end) {
					tmp = res.charAt(start);
					res.deleteCharAt(start);
					res.insert(start, res.charAt(end - 1));
					// Removed one char, whole length is shorten by 1
					res.deleteCharAt(end);
					res.insert(end, tmp);
					start++;
					end--;
				}

				start = target;
				end = target;
			} else {
				end++;
			}
		}

		// Remove then helper space and return
		return res.deleteCharAt(res.length() - 1).toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LT151 a = new LT151();
		
//		System.out.println(a.reverseWords("the sky is blue"));
//		System.out.println(a.reverseWords("F R  I   E    N     D      S      "));
		
		// sky
		// kyy
		// aky
		//  2

		StringBuilder res = new StringBuilder("Sky");
		int start = 0, end = 2;
//        res.deleteCharAt(start);
        res.insert(start, 'a');

	}

}
