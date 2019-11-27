package exam1126;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

/*
문제 1] 다리를 지나는 트럭
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 	시간			다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0		[]				[]					[7,4,5,6]
1~2		[]				[7]					[4,5,6]
3		[7]				[4]					[5,6]
4		[7]				[4,5]				[6]
5		[7,4]			[5]					[6]
6~7		[7,4,5]			[6]					[]
8		[7,4,5,6]		[]					[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 
트럭별 무게 truck_weights가 주어집니다. 
이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.

입출력 예
bridge_length	weight	truck_weights							return
2				10			[7,4,5,6]							8
100				100			[10]								101
100				100			[10,10,10,10,10,10,10,10,10,10]		110
*/
public class Ex01 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(2, 10, new int[]{7,4,5,6}), 8);
		assertEquals(solution.solution(100, 100, new int[]{10}), 101);
		assertEquals(solution.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}), 110);
	}
	/*
	 가장 먼저 들어온 트럭이 가장 먼저 나가게 되는 구조이다. 따라서 Queue를 사용하였다.
	 1. 0번째 배열은 무조건 들어갈 수 있기 때문에 반복문 전에 미리 Queue에 넣는다.
	 2. front 부터 rear 까지 delay[i]값을 증가시키면서 delay[i]가 bridge_length보다 큰지 확인한다.
	 3. 만약 bridge_length보다 커지면, Queue에서 빼고 그 원소가 빠졌음을 알기 위해 front값을 증가시킨다.
	 4. 그 다음으로는 트럭이 더 들어갈 수 있는지 확인한다.
	 5. Queue에 들어가있는 원소의 합과 다음 원소가 weight이하인지 확인한다.
	 6. 만약 weight이하라면 그 원소를 Queue에 넣고, rear값과 delay[rear]를 증가시킨다.
	 7. Queue가 비면 반복문을 종료한다.
	 */
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        int second = 0; //시간을 계산할 변수
	        
	        Queue<Integer> queue = new LinkedList<>();
	        int[] delay = new int[truck_weights.length];	// Queue에 머물러 있는 시간을 계산하기 위한 배열
	        int front = 0; 	// Queue에 들어가있는 맨 앞 원소의 배열 인덱스
	        int rear = 0;	// Queue에 들어가있는 맨 마지막 원소의 배열 인덱스
	        
	        queue.offer(truck_weights[0]); // 1번
	        second++;
	        delay[0]++;
	        
	        while((!queue.isEmpty())){ // 7번
	            second++;
	            for(int i = front; i <= rear; i++){ // 2번
	                delay[i]++;
	                if(delay[i] > bridge_length){ // 3번
	                	queue.poll();
	                    front++;
	                }
	            }
	            if (!(rear + 1 == truck_weights.length)){ // 4번
	                if((sum(truck_weights, front, rear) + truck_weights[rear + 1]) <= weight){ // 5번
	                	queue.offer(truck_weights[++rear]); // 6번
	                    delay[rear]++;
	                }
	            }
	        }
	        answer = second;
	        return answer;
	    }
	    // 5번 : 합계
	    public int sum(int[] arr, int idx1, int idx2){
	        int sum = 0;
	        for(int i = idx1; i <= idx2; i++) sum += arr[i];    
	        return sum;
	    }
	}
}
