package kr.green.Example.ex0717;

public class PermutationString {
	public static void main(String[] args) {
		char[] chars = "011".toCharArray();
		for(int i=1;i<=chars.length;i++) {
			permutation(chars, 0, i);
		}
	}

	static void permutation(char[] chars, int depth, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
                System.out.print(chars[i] + "");
            }
            System.out.println();
			return; 
		}

		for (int i = depth; i < chars.length; i++) {
			char tmp = chars[depth];
			chars[depth] = chars[i];
			chars[i] = tmp;

			permutation(chars, depth + 1, r);

			// 스왑한거 다시 되돌리기
			chars[i] = chars[depth];
			chars[depth] = tmp;
		}
	}
}
