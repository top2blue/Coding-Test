package kr.green.Example.ex0630;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
콜라츠 추측
1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면, 
모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.

1-1. 입력된 수가 짝수라면 2로 나눕니다. 
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.

2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
예를 들어, 입력된 수가 6이라면 6→3→10→5→16→8→4→2→1 이 되어 총 8번 만에 1이 됩니다. 
위 작업을 몇 번이나 반복해야하는지 반환하는 함수, solution을 완성해 주세요. 
단, 작업을 500번을 반복해도 1이 되지 않는다면 1을 반환해 주세요.

제한 사항
입력된 수, num은 1 이상 8000000 미만인 정수입니다.

입출력 예
n	result
6	8
16	4
626331	-1
*/
public class Ex03 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(6), 8);
		assertEquals(solution.solution(16), 4);
		assertEquals(solution.solution(626331), -1);
		assertEquals(solution.solution2(6), 8);
		assertEquals(solution.solution2(16), 4);
		assertEquals(solution.solution2(626331), -1);
		assertEquals(solution.solution3(6), 8);
		assertEquals(solution.solution3(16), 4);
		assertEquals(solution.solution3(626331), -1);
		assertEquals(solution.solution4(6), 8);
		assertEquals(solution.solution4(16), 4);
		assertEquals(solution.solution4(626331), -1);
	}
	class Solution {
		public int solution(long n) {
			int answer = 0;
			while(n!=1) { // 1이 될때까지
				n = (n%2==0) ? n/2 : n*3+1; // 짝수라면 2로 나누고 홀수라면 3을 곱하고 1을 더한다.
				answer++; // 횟수 증가
				if(answer>=500) return -1; // 500회 이상이면 -1 리턴
			}
			return answer;
		}
		public int solution2(long n) {
			int answer = 0;
			while(answer<500) { // 500회 까지만
				n = (n%2==0) ? n/2 : n*3+1; // 짝수라면 2로 나누고 홀수라면 3을 곱하고 1을 더한다.
				answer++; // 횟수 증가
				if(n==1) return answer; // n이 1이 반복횟수 리턴
			}
			return -1; // 500회 이상이면 -1 리턴 
		}
		public int solution3(long n) {
			int answer = 0;
			while(answer<500 && n!=1) { 
				n = (n%2==0) ? n/2 : n*3+1; 
				answer++;
			}
			return n==1 ? answer : -1; 
		}
		public int solution4(long n) {
			int answer = 0;
			for(;answer<500 && n!=1;answer++) {
				n = (n%2==0) ? n/2 : n*3+1;
			}
			return n==1 ? answer : -1; 
		}
	}
}
