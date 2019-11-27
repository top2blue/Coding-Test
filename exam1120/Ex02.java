package exam1120;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 2] 자릿수 더하기
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수
입출력 예
N		answer
123		6
987		24
입출력 예 설명
입출력 예 : 문제의 예시와 같습니다.

입출력 예 : 9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
*/
public class Ex02 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(123), 6);
		assertEquals(solution.solution(987), 24);
	}

	class Solution {
		public int solution(int n) {
			int answer = 0;
			while(n>0) {
				answer += n%10; // 뒷자리 잘라내기
				n /= 10; // 자릿수 줄이기
			}
			return answer;
		}
	}
}
