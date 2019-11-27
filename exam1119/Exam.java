package exam1119;

public class Exam {
	public static void main(String[] args) {
		String s="ababcdcdababcdcd";
		int min=1000;
		for(int i=1;i<=s.length()/2;i++) { // 절반을 넘는 크기로 잘라낼 수 없다. 
			String str1 = "";
			String result = "";
			int count=1;
			for(int j=0;j<s.length()/i;j++) {
				String str2 = s.substring((i * j), (i * j) + i);
				//System.out.println(str1 + " : " + str2);
				if(str1.equals(str2)) { 
					count++;
					continue;
				}
				result += (count>1) ? count+str1 : str1;
				str1 = str2;
				count = 1;
			}
			result += (count>1) ? count+str1 : str1;
			// 길이가 잘라내는 길이의 배수가 아니면 나머지 문자를 그냥 붙인다.
			if (s.length() % i != 0) {
				result += s.substring(s.length() - (s.length() % i), s.length());
			}
			// 길이의 최소값
			min = Math.min(result.length(), min);
			System.out.println(result + " : " + result.length() + " : " + min);
		}
	}
}
