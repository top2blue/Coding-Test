package kr.green.Example.ex0701;

import static org.junit.Assert.assertEquals;

/*
핸드폰 번호 가리기
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 
전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 
전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, 
solution을 완성해주세요.

제한 조건
s는 길이 4 이상, 20이하인 문자열입니다.
입출력 예
phone_number	return
01033334444	*******4444
027778888	*****8888
 */
import org.junit.Test;

public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution("01033334444"), "*******4444");
		assertEquals(solution.solution("027778888"), "*****8888");
	}
	class Solution {
		public String solution(String num) {
			String answer = "";
			int len = num.length(); // 전체길이
			for (int i = 0; i < len - 4; i++) answer += "*";// 길이보다 4개 적게 * 붙이기
			answer += num.substring(len - 4); // 뒤에 4자리 잘라서 붙이기
			System.out.println(answer);
			return answer; // 리턴
		}

	}
}
