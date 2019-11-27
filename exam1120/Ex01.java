package exam1120;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 1] 문제 설명
문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
각 단어의 짝수번째 알파벳은 대문자로, 
홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

제한 사항
문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
입출력 예
s				return
try hello world	TrY HeLlO WoRlD

입출력 예 설명
try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 
각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 
따라서 TrY HeLlO WoRlD 를 리턴합니다.
*/
public class Ex01 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution("try hello world"), "TrY HeLlO WoRlD");
		assertEquals(solution.solution("try        hello   world"), "TrY        HeLlO   WoRlD");

	}

	class Solution {
		public String solution(String s) {
			String answer = "";
			String ar[] = s.split(" ");// 배열
			for (String t : ar) { // 반복
				t = t.trim(); // 공백제거
				if (t.length() > 0) { // 내용이 있을때만
					for (int i = 0; i < t.length(); i++) {
						if (i % 2 == 0) {// 짝수면 소문자일 경우 대문자로
							answer += (t.charAt(i) >= 'a' && t.charAt(i) <= 'z') ? (char) (t.charAt(i) - 32) : t.charAt(i);
						} else {// 홀수면 대문자일 경우 소문자로
							answer += (t.charAt(i) >= 'A' && t.charAt(i) <= 'Z') ? (char) (t.charAt(i) + 32) : t.charAt(i);
						}
					}
				}
				answer += " "; // 단어 사이 공백
			}
			System.out.println(answer);
			return answer.trim();// 맨뒤 공백은 제거
		}
	}
}
