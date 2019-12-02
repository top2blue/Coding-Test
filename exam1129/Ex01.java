package exam1129;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
프린터
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 
그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 
이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.

예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 
내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

제한사항
현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 
대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.

입출력 예
priorities			location	return
[2, 1, 3, 2]			2			 1
[1, 1, 9, 1, 1, 1]		0			 5

입출력 예 설명
예제 #1 : 문제에 나온 예와 같습니다.
예제 #2 : 6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
 */

public class Ex01 {

	public static void main(String[] args) {
		System.out.println(getSequential(new int[] {2, 1, 3, 2}));
		System.out.println(getSequential(new int[] {1, 1, 9, 1, 1, 1}));
	}
	private static String getSequential(int[] priorities) {
		String queue =  "";
		String result = "";
		// 데이터 넣기
		for(int i=0;i<priorities.length;i++) queue += (char)('A'+i);
		do {
			// 최대값 위치 구하기
			int max = priorities[0];
			int index = 0;
			for(int i=1;i<priorities.length;i++) {
				if(max<priorities[i]) {
					max = priorities[i];
					index = i;
				}
			}
			// 결과 저장
			result += queue.charAt(index);
			// 문자 이동
			String queue2 = "";
			for(int i=0;i<index;i++) {
				queue2 += queue.charAt(i);
			}
			queue = queue.substring(index+1) + queue2;
			// 배열 이동
			int[] ar = new int[priorities.length]; 
			// 배열 뒷부분을 앞으로이동
			System.arraycopy(priorities, index+1, ar, 0, priorities.length-index-1);
			// 앞부분을 뒤에 붙이기
			for(int i=0;i<index;i++) ar[i+index-1] = priorities[i];
			priorities = ar;
			System.out.println(result + " >> " + queue + " >> " + Arrays.toString(priorities));
		}while(result.length()<priorities.length);
		return result;
	}
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[] { 2, 1, 3, 2 }, 2), 1);
		assertEquals(solution.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0), 5);
		System.out.println();
		
		Solution2 solution2 = new Solution2();
		assertEquals(solution2.solution(new int[] { 2, 1, 3, 2 }, 2), 1);
		assertEquals(solution2.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0), 5);
		System.out.println();
	}
	
	class Solution2{
		public int solution(int[] priorities, int location) {
			int answer = 0;
			String result = getSequential(priorities);
			char search = (char)('A' + location);
			for(char ch : result.toCharArray()) {
				++answer;
				if(ch == search) break;
			}
			return answer;
		}
		
		private String getSequential(int[] priorities) {
			String queue =  "";
			String result = "";
			// 데이터 넣기
			for(int i=0;i<priorities.length;i++) queue += (char)('A'+i);
			do {
				// 최대값 위치 구하기
				int max = priorities[0];
				int index = 0;
				for(int i=1;i<priorities.length;i++) {
					if(max<priorities[i]) {
						max = priorities[i];
						index = i;
					}
				}
				// 결과 저장
				result += queue.charAt(index);
				// 문자 이동
				String queue2 = "";
				for(int i=0;i<index;i++) {
					queue2 += queue.charAt(i);
				}
				queue = queue.substring(index+1) + queue2;
				// 배열 이동
				int[] ar = new int[priorities.length]; 
				// 배열 뒷부분을 앞으로이동
				System.arraycopy(priorities, index+1, ar, 0, priorities.length-index-1);
				// 앞부분을 뒤에 붙이기
				for(int i=0;i<index;i++) ar[i+index-1] = priorities[i];
				priorities = ar; // 배열 변경
				//System.out.println(result + " >> " + queue + " >> " + Arrays.toString(priorities));
			}while(result.length()<priorities.length);
			System.out.println(result);
			return result;
		}
	}
	
	
	class Solution {
		@Getter @Setter
		@AllArgsConstructor
		@NoArgsConstructor
		@EqualsAndHashCode
		class Pair{
			public int 		pri;
			public char 	doc;
			
			@Override
			public String toString() {
				return doc+"(" + pri + ")";
			}
		}
		
		public int solution(int[] priorities, int location) {
			int answer = 0;
			Queue<Pair> result = getSequential(priorities);
			char search = (char)('A' + location);
			for(Pair pair : result) {
				++answer;
				if(pair.doc==search) break;
			}
			System.out.println();
			return answer;
		}
		
		private Queue<Pair> getSequential(int[] priorities) {
			Queue<Pair> queue = new LinkedList<Pair>();
			Queue<Pair> queue2 = new LinkedList<Pair>();
			Queue<Pair> result = new LinkedList<Pair>();
			// 데이터 넣기
			for(int i=0;i<priorities.length;i++) queue.add(new Pair(priorities[i], (char)('A'+i)));
			
			while(!queue.isEmpty()) {
				Pair start = queue.poll(); // 꺼내기
				Pair max = start;
				Pair pair = start;
				queue2.add(start); // 이동
				while (!queue.isEmpty()) {
					pair = queue.poll();
					if(max.pri <pair.pri) {
						max = pair;
					}
					queue2.add(pair);
				}// 최대값 구하기
				while(true){
					pair = queue2.poll();
					if(pair.equals(max)) break;
					queue2.add(pair); // 최대값이 아니면 뒤에 추가
				} // 최대 값을 만나면 탈출 
				while(!queue2.isEmpty()) queue.add(queue2.poll()); // 복사
				result.add(max);
			}
			System.out.println(result);
			return result;
		}
	}
}
