package exam1121;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 1] 정수 제곱근 판별
임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

제한 사항
n은 1이상, 50000000000000 이하인 양의 정수입니다.

입출력 예
n		return
121		144
3		-1

입출력 예#1 : 121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.

입출력 예#2 : 3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
*/
public class Ex01 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(121), 144);
		assertEquals(solution.solution(3), -1);
	}

	class Solution {
		public long solution(long n) {
			long answer = 0;
			System.out.println(Math.sqrt(n)); // double
			System.out.println((int)(Math.sqrt(n))); // int
			System.out.println(Math.sqrt(n) - (int)(Math.sqrt(n))); // 소수 이하
			if(Math.sqrt(n) - (int)(Math.sqrt(n))==0){ // 소수 이하가 0이면 정수의 제곱
				answer =(long)((Math.sqrt(n)+1)*(Math.sqrt(n)+1)); // +1해서 제곱
			}else {
				answer = -1; // 정수의 제곱이 아니므로 -1
			}
			System.out.println(answer);
			System.out.println();
			return answer;
		}
	}
}
