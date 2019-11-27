package exam1127;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/*
구명보트
무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 
구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 
2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 
구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
제한사항
무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
입출력 예
people				limit	return
[70, 50, 80, 50]	100		3
[70, 80, 50]		100		3
 */
public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[] {70, 50, 80, 50},100), 3);
		assertEquals(solution.solution(new int[] {70, 80, 50},100), 3);
		assertEquals(solution.solution(new int[] {10,20,30,40,50,60,70,80,90}, 100), 5);
	}
	class Solution {
		/*
		 1. 정렬을 합니다.
		 2. 여기서 처음 50을 비교할 때 그다음 50을 비교하는 것이 아니라 가장 마지막인 80을 비교했습니다
		 3. 그래서 2개를 합했을 때 limit보다 크냐 작으냐 비교했습니다
		 4. 50은 가장 작은 수 입니다 여기서 다른 수하고 더했을 때 limit보다 크면 80은 무조건 혼자 탈 수 밖에 없다고 생각했습니다. 
		    그래서 limit보다 크면 answer에 1개 증가시킵니다. 그다음 50과 70 비교했는데 역시 limit보다 크므로 1개 증가합니다
            그리고 50 과 50을 더했는데 limit보다 작으므로 2명이서 1개를 탈 수 있으니 answer한개 증가하고 
            첫 번째 50 그 다음 수와 비교하게 됩니다.
			
		 5.	2번 째 예시에서 50 70 80에서 50은 자신과 같이 탈 수 있는 사람이 없습니다. 
			for문에서는 70까지 비교하기 때문에 마지막에 50도 혼자 타야하는 것도 넣어줘야합니다.		
		 */
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        System.out.println(Arrays.toString(people));
	        int start = 0, end = people.length-1;
	        while(end > start) {
	    		if (people[end] + people[start] <= limit) {
	    			start++;
	    			answer++;
	    		} else {
	    			answer++;
	    		}
	    		end--;
	    		System.out.printf("a : %d, s : %d, e : %d\n", answer, start, end);
	    	}
	    	if (start == end) answer++;
	    	System.out.println(answer + "\n");
	        return answer;
	    }
	    
	    public int solution2(int[] people, int limit) {
	    	int answer = 1;
	    	Arrays.sort(people);
	    	int i = 0;
	    	int sum = 0;
	    	do {
	    		do {
	    			sum += people[i];
	    			i++;
	    			System.out.println(sum + " : " + i + " : " + answer);
	    		}while(sum<=limit && i < people.length);
	    		i--;
	    		++answer;
	    		sum=0;
	    	}while(i<people.length-1);
	    	System.out.println(answer + "\n\n");
	    	return answer;
	    }
	}
}