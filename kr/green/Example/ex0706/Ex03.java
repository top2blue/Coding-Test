package kr.green.Example.ex0706;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex03 {
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
