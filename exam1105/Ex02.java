package exam1105;
/*
문제 2] 카프리카 수
카프리카 수란 인도의 수학자 D.R.카프리카의 의해 정의한 수이다.
어떤 수의 제곱수를 두 부분으로 나누어 더하였을 때 다시 원래의 수가 되는 수들을 의미한다.
예를 들어 45는 카프리카 수인데, 45² = 2025이고, 20+25 = 45이기 때문이다.

297은 카프리카 수이다. 297² = 88209이고 이것은 88과 209로 나누어지는데, 
88 + 209 = 297가 되어 원래의 수로 돌아가기 때문이다. 
나누어지는 두 수는 0으로 시작해도 되지만, 양수여야 한다. 
예를 들어, 999는 카프리카 수인데, 999² = 998001이고 998과 001로 나누면 998 + 001 = 999가 되기 때문이다. 
하지만, 100은 카프리카 수가 아니다. 100² = 10000이고 100 + 00 = 100이지만, 00은 양수가 아니기 때문이다.

처음 몇 개의 카프리카 수는 다음과 같다.
1, 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4879, 4950, 5050, 5292, 7272, 
7777, 9999, 17344, 22222, 38962, 77778, 82656, 95121, 99999, 142857, 148149, 
181819, 187110, 208495, 318682, 329967, 351352, 356643, 390313, 461539, 466830, 
499500, 500500, 533170, ... (OEIS의 수열 A006886)
9, 99, 999… 와 같이 10n - 1꼴의 수는 전부 카프리카 수이다.

1) 어떤 수를 입력 받고 그 수가 카프리카 수인지 아닌지를 출력하는 함수를 만드시오.
2) 어떤 수를 입력 받고 자릿수가 그 수인 모든 카프리카 수를 출력하시오.
3) 어떤 수를 입력 받고 어떤 수 이하의 모든 카프리카 수를 출력하시오.
 */
public class Ex02 {
	public static void main(String[] args) {
		int cnt = 0;
		for(int i=0;i<10000;i++) {
			if(iskaprekarNumber(i)) {
				System.out.printf("%8d",i);
				if(++cnt%10==0) System.out.println();
			}
		}
	}
	
	private static boolean iskaprekarNumber(int n) {
		boolean iskaprekar = false;
		if(n==1) {
			iskaprekar = true;
		}else {
			String str = (n * n)+"";
			// System.out.println(str);
			if(str.length()>1) {
				for(int i=1;i<str.length();i++) {
					// System.out.println(str.substring(0,i) + " : " + str.substring(i));
					int first = Integer.parseInt(str.substring(0,i));
					int second = Integer.parseInt(str.substring(i));
					if(first+second==n && first>0 && second>0) {
						iskaprekar = true;
					}
				}
			}
		}
		return iskaprekar;
	}
}
