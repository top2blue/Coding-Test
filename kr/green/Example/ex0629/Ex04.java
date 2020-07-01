package kr.green.Example.ex0629;
/*
정수 제곱근 판별
문제 설명
임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 
-1을 리턴하는 함수를 완성하세요.

제한 사항
n은 1이상, 50000000000000 이하인 양의 정수입니다.

입출력 예
n	return
121	144
3	-1
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex04 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(121),144);
		assertEquals(solution.solution(3),-1);
	}
	class Solution {
		public long solution(int  n) {
			// n의 제곱근 판단 : Math.sqrt(n) --> 리턴값이 double이다. 정수화 했을때 같다면 정수의 제곱근
			// Math.pow(n,m) : n의 m승을 구해준다.
			return  Math.sqrt(n) == (int)Math.sqrt(n) ? (long) Math.pow((int)Math.sqrt(n)+1, 2) : -1; 
		}
		
	}
}
