package kr.green.Example.ex0630;
/*
짝수와 홀수
정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.

제한 조건
num은 int 범위의 정수입니다.
0은 짝수입니다.

num		return
3		Odd
4		Even
*/
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution1(3), "Odd");
		assertEquals(solution.solution1(4), "Even");
	}
	class Solution {
		public String solution1(int n) {
				return n%2==0 ? "Even":"Odd";
		}
	}
}
