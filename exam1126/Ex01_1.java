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
public class Ex01_1 {
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertEquals(solution.solution(2, 10, new int[] { 7, 4, 5, 6 }), 8);
		assertEquals(solution.solution(100, 100, new int[] { 10 }), 101);
		assertEquals(solution.solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }), 110);
	}
	/*
	1. 다리에 현재 가르키는 트럭이 들어가도 되는지 확인하고, 
	   들어갈 수 있다면 idx가 다음 트럭을 가리키게 한 뒤 현재 트럭이 들어간다. 
	   이 때 들어가는 값은 트럭의 무게 값이 아닌 트럭의 이동 시간 값이다.
	
	2. 트럭이 다리 안으로 들어가면 increaseTime() 함수를 통해 트럭의 이동시간을 늘린다. 
	3. 이 때 트럭의 이동시간이 bridge_length와 같아지면 트럭을 다리에서 빼낸다.
	
	이 같은 동작이 idx가 전체 트럭의 수와 같아질 때까지 계속 반복된다.
	그런데 반복문 안에서는 마지막 트럭의 이동시간이 계산되지 않기 때문에, 
	반복문이 종료되면 마지막 트럭의 이동시간을 더해준 뒤 모든 동작을 마무리 한다.
	*/
	class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			int answer = 0;
			int bridge_weight = 0;
			Queue<Integer> truck_time = new LinkedList<>();
			int idx = 0;
			while (idx < truck_weights.length) {
				answer++;
				int curTruck = truck_weights[idx];
				if (bridge_weight + curTruck <= weight) { // 
					idx++;
					bridge_weight += curTruck;
					truck_time.offer(0);
				}
				increaseTime(truck_time); // 2
				System.out.println(truck_time);
				if (truck_time.peek() == bridge_length) { // 3 
					bridge_weight -= truck_weights[idx - truck_time.size()];
					truck_time.poll();
				}
			}
			System.out.println(answer + ":" + bridge_length + "\n\n");
			answer += bridge_length;
			return answer;
		}
	}
	
	public void increaseTime(Queue<Integer> time) {
		for (int i = 0; i < time.size(); i++) {
			time.offer(time.poll() + 1);
		}
	}
}
