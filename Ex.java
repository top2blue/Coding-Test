import java.util.Arrays;

public class Ex {
	public static void main(String[] args) {
		// "ab." : ab로 시작하고 뒤에 1글자가 있는 문자열
		System.out.println("ab".matches("ab."));	// false
		System.out.println("abc".matches("ab."));	// true
		
		System.out.println(Arrays.toString("qwerty".split("[et]")));
		System.out.println("qwerty".replaceAll("[et]","*"));
		// "ab\\s\\S" : ab로 시작하고 공백이나 탭이  나오고 문자가 1개 존재하면
		System.out.println("ab    ".matches("ab\\s\\S"));
		System.out.println("ab c".matches("ab\\s\\S"));
		
		
	}
}
