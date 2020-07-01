package kr.green.Example.ex0611;

import java.util.Arrays;

/*
문제 1] Jolly Jumpers
출처 : programming-challenges.com
n개의 정수(n>0)로 이루어진 수열에 대해 서로 인접해 있는 두 수의 차가 1에서 n-1까지의 값을 모두 가지면 
그 수열을 유쾌한 점퍼(jolly jumper)라고 부른다. 예를 들어 다음과 같은 수열에서
1 4 2 3
앞 뒤에 있는 숫자 차의 절대 값이 각각 3,2,1이므로 이 수열은 유쾌한 점퍼가 된다. 
어떤 수열이 유쾌한 점퍼인지 판단할 수 있는 프로그램을 작성하라.

Input
각 줄 맨 앞에는 3000 이하의 정수가 있으며 그 뒤에는 수열을 나타내는 n개의 정수가 입력된다. 
맨 앞 숫자가 0이면 출력하고 종료한다.
output
입력된 각 줄에 대해 "Jolly" 또는 "Not Jolly"를 한 줄씩 출력한다

Sample Input
4 1 4 2 3
5 1 4 2 -1 6
※ 주의: 각 줄의 맨 앞의 숫자는 수열의 갯수이다. 첫번째 입력인 4 1 4 2 3 의
         맨 앞의 4는 뒤에 4개의 숫자가 온다는 것을 의미함
Sample Output
Jolly
Not jolly
*/

public class Ex02 {
	public static void main(String[] args) {
		// int[] data = {4, 1, 4, 2, 3};
		int[] data = {5, 1, 4, 2, -1, 6};
		boolean b[] = new boolean[data[0]-1]; // 사이의 개수
		for(int i=1;i<data.length-1;i++) {
			int idx = Math.abs(data[i+1]-data[i]); // 두수사이의 차의 절대값
			System.out.println(i + " : " + idx);
			if(idx>0 && idx<=b.length) // 차가 배열의 첨자 범위라면 
				b[idx-1] = true; // 있다고 표시
		}
		System.out.println(Arrays.toString(b));
		boolean result = true; // 일단은 유쾌한 점퍼(jolly jumper)라고 가정
		for(int i=0;i<b.length-1;i++) {
			if(!b[i]) result = false; // 배열의 값 중에 거짓이 하나라도 있으면 수열이 완성된것이 아님
		}
		if(result) {
			System.out.println("Jolly");
		}else {
			System.out.println("Not jolly");
		}
	}
}
