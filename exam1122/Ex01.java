package exam1122;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 1] 멀쩡한 사각형
가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 
종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 모든 격자칸은 1cm x 1cm 크기입니다. 
이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 
누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 
그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 
새로운 종이를 구할 수 없는 상태이기 때문에, 
이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

제한사항
W, H : 1억 이하의 자연수

입출력 예
W		H		result
8		12		80

입출력 예 #1 : 가로가 8, 세로가 12인 직사각형을 대각선 방향으로 자르면 총 16개 정사각형을 사용할 수 없게 됩니다. 
원래 직사각형에서는 96개의 정사각형을 만들 수 있었으므로, 96 - 16 = 80 을 반환합니다.
*/
public class Ex01 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(8,12), 80);
		assertEquals(solution.solution(12,8), 80);
		assertEquals(solution.solution(12,12), 132);
	}
	/*
	 * 1. 선이 지나가면서 겹치는 사각형 개수는 블록 단위(빨간색 사각형)로 규칙적이다.
	 * 2. 블록의 크기는  (w / 최대 공약수) x  (h / 최대 공약수)  이다.
	 * 3. 한 블록 안에서 (블록의 가로 크기 + 블록의 세로 크기 - 1) 수만큼의 사각형 위로 선이 지나간다.
	 */
	class Solution {
		public long solution(int w,int h) {
			long answer = 1;
			int gcd= getGCD(w, h);
			answer = ((long)w*h)-gcd*((w/gcd)+(h/gcd)-1);
			System.out.println(gcd + " : " + answer);
			return answer;
		}
		//유클리드 호제법을 이용한 GCD(최대공약수)구하기
		private int getGCD(int num1, int num2) {
			while(num1 > 0){
				if(num1<num2) {// 교환
					num1 = num1 ^ num2;
					num2 = num1 ^ num2;
					num1 = num1 ^ num2;
				}
				num1 -= num2;
	        }
			return num2;
		}
	}
}
