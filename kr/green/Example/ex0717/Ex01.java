package kr.green.Example.ex0717;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
소수 찾기
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예
numbers	return
17		3
011		2
예제 #1 : [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
예제 #2 : [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
		  11과 011은 같은 숫자로 취급합니다.
 */

// https://velog.io/@junhok82/Java%EB%A1%9C-%EC%88%9C%EC%97%B4Permutation-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution("17"), 3);
		assertEquals(solution.solution("011"), 2);
	}
	class Solution {
		public int solution(String numbers) {
			String[] strArr = numbers.split(""); // 1글자씩 잘라서 배열로 만듬
			Set<String> set = new HashSet<>(); // 소수가 저장될 셑(중복 허용하지 않는다.)
			// 1부터 만들 수 있는 최대 길이까지 숫자 조합
			for (int i = 1; i <= strArr.length; i++) perm(strArr, 0, i, set);
			return set.size();
		}
		// 순열을 구하는 메서드
		public void perm(String[] arr, int depth, int k, Set<String> set) {// 숫자 조합
			if (depth == k) {// 원하는 k개의 숫자가 세팅됐으므로 더이상 순열생성X
				String str = "";
				for (int i = 0; i < k; i++) str += arr[i];
				System.out.println(str); // 순열값
				primeNumber(set, str); // 소수 판단
				return;
			} else {
				for (int i = depth; i < arr.length; i++) {
					swap(arr, i, depth);
					perm(arr, depth + 1, k, set);
					swap(arr, i, depth);
				}
			}
		}
		public void swap(String[] arr, int i, int j) { // 교환
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		public void primeNumber(Set<String> set, String str) {// 소수 체크
			int num = Integer.parseInt(str);
			boolean prime = true;
			if (num <= 1) {
				return;
			}
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				set.add(num + "");
			}
		}
	}

}
