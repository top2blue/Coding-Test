package exam1119;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 3] 수박수박수박수박수박수?
길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, 
solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

제한 조건
n은 길이 10,000이하인 자연수입니다.
입출력 예
n	return
3	수박수
4	수박수박
*/
public class Ex03 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(3), "수박수");
		assertEquals(solution.solution(4), "수박수박");
		assertEquals(solution.solution(5), "수박수박수");
	}

	class Solution {
		public String solution(int n) {
			String answer = "";
			String t = "수박";
			for(int i=0;i<n;i++) {
				answer += t.charAt(i%2);
			}
			return answer;
		}
	}
}
