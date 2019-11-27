package exam1120;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
문제 4] 정수 내림차순으로 배치하기
함수 solution은 정수 n을 매개변수로 입력받습니다. 
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
입출력 예
n		return
118372	873211
*/
public class Ex04 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(118372), 873211);
	}

	class Solution {
		public long solution(long n) {
			long answer = 0;
			char[] ar = (n+"").toCharArray(); // 문자 배열
			Arrays.sort(ar); // 오름차순 정렬
			String t="";
			for(int  i=ar.length-1;i>=0;i--) t += ar[i]; // 뒤집기
			answer = Integer.parseInt(t); // 정수로 바꾸기
			return answer;
		}
	}
}
