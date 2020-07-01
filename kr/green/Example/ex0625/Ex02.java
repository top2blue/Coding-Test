package kr.green.Example.ex0625;
/*
수박수박수박수박수박수?
길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, 
solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

제한 조건
n은 길이 10,000이하인 자연수입니다.
입출력 예
n	return
3	수박수
4	수박수박
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(3), "수박수");
		assertEquals(solution.solution(4), "수박수박");
		assertEquals(solution.solution(14), "수박수박수박수박수박수박수박");
		assertEquals(solution.solution2(3), "수박수");
		assertEquals(solution.solution2(4), "수박수박");
		assertEquals(solution.solution2(14), "수박수박수박수박수박수박수박");
	}
	class Solution {
		public String solution(int n) {
			StringBuffer answer = new StringBuffer();
			for(int i=0;i<n;i++) answer.append("수박".charAt(i%2));
			System.out.println(answer.toString());
			return answer.toString();
		}
		public String solution2(int n) {
			String answer = "";
			for(int i=0;i<n;i++) answer += "수박".charAt(i%2);
			System.out.println(answer);
			return answer;
		}
	}
}
