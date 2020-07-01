package kr.green.Example.ex0618;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
/*
모의고사
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 
전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

입출력 예
answers			return
[1,2,3,4,5]		[1]
[1,3,2,4,2]		[1,2,3]
입출력 예 설명
입출력 예 #1
수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
입출력 예 #2
모든 사람이 2문제씩을 맞췄습니다.
*/
public class Ex01 {
	@Test
	public void testSolution() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(new int[] {1,2,3,4,5}), new int[] {1});
		assertArrayEquals(solution.solution(new int[] {1,3,2,4,2}), new int[] {1,2,3});
		assertArrayEquals(solution.solution(new int[] {1, 3, 3, 4, 5}), new int[] {1});
	}
}
class Solution {
	public int[] solution(int[] answers) {
		// 수포자들의 정답 패턴
		int[] user1 = {1, 2, 3, 4, 5};
		int[] user2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] user3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		// 채첨을 저장할 배열
		int[] result = new int[3];
		// 채점
		for(int i=0;i<answers.length;i++) {
				if(answers[i]==user1[i%user1.length]) result[0]++;
				if(answers[i]==user2[i%user2.length]) result[1]++;
				if(answers[i]==user3[i%user3.length]) result[2]++;
		}
		System.out.println(Arrays.toString(result));
		// 점수의 최대값을 구한다.
		int max = Math.max(result[0], Math.max(result[1], result[2]));
		// 점수의 최대값과 일치하는 값을 가진 학생의 번호를 배열에 담아 정렬한다.
		int cnt = 0;
		for(int i=0;i<result.length;i++) if(max==result[i]) cnt++;
		int [] r = new int[cnt];
		for(int i=0;i<result.length;i++) if(max==result[i]) r[i] = i+1;
		// Arrays.sort(r);
		// 리턴한다.
		System.out.println(Arrays.toString(r));
		return r;
	}
	public int[] solution2(int[] answers) {
		int[] supoja1 = { 1, 2, 3, 4, 5 };
		int[] supoja2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] supoja3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) list.add(0);
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == supoja1[i%5]) list.set(0, list.get(0)+1);
			if (answers[i] == supoja2[i%8]) list.set(1, list.get(1)+1);
			if (answers[i] == supoja3[i%10]) list.set(2, list.get(2)+1);
		}
		System.out.println(list);
		int max = Collections.max(list);
		
		List<Integer> returnList = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) if(max == list.get(i)) returnList.add(i+1);
		
		int[] answer = new int[returnList.size()];
		for(int i=0; i<returnList.size(); i++) answer[i] = returnList.get(i);
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}