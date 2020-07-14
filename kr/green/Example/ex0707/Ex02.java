package kr.green.Example.ex0707;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
다리를 지나는 트럭
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과시간		다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0				[]					[]					[7,4,5,6]
1~2				[]					[7]					[4,5,6]
3				[7]					[4]					[5,6]
4				[7]					[4,5]				[6]
5				[7,4]				[5]					[6]
6~7				[7,4,5]				[6]					[]
8				[7,4,5,6]			[]					[]
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
bridge_length	weight	truck_weights						return
2				10		[7,4,5,6]							8
100				100		[10]								101
100				100		[10,10,10,10,10,10,10,10,10,10]		110
 */
public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(2, 10, new int[] {7,4,5,6}), 8);
		assertEquals(solution.solution(100, 100, new int[] {10}), 101);
		assertEquals(solution.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}), 110);
		assertEquals(solution.solution(2,   4, new int[] {1,2,1,2}), 6);
	}
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	    	int answer = 0;
	        Queue<Integer> queue = new LinkedList<>();
	        int max = 0;
	        for(int w : truck_weights) {
	            while(true) {
	                if(queue.isEmpty()) {
	                	queue.offer(w);
	                    max += w;
	                    answer++;
	                    break;
	                } else if(queue.size() == bridge_length) {
	                    max -= queue.poll();
	                } else {
	                    if( max + w > weight) {
	                    	queue.offer(0);
	                        answer++;
	                    } else {
	                    	queue.offer(w);
	                        max += w;
	                        answer++;
	                        break;
	                    }
	                }
	            } 
	        }
	        return answer + bridge_length;
	    }
	    
	    public int solution2(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	    	int[] endTime = new int[truck_weights.length];
		    Queue<Integer> onBridge = new LinkedList<Integer>();
	        int cur=0; // 현재 트럭의 위치
	        while(true) {
	        	// 트럭이 다리를 다 지났으면, queue 크기는 다리 길이와 동일하므로 
	        	// queue에서 꺼내 최대 무게에서 빼준다.
	            if(!onBridge.isEmpty() && endTime[onBridge.peek()] == answer) {
	                weight += truck_weights[onBridge.poll()]; // 큐에서 꺼내 무게 증가
	            }
	            // 현재 위치가 끝이 아니면서 트럭의 무게가 무게를 초과하지 않는다면
	            if(cur < truck_weights.length && truck_weights[cur] <= weight) {
	                onBridge.offer(cur); // 다리에 진입한다.
	                endTime[cur] = answer + bridge_length; // 현재 시간에 다리의 길이를 더해서 넣는다.
	                weight -= truck_weights[cur]; // 무게는 빼준다.
	                cur++; // 다음 트럭으로
	            }
	            answer++; // 시간 증가 
	            if(onBridge.isEmpty()) break; // 다리위에 아무것도 없으면 종료
	        }
	        return answer;
	    }
	}

}
