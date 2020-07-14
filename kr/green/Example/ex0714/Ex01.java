package kr.green.Example.ex0714;
/*
가장 큰 수
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
이중 가장 큰 수는 6210입니다.
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
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;
public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[] {6, 10, 2}),"6210");
		assertEquals(solution.solution(new int[] {3, 30, 34, 5, 9}),"9534330");
		assertEquals(solution.solution(new int[] {0,0,0,0}), "0");
	}
	class Solution {
	    public String solution(int[] numbers) {
	        String answer = "";
	        String[] t = new String[numbers.length]; // 문자 배열 생성
			for(int i=0;i<numbers.length;i++) t[i] = numbers[i]+""; // int배열을 String배열로 복사
 			Arrays.sort(t, new Comparator<String>() { // 정렬
				@Override
				public int compare(String o1, String o2) {
					// 내림차순 : return (o2+o1).compareTo(o1+o2);
					// 오름차순 : return (o1+o2).compareTo(o1+o2);
					return (o2+o1).compareTo(o1+o2);
				}
			});
 			if(t[0].charAt(0)=='0') { // 모든 숫자가 0이면 0000이런식이기 때문에 
 				answer = "0"; // 그냥 0을 리턴
 			}else {
 				for(int i=0;i<t.length;i++) { // 문자로 합치기
 					answer += t[i];
 				}
 			}
	        return answer;// 리턴
	    }
	}
	
	public static void main(String[] args) {
		// int[] ar = { 6, 10, 2 }; // 6210
		int[] ar = {3, 30, 34, 5, 9}; // 9534330
		// int[] ar = {0,0,0,0}; // 0
		String[] t = new String[ar.length];
		for(int i=0;i<ar.length;i++) {
			t[i] = ar[i]+"";
		}
		
		Arrays.sort(t, Collections.reverseOrder());
		System.out.println(Arrays.toString(t));
		
		Arrays.sort(t, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		System.out.println(Arrays.toString(t));
		String answer="";
		/*
		이 문제의 함정은 같은 수가 중복될 수도 있다는 것이다.
		즉, 0이 여러번 중복되면 답은 "0" 이어야 하는데 "0000" 이런 수가 나오게 된다.
		그러므로 배열에 가장 큰 수가 "0" 으로 시작하는 경우에는 "0"을 입력하고 종료한다.		 
		 */
		if(t[0].charAt(0)=='0') {
			answer = "0";
		}else {
			for(int i=0;i<ar.length;i++) {
				answer += t[i];
			}
		}
		System.out.println(answer);
	}
}
