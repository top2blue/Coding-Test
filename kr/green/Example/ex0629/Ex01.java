package kr.green.Example.ex0629;
/*
자릿수 더하기
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
제한사항
N의 범위 : 100,000,000 이하의 자연수
입출력 예
N		answer
123		6
987		24
*/
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution1(123), 6);
		assertEquals(solution.solution1(987), 24);
	}
	class Solution {
		public int solution1(int n) {
			int answer=0;
			while(n>0) {
				answer += n%10; // 맨 뒷자리 잘라서 더하고
				n /=10; // 뒷자리 1개 버리기 : 정수 나누기 정수는 정수다!!!
			}
			return answer;
		}
	}
}
