package kr.green.Example.ex0624;
/*
문자열 내림차순으로 배치하기
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, 
solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.
입출력 예
s		return
Zbcdefg	gfedcbZ
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution("Zbcdefg"), "gfedcbZ");
		assertEquals(solution.solution2("Zbcdefg"), "gfedcbZ");
	}

	class Solution {
		public String solution(String s) {
			char[] str = s.toCharArray(); // 문자 배열
			Arrays.sort(str);// 정렬
			for(int i=0;i<str.length/2;i++) { // 배열 뒤집기 
				char t = str[i];
				str[i] = str[str.length-1-i];
				str[str.length-1-i]=t;
			}
			return new String(str);// 문자배열을 String으로 변환
		}
		public String solution2(String s) {
			String answer = "";
			String[] strings = s.split("(?<=\\G.{1})");// 1글자씩 잘라 배열로
			Arrays.sort(strings, Collections.reverseOrder()); ;// 역순정렬
			for(String t : strings) answer += t; // 문자열 배열 합치기
			return answer; // 리턴
		}
	}
}
