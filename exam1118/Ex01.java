package exam1118;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

/*
문제 1] 2016년
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다. 
예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	TUE
*/
public class Ex01 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(5, 24), "TUE");
		assertEquals(solution.solution(5, 25), "WED");
	}

	class Solution {
		public String solution(int a, int b) {
			String answer = "";
			String[] week = "SUN,MON,TUE,WED,THU,FRI,SAT".split(",");
			Calendar calendar = Calendar.getInstance();
			calendar.set(2016, a-1, b); // 월은 0~11월
			int w = calendar.get(Calendar.DAY_OF_WEEK);
			System.out.println(w);
			answer = week[w-1]; // 요일은 1~7
			return answer;
		}
	}
}
