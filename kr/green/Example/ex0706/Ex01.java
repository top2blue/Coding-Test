package kr.green.Example.ex0706;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*
124 나라의 숫자
124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

10진법	124 나라	10진법	124 나라
1		1			6		14
2		2			7		21
3		4			8		22
4		11			9		24
5		12			10		41
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 
solution 함수를 완성해 주세요.

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
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution2(1),"1");
		assertEquals(solution.solution2(2),"2");
		assertEquals(solution.solution2(3),"4");
		assertEquals(solution.solution2(4),"11");
		assertEquals(solution.solution2(5),"12");
		assertEquals(solution.solution2(6),"14");
		assertEquals(solution.solution2(7),"21");
		assertEquals(solution.solution2(8),"22");
		assertEquals(solution.solution2(9),"24");
		assertEquals(solution.solution2(10),"41");
	}
	class Solution {
		public String solution(int n) {
			String[] numbers = "4,1,2".split(",");
		      String answer = "";
		      while(n > 0){
		          int mod = n%3;
		          answer = numbers[mod] + answer;
		          n /= 3;
		          if(mod == 0) n--;
		      }
		      System.out.println(answer);
		      return answer;
		}
		public String solution2(int n) {
		      String answer = "";
		      int rest=0;
		      while(n>0){
		          rest = n%3;
		          n /= 3;
		          // 나머지가 0일때 몫을 하나 떨궈주고 나머지를 4로 교체시켜줌
		          if(rest == 0) {
		              rest = 4;
		              n-=1;
		          }
		          answer = rest + answer;
		      }
		      System.out.println(answer);
		      return answer;
		  }
	}
}
