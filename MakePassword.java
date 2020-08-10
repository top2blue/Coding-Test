import java.util.Random;

public class MakePassword {
	public static void main(String[] args) {
		for(int i=5;i<15;i++) {
			System.out.println(makePassword(i));
		}
	}
	
	public static String makePassword(int length) {
		StringBuffer sb = new StringBuffer();
		Random rnd = new Random();
		for(int i=0;i<length;i++) {
			if((i+1)%3==0) {
				sb.append((char)('A' + rnd.nextInt(26)));
			}else if((i+1)%3==1){
				sb.append((char)('a' + rnd.nextInt(26)));
			}else {
				sb.append((char)('0' + rnd.nextInt(10)));
			}
		}
		return sb.toString();
	}
}
