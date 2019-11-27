package exam1114;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 1] 가운데 글자 가져오기
문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
입출력 예
s		return
abcde	c
qwer	we
*/
public class Ex01 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution("abcde"),"c");
		assertEquals(solution.solution("qwer"),"we");
	}
	// 내부 클래스
	class Solution {
		public String solution(String s) {
			String answer = "";
			int len = s.length();
			if (len % 2 == 0) {
				answer = s.substring(len / 2 - 1, len / 2 + 1);
			} else {
				answer = s.charAt(len / 2) + "";
			}
			System.out.println(answer);
			return answer;
		}
	}
}

