package kr.green.Example.ex0624;
/*
서울에서 김서방 찾기
String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 
김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요. 
seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

제한 사항
seoul은 길이 1 이상, 1000 이하인 배열입니다.
seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
Kim은 반드시 seoul 안에 포함되어 있습니다.
입출력 예
seoul		return
[Jane, Kim]	김서방은 1에 있다
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Ex03 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new String[] {"Jane", "Kim"}),"김서방은 1에 있다" );
		assertEquals(solution.solution(new String[] {"Queen", "Tod","Kim"}),"김서방은 2에 있다" );
		assertEquals(solution.solution2(new String[] {"Jane", "Kim"}),"김서방은 1에 있다" );
		assertEquals(solution.solution2(new String[] {"Queen", "Tod","Kim"}),"김서방은 2에 있다" );
	}
	class Solution {
		public String solution(String[] seoul) {
			String answer = "";
			int index = -1;
			for(int i=0;i<seoul.length;i++) {
				if(seoul[i].equals("Kim")) {
					index=i;
					break;
				}
			}
			answer = "김서방은 "+index+"에 있다";
			return answer;
		}
		public String solution2(String[] seoul) {
			// binarySearch는 데이터가 정렬이 되어 있을때만 사용 가능하다.
			System.out.println("김서방은 "+Arrays.binarySearch(seoul,"Kim")+"에 있다");
			return "김서방은 "+Arrays.binarySearch(seoul,"Kim")+"에 있다";
		}
	}
}
