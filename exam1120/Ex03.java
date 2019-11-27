package exam1120;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
문제 3] 자연수 뒤집어 배열로 만들기
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
입출력 예
n		return
12345	[5,4,3,2,1]
*/
public class Ex03 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(12345L), new int[] {5,4,3,2,1});
	}

	class Solution {
		public int[] solution(long n) {
			int[] answer = new int[(n+"").length()]; // 길이만큼 배열 선언
			int i=0;
			while(n>0) {
				answer[i] = (int)n%10; // 뒷자리 잘라 배열애 넣기
				n/=10;
				i++;
			}
			System.out.println(Arrays.toString(answer));
			return answer;
		}
	}
}
