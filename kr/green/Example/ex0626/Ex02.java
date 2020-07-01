package kr.green.Example.ex0626;
/*
시저 암호
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 
시저 암호라고 합니다. 
예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. 
z는 1만큼 밀면 a가 됩니다. 
문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

제한 조건
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.

입출력 예
s		n	result
AB		1	BC
z		1	a
a B z	4	e F d
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution("AB", 1), "BC");
		assertEquals(solution.solution("z", 1), "a");
		assertEquals(solution.solution("a B z", 4), "e F d");
	}
	class Solution {
		public String solution(String s, int n) {
			String answer = "";
			for(char c : s.toCharArray()) {
				if(c>='a' && c<='z' ){
					answer += (char)('a' + (c+n-'a')%26); 
				}else if(c>='A' && c<='Z' ){
					answer += (char)('A' + (c+n-'A')%26); 
				}else {
					answer += c;
				}
			}
			System.out.println(answer);
			return answer;
		}
	}
}
