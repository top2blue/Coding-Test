package kr.green.Example.ex0723;

import static org.junit.Assert.assertEquals;

import java.io.ObjectInputStream.GetField;

import org.junit.Test;

/*
피보나치 수
문제 설명
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 
적용되는 수 입니다.

예를들어

F(2) = F(0) + F(1) = 0 + 1 = 1
F(3) = F(1) + F(2) = 1 + 1 = 2
F(4) = F(2) + F(3) = 1 + 2 = 3
F(5) = F(3) + F(4) = 2 + 3 = 5
와 같이 이어집니다.

2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, 
solution을 완성해 주세요.

제한 사항
* n은 1이상, 100000이하인 자연수입니다.

입출력 예
n	return
3	2
5	5
입출력 예 설명
피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
 */
public class Ex03 {
	
	public static void main(String[] args) {
		for(int i=0;i<=10;i++) {
			System.out.println(getFibo(i));
		}
		System.out.println(getFibo(1000));
		System.out.println(getFibo(10000));
		System.out.println(getFibo(100000));
	}
	public static int getFibo(int n) {
		int first=0,second=1;
		for(int i=0;i<n;i++) {
			second += first;
			first = second-first;
		}
		return first;
	}
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(3), 2);
		assertEquals(solution.solution(5), 5);
	}
	
	class Solution {
	    public int solution(int n) {
	        return getFibo(n);
	    }
	    public int getFibo(int n) {
			int first=0,second=1, temp;
			for(int i=0;i<n;i++) {
				temp = second;
				second += first;
				second %= 1234567;
				first = temp;
			}
			return first;
		}
	}
	
	
}
