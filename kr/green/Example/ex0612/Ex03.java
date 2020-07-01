package kr.green.Example.ex0612;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
문제 3] Ones
출처: programming challenges
2나 5로 나눌 수 없는 0 이상 10,000 이하의 정수 n이 주어졌는데, 
n의 배수 중에는 10진수로 표기했을 때 모든 자리 숫자가 1인 것이 있다. 
그러한 n의 배수 중에서 가장 작은 것은 몇 자리 수일까?
Sample Input
3
7
9901
Sample Output
3
6
12
*/
public class Ex03 {
	@Test
	public void testOnes() {
		assertEquals(Ex03.ones(3), 3);
		assertEquals(Ex03.ones(7), 6);
		assertEquals(Ex03.ones(9901), 12);
	}
	public static int ones(long n) { // 숫자가 커서 long타입이어야 한다.
		int result = 0;
		for(int i=1;;i++) {
			long temp = n*i; // 그 값을 찍기 위해서 임시 변수
			long t = n*i; // 배수
			boolean isOne = true; // 모두 1이다라고 가정
			while(t>0) {
				if(t%10!=1) { // 1이 아니면 거딧이라고 하고 탈출!!!
					isOne = false;
					break;
				}
				t/=10L; // 1자리 줄이고
			}
			if(isOne) { // true라면 모두 1로만 구성된 숫자다!!!
				result = (temp+"").length(); // 숫자의 길이가 답이다.
				System.out.print(temp + " : "); // 배수 출력
				break;
			}
		}
		System.out.println(result); // 길이 출력
		return result;
	}
}
