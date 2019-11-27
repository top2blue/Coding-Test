package exam1108;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(checkRow("system","make"));
	}
	private static int checkRow(String str1, String str2) { // 행
		int position = -1;
		for(int i=0;i<str1.length();i++) {
			System.out.println(str2 + " : " + str1.charAt(i) + " : " + str2.indexOf(str1.charAt(i)));
			if(str2.contains(str1.charAt(i)+"")) {
				position = str2.indexOf(str1.charAt(i));
				break;
			}
		}
		return position;
	}
}
