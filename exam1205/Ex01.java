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

public class Ex01 {
	public static void main(String[] args) {
		// 알파벳 대문자는 65~90 까지 N(78)이 중간!
		// String name = "JEROEN";
		// String name = "JAN";
		String name = "JAZ";
		int answer = 0;
		int n = name.length();
		int leftOrRight = name.length() - 1;
		// n은 name의 길이, leftOrRight는 커서 이동 위치를 구하기 위한 변수
		for(int i = 0; i < n; i++) {
			int next = i + 1;
			char target = name.charAt(i);
			if (target <= 'N')
				answer += target - 'A';
			else
				answer += 'Z' - target + 1;
			
			while (next < n && name.charAt(next) == 'A') next++; // 다음 글자가 'A'인 경우 next를 1 증가
			
			int b = i + n - next + Math.min(i, n - next); // 현 위치에서 좌우 움직이는 수 중 작은 수를 구하는 식
			leftOrRight = Math.min(leftOrRight, b);
			// i는 현재 글자를 바꾸는 단어의 위치, n은 name의 총 길이
			// next는 현재 위치에서 A가 아닌 문자로 얼마나 갈 수 있는지 판단
		}
		answer += leftOrRight;
		System.out.println(answer);
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
			int n = name.length();
			int leftOrRight = name.length() - 1;
			// n은 name의 길이, leftOrRight는 커서 이동 위치를 구하기 위한 변수
			for(int i = 0; i < n; i++) {
				int next = i + 1;
				char target = name.charAt(i);
				if (target <= 'N')
					answer += target - 'A';
				else
					answer += 'Z' - target + 1;
				
				while (next < n && name.charAt(next) == 'A') next++; // 다음 글자가 'A'인 경우 next를 1 증가
				
				int b = i + n - next + Math.min(i, n - next); // 현 위치에서 좌우 움직이는 수 중 작은 수를 구하는 식
				leftOrRight = Math.min(leftOrRight, b);
				// i는 현재 글자를 바꾸는 단어의 위치, n은 name의 총 길이
				// next는 현재 위치에서 A가 아닌 문자로 얼마나 갈 수 있는지 판단
			}
			answer += leftOrRight;
			return answer;
		}
	}
}
