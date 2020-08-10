package kr.green.Example.ex0723;
/*
H-Index
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 
어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 
위키백과에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 
나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 
이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

제한사항
과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

입출력 예
citations		return
[3, 0, 6, 1, 5]	3

입출력 예 설명
이 과학자가 발표한 논문의 수는 5편이고, 
그중 3편의 논문은 3회 이상 인용되었습니다. 
그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

※ 공지 - 2019년 2월 28일 테스트 케이스가 추가되었습니다.
 */

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[] {3, 0, 6, 1, 5}), 3);
	}
	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        int len = citations.length;
	        Arrays.sort(citations); // 정렬
	        System.out.println(Arrays.toString(citations));
	        // 원소 값은 점점 감소하고, 원소 값 이상인 것의 개수는 점점 감소하므로 
	        // 이 두 값의 최소값의 변화가 증가하다가 감소하는 지점을 찾으면 답!!!
	        for (int i = 0; i < len; i++) {
	        	System.out.println(len-i + " : " + citations[i] );
	            if (len - i <= citations[i]) {
	                answer = len - i;
	                break;
	            }
	        }
	        return answer;
	    }
	}
}
