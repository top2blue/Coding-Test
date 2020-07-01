package kr.green.Example.ex0622;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	TUE
 */
public class Ex02 {
	@Test
	public void testSolution() {
		Solution solution = new Solution();
		assertEquals(solution.solution(5, 24), "TUE");
	}
	class Solution {
		public String solution(int a, int b) {
			String answer = "";
			int total = 0;
			// 1월 1일이 금요일이라 금요일부터 시작
			String w[] = "FRI,SAT,SUN,MON,TUE,WED,THU".split(","); 
			int m[] = {31,29,31,30,31,30,31,31,30,31,30,31}; // 월의 마지막 날짜
			for(int i=1;i<a;i++) {
				total += m[i-1];
			} // 전월까지의 일의 합
			total += b-1; // 일 더하고
			answer = w[total%w.length]; // 7로 나눈 나머지가 요일
			System.out.println(answer);
			return answer; // 리턴
		}
	}
}