package kr.green.Example.ex0701;
/*
하샤드 수
문제 설명
양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

제한 조건
x는 1 이상, 10000 이하인 정수입니다.
입출력 예
arr	return
10	true
12	true
11	false
13	false
*/

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertTrue(solution.solution(10));
		assertTrue(solution.solution(12));
		assertFalse(solution.solution(11));
		assertFalse(solution.solution(13));
	}
	class Solution {
		public boolean solution(int x) {
			int sum=0, temp = x;
			while(temp>0) {
				sum += temp%10;
				temp/=10;
			}
			return x%sum==0;
		}
	}
}
