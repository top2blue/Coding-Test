package kr.green.Example.ex0630;

import static org.junit.Assert.assertArrayEquals;
/*
최대공약수와 최소공배수
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 
solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.
입출력 예
n	m	return
3	12	[3, 12]
2	5	[1, 10]
 */
import org.junit.Test;

public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(3, 12), new int[] { 3, 12 });
		assertArrayEquals(solution.solution(2, 5), new int[] { 1, 10 });
	}

	class Solution {
		/*
		 * 유클리드 호제법(Euclidean algorithm) 또는 유클리드 알고리즘은 
		 * 2개의 자연수 또는 정식(整式)의 최대공약수를 구하는 알고리즘의 하나이다.
		 * 
		 * 알고리즘
		   1. 입력으로 두 수 m,n(m>n)이 들어온다.
		   2. n이 0이라면, m을 출력하고 알고리즘을 종료한다.
		   3. m이 n으로 나누어 떨어지면, n을 출력하고 알고리즘을 종료한다.
		   4. 그렇지 않으면, m을 n으로 나눈 나머지를 새롭게 m에 대입하고, m과 n을 바꾸고 3번으로 돌아온다.
			
		   위 과정은 "n, m에 대해서 나머지 연산을 실시할 수 있다"라는 조건에만 의존하므로, 
		   정수환뿐 아니라, 임의의 유클리드 정역에 대해도 똑같은 과정을 거치면 공약인자가 
		   구해진다.
		 */
		 public int[] solution(int n, int m) {
		      int[] answer = new int[2];
		      answer[0] = gcd(n,m);
		      answer[1] = lcm(n,m);
		      return answer;
		  }
		  public int gcd(int a, int b) { // 최대 공약수
			  return a%b==0 ? b : gcd(b,a%b);
		  }
		  public int lcm(int a, int b) { // 최소 공배수
			  // 0이 아닌 두수의 곱/두수의 최대 공약수
			  return (a*b)/gcd(a,b);
		  }
	}
}
