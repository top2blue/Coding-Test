package exam1125;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 1] 124 나라의 숫자
124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

10진법	124 나라	10진법	124 나라
1			 1			 6		14
2			 2			 7		21
3			 4			 8		22
4			11			 9		24
5			12			10		41
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

제한사항
n은 500,000,000이하의 자연수 입니다.

입출력 예
n	result
1	1
2	2
3	4
4	11
*/
public class Ex01 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(1), "1");
		assertEquals(solution.solution(2), "2");
		assertEquals(solution.solution(3), "4");
		assertEquals(solution.solution(4), "11");
		assertEquals(solution.solution(5), "12");
		assertEquals(solution.solution(6), "14");
		assertEquals(solution.solution(7), "21");
		assertEquals(solution.solution(8), "22");
		assertEquals(solution.solution(9), "24");
		assertEquals(solution.solution(10), "41");
		System.out.println();
		assertEquals(solution.solution2(1), "1");
		assertEquals(solution.solution2(2), "2");
		assertEquals(solution.solution2(3), "4");
		assertEquals(solution.solution2(4), "11");
		assertEquals(solution.solution2(5), "12");
		assertEquals(solution.solution2(6), "14");
		assertEquals(solution.solution2(7), "21");
		assertEquals(solution.solution2(8), "22");
		assertEquals(solution.solution2(9), "24");
		assertEquals(solution.solution2(10), "41");
	}

	class Solution {
		/*
		 1 2 4 는 3번을 주기로 돌아가므로 n을 3으로 나눠가며
		 몫은 다시 n에 저장하고 n을 나눈 나머지는 string에 붙여가면 된다.
		 3으로 나눈 나머지는 0, 1, 2 가 나오므로 1, 2 는 그대로 붙이면 되며 0이 나올때만 4를 string에 붙이면 된다.
		 단 이때는 n을 갱신 할 때 3을 나눈 몫에다가 1 을 빼주어야 한다.
		 이유는 n이 3일 때 보면 된다. n이 3이면 나눈 나머지는 0이 되고 몫은 1이된다.
		 만약 나눈 나머지가 0일 때 4를 이어 붙인 후 1을 빼지 않으면 몫은 1이 갱신되며
		 결국 값은 14가 되고 말 것이다. n이 3일 때는 4가 답이다.
		 */
		public String solution(int n) {
			String answer = "";
			int temp = 0;

			while (n > 0){
				temp = n % 3;
				if (temp == 0) 
					n = (n / 3) - 1;
				else 
					n /= 3;
				answer = "412".charAt(temp) + answer;
			}

			System.out.println(answer);
			return answer;
		}
		
		public String solution2(int n) {
			String answer = "";
			int temp = 0;
			
			while (n > 0){
				temp = n % 3;
				if (temp==0){
					temp = 4;
					n = (n / 3) - 1;
				}else {
					n /= 3;
				}
				answer = temp + answer;
			}

			System.out.println(answer);
			return answer;
		}
	}
}
