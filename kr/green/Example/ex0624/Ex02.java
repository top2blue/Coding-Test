package kr.green.Example.ex0624;
/*
문자열 다루기 기본
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, 
solution을 완성하세요. 
예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
입출력 예
s		return
a234	false
1234	true
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertFalse(solution.solution("a234"));
		assertTrue(solution.solution("1234"));
		assertFalse(solution.solution2("a234"));
		assertTrue(solution.solution2("1234"));
	}
	class Solution {
	    boolean solution(String s) {
     	   if(s.length()!=4 && s.length()!=6) return false; // 4자 또는 6자가 아니면 거짓
	       try {
	    	   Integer.parseInt(s);
	    	   return true; // 숫자로 바꿨다면 숫자로만 이루어짐
	       }catch (Exception e) {
	    	   return false; // 에러 발생하면 숫자 아닌 문자가 있음
	       }
	    }
	    boolean solution2(String s) {
	    	boolean answer = true;
			if(s.length()==4 || s.length()==6) { // 4자 또는 6자 일때만
				for(char c : s.toCharArray()) { // 1글자씩 비교
					if(c<'0' || c>'9') { // 숫자가 아니면 
						answer = false;  // 거짓
						break;
					}
				}
			}else {
				answer = false;
			}
			return answer;
	    }
	}
}
