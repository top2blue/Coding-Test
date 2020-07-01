package kr.green.Example.ex0629;
/*
자연수 뒤집어 배열로 만들기
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
입출력 예
n	return
12345	[5,4,3,2,1]
*/
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;
public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(12345), new int[] {5,4,3,2,1});
	}
	class Solution {
		public int[] solution(int n) {
			int[] answer;
			StringBuffer sb = new StringBuffer(n+""); // StringBuffer로 만들기
			sb.reverse();// 뒤집기
			char[] chars = sb.toString().toCharArray();
			answer = new int[chars.length]; // 글자길이만큼 배열 선언
			for(int i=0;i<chars.length;i++) {
				answer[i] = chars[i]-'0'; // char형을 int형으로 변환
			}
			System.out.println(Arrays.toString(answer));
			return answer;
		}
		
	}
}
