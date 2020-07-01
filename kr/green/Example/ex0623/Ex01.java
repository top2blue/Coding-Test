package kr.green.Example.ex0623;
/*
문자열 내 마음대로 정렬하기
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로
오름차순 정렬하려 합니다. 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 
문자 u, e, a로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

입출력 예
strings				n		return
[sun, bed, car]		1		[car, bed, sun]
[abce, abcd, cdx]	2		[abcd, abce, cdx]

입출력 예 1
sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 
이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.

입출력 예 2
abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 
따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다. 
abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.
 */

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(new String[] { "sun", "bed", "car" }, 1),
				new String[] { "car", "bed", "sun" });
		assertArrayEquals(solution.solution(new String[] { "abce", "abcd", "cdx" }, 2),
				new String[] { "abcd", "abce", "cdx" });
		assertArrayEquals(solution.solution2(new String[] { "sun", "bed", "car" }, 1),
				new String[] { "car", "bed", "sun" });
		assertArrayEquals(solution.solution2(new String[] { "abce", "abcd", "cdx" }, 2),
				new String[] { "abcd", "abce", "cdx" });
	}

	class Solution {
		public String[] solution(String[] strings, int n) {
			//           대상, 정렬기준
			Arrays.sort(strings, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// 같으면 0, 앞이 크면 양수, 뒤가크면 음수를 리턴하게 만들면 된다.
					if(o1.charAt(n) - o2.charAt(n) == 0) { // n번째 글자가 같다면
						return o1.compareTo(o2); // 사전순으로 정렬
					}
					return o1.charAt(n) - o2.charAt(n); // n번째 글자를 기준으로 정렬
				}
			});
			System.out.println(Arrays.toString(strings));
			return strings;
		}
		public String[] solution2(String[] strings, int n) {
			String[] answer = new String[strings.length]; // 결과 저장 할 배열
			String t[] = new String[strings.length]; // 임시 배열
			for(int i=0;i<strings.length;i++) {
				// 임시 배열에 원본 배열의 문자열 앞에 n번째 글자를 붙여서 저장
				t[i] = strings[i].charAt(n) + strings[i]; 
			}
			Arrays.sort(t); // 정렬
			System.out.println(Arrays.toString(t)); // 출력
			for(int i=0;i<t.length;i++) {
				answer[i] = t[i].substring(1); // 앞의 첫글자를 뺀 놈이 결과다.
			}
			System.out.println(Arrays.toString(answer));
			return answer;
		}
	}
}
