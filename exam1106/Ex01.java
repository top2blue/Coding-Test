package exam1106;

import java.util.Arrays;

/*
문제 1] 카프리카 상수
카프리카 상수도 마찬가지로 인도의 수학자 카프리카가 발견한 상수이다.
이 상수의 생성법은 다음과 같다.
숫자 하나로만 이루어지지 않은 4자리 수를 정한다. (예: 1000은 인정하되, 1111은 인정하지 않는다.)
첫 자리에 0이 와도 무방하다.
이 숫자를 크기 순으로 배열하여 두 수를 만든다. 하나는 큰 순, 하나는 작은 순으로 배열한다.
큰 쪽에서 작은 쪽을 빼 준다. 이때 나온 0은 유지한다.
이 과정을 반복하면 7번 이내로 6174가 나온다.
어떤 수를 입력 받고 몇번이내로 6174가 완성 되었는지 출력하는 함수를 입력하시오
단, 입력값은 정수여야 한다.

예를 들어, 4371로 이 과정을 수행하면 다음과 같다.
7431 - 1347 = 6084
8640 - 0468 = 8172
8721 - 1278 = 7443
7443 - 3447 = 3996
9963 - 3699 = 6264
6642 - 2466 = 4176
7641 - 1467 = 6174

입력
print(kaprekar_constant(4371))
print(kaprekar_constant(21))
print(kaprekar_constant(1))
print(kaprekar_constant(1111))
출력
7
3
5
False
*/
public class Ex01 {
	public static void main(String[] args) {
		System.out.println(kaprekar_constant(4371));
		System.out.println(kaprekar_constant(21));
		System.out.println(kaprekar_constant(1));
		System.out.println(kaprekar_constant(1111));

	}
	

	private static String kaprekar_constant(int num) {
		if(num<1 || num>9999) return "False"; // 일단 0보다 적거나 1000보다 크면 거짓
		String temp = String.format("%04d", num); // 4자리 정수로 변경
		if(temp.charAt(0)==temp.charAt(1) && temp.charAt(1)==temp.charAt(2) && temp.charAt(2)==temp.charAt(3)) return "False";
		// 여기까지 오면 모두 같지 않은 네자리 정수
		int count = 0;
		while(num!=6174) {
			++count;
			temp = String.format("%04d", num); // 4자리 정수로 변경
			char[] ar = temp.toCharArray();
			Arrays.sort(ar);
			int first = Integer.parseInt(new String(ar));
			int second = Integer.parseInt(new StringBuilder(new String(ar)).reverse().toString());
			num = second-first;
			//System.out.printf("%02d회 : %04d - %04d = %04d\n", count, second, first, num);
		}
		return count+"";
	}
}
