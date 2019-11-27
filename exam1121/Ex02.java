package exam1121;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 2] 짝수와 홀수
정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.

제한 조건
num은 int 범위의 정수입니다.
0은 짝수입니다.

입출력 예
num		return
3		Odd
4		Even
*/
public class Ex02 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(3), "Odd");
		assertEquals(solution.solution(4), "Even");
	}

	class Solution {
		public String solution(int num) {
			String answer = num%2==0 ? "Even":"Odd";
			return answer;
		}
	}
}
