package kr.green.Example.ex0629;
/*
정수 내림차순으로 배치하기
문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다. 
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
입출력 예
n		return
118372	873211
*/

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Ex03 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(118372), 873211);
	}

	class Solution {
		public long solution(int n) {
			long answer = 0;
			char[] chars = (n+"").toCharArray();//문자배열로
			Arrays.sort(chars); // 오름차순정렬
			String t="";
			for(char ch : chars) { // 뒤집기
				t = ch + t;
			}
			answer = Long.parseLong(t); // 숫자로
			System.out.println(answer);
			return answer;
		}
	}
}
