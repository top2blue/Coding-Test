package kr.green.Example.ex0625;
/*
소수 찾기
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)
제한 조건
n은 2이상 1000000이하의 자연수입니다.
입출력 예
n		result
10		4
5		3
*/
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution1(10), 4);
		assertEquals(solution.solution1(5), 3);
		assertEquals(solution.solution2(10), 4);
		assertEquals(solution.solution2(5), 3);
		assertEquals(solution.solution3(10), 4);
		assertEquals(solution.solution3(5), 3);
		assertEquals(solution.solution4(10), 4);
		assertEquals(solution.solution4(5), 3);
		assertEquals(solution.solution5(10), 4);
		assertEquals(solution.solution5(5), 3);
	}
	class Solution {
		public int solution1(int n) {
			int answer = 0;
			for(int i=2;i<=n;i++) {
				int cnt = 0; // 약수의 개수
				for(int j=1;j<=i;j++) { // 1 ~ n
					if(i%j==0) cnt++; // 나누어지면 약수이다.
				}
				if(cnt==2) { // 약수의 개수가 2개면 소수다.
					answer++;
					System.out.printf("%4d", i);
				}
			}
			System.out.println();
			return answer;
		}
		public int solution2(int n) {
			int answer = 0;
			for(int i=2;i<=n;i++) {
				int j=2;
				while(i%j!=0)j++; // 2부터 나누어 질때까지 반복
				if(i==j) { // 나누어 졌을때 그수가 자신이라면 소수이다.
					answer++;
					System.out.printf("%4d", i);
				}
			}
			System.out.println();
			return answer;
		}
		public int solution3(int n) {
			int answer = 0;
			for(int i=2;i<=n;i++) { // 2~n
				boolean flag = true; // 일단 소수라고 가정
				for(int j=2;j<=i/2;j++) { // 절반까지만 나누어 본다.
					if(i%j==0) { // 나누어 지면
						flag=false; // 소수가 아니다.
						break;
					}
				}
				if(flag) { // flag가 true라면 나누어진적이 없다. 소수다
					answer++;
					System.out.printf("%4d", i);
				}
			}
			System.out.println();
			return answer;
		}
		public int solution4(int n) {
			int answer = 0;
			loop:
			for(int i=2;i<=n;i++) {
				for(int j=2;j<=i/2;j++) { // 절반까지만 나누어 본다
					if(i%j==0) continue loop; // 나누어지면 소수가 아니다.
				}
				answer++;
				System.out.printf("%4d", i);
			}
			System.out.println();
			return answer;
		}
		// 에라토스테네스의 체 알고리즘
		public int solution5(int n) {
			int answer = 0;
			int ar[] = new int[n+1]; // 크기보다 1 크게 배열 선언
			for(int i=2;i<ar.length;i++) {
				// 이미 체크된 수의 배수들은 합성수
				if(ar[i]==1) continue;
				//i를 제외한 i의 배수들을 1로 체크
				for(int j=i+i;j<ar.length;j+=i)	ar[j] = 1; 
			}
			for(int i=2;i<ar.length;i++) {
				if(ar[i]!=1) { // 1이아닌(배수가 아닌) 갯수
					answer++;
					System.out.printf("%4d", i);
				}
			}
			System.out.println();
			return answer;
		}
	}
}
