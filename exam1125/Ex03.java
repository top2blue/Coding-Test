package exam1125;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
문제 3] 가장 큰 수
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는
가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예

numbers				return
[6, 10, 2]			6210
[3, 30, 34, 5, 9]	9534330
*/
public class Ex03 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[] {6, 10, 2 }),"6210");
		assertEquals(solution.solution(new int[] {3, 30, 34, 5, 9 }),"9534330");
		assertEquals(solution.solution(new int[] {3, 32, 35, 5, 9 }),"9535332");
		assertEquals(solution.solution(new int[] {3, 34, 35, 5, 9 }),"9535343");
	}

	class Solution {
		public String solution(int[] numbers) {
			String answer = "";
			String[] ar= new String[numbers.length];
			for(int i=0;i<numbers.length;i++) ar[i] = numbers[i]+"";
			Arrays.sort(ar);
			for(int i=ar.length-1;i>=0;i--) {
				if(i>0  && ar[i].length()>1 && ar[i].charAt(1)<ar[i-1].charAt(0)) {
					answer += ar[i-1]+ar[i];
					i--;
				}else {
					answer += ar[i];
				}
			}
			System.out.println(Arrays.toString(ar) + " : " + answer);
			return answer;
		}
	}
}
