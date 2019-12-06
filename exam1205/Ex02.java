package exam1205;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 1] 조이스틱
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.
▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동

예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.

만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 
최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.

입출력 예
name	return
JEROEN	56
JAN		23

출처
※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 */

public class Ex02 {
	public static void main(String[] args) {
		String name = "JEROENZ";
		// String name = "JAZ";
		// String name = "JAN";
		int answer = 0;
        // 위치의 합계
        for(char ch : name.toCharArray()) {
        	answer += ch <='N' ? ch-'A' : 'Z'- ch + 1;
        }
        System.out.println("상하 이동 위치의 합계 : " + answer);
        
        // 좌우 이동의 최소 값 구하기
        int length=name.length(); // 문자열 길이
        int min=length-1; // 최소값 변수 초기화

        for(int i=0;i<length;i++){
            int next=i+1; // 다음 문자
            while(next<length && name.charAt(next)=='A'){ // 다음 문자가 'A'이면 1증가
                next++;
            }                
            // 최소값 구하기
            min=Math.min(min, i+length-next + Math.min(i,length-next));
        }
        System.out.println("좌우 이동 최소 값 : " + min);
        System.out.println("전체 이동 거리 : " + (answer+min));
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution("JAZ"), 11);
		assertEquals(solution.solution("JAN"), 23);
		assertEquals(solution.solution("JEROEN"), 56);
	}

	class Solution {
		public int solution(String name) {
			int answer = 0;
	        for(char ch : name.toCharArray()) {
	        	answer += ch <='N' ? ch-'A' : 'Z'- ch + 1;
	        }
	        System.out.println("상하 이동 위치의 합계 : " + answer);
	        
	        // 좌우 이동의 최소 값 구하기
	        int length=name.length(); // 문자열 길이
	        int min=length-1; // 최소값 변수 초기화

	        for(int i=0;i<length;i++){
	            int next=i+1; // 다음 문자
	            while(next<length && name.charAt(next)=='A'){ // 다음 문자가 'A'이면 1증가
	                next++;
	            }                
	            // 최소값 구하기
	            min=Math.min(min, i+length-next + Math.min(i,length-next));
	        }
	        answer += min;
			return answer;
		}
	}
}