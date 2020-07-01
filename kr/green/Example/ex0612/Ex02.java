package kr.green.Example.ex0612;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
문제 2] Light More Light
출처: programming challenges
우리 학교에는 복도 불을 켜고 끄는 마부(Mabu)라는 사람이 있다. 
전구마다 불을 켜고 끄는 스위치가 있다. 
불이 꺼져 있을 때 스위치를 누르면 불이 켜지고 다시 스위치를 누르면 불이 꺼진다. 
처음에는 모든 전구가 꺼져 있다. 마부라는 사람은 특이한 행동을 한다. 
복도에 n개의 전구가 있으면, 복도를 n번 왕복한다. 
i번째 갈 때 그는 i로 나누어 떨어지는 위치에 있는 스위치만 누른다. 
처음 위치로 돌아올 때는 아무 스위치도 건드리지 않는다. 
i번째 왕복은 (이런 이상한 행동을 하면서) 복도를 한 번 갔다가 오는 것으로 정의된다. 
마지막 전구의 최종 상태를 알아내자. 과연 그 전구는 켜져 있을까 아니면 꺼져 있을까?

Input
복도에 있는 n번째 전구를 나타내는 숫자가 입력된다. 
(2^32-1 이하의 정수가 입력된다.) 
0은 입력의 끝을 의미하며 그 값은 처리하지 않는다.

Output
그 전구가 켜져 있으면 "yes"를, 꺼져 있으면 "no"를 출력한다. 
테스트 케이스마다 한 줄에 하나씩 출력한다.

Sample Input
3
6241
8191
0

Sample Output
no
yes
no
*/

public class Ex02 {
	@Test
	public void testOnOff() {
		assertEquals(Ex02.isOnOff(3), "no");
		assertEquals(Ex02.isOnOff(6241), "yes");
		assertEquals(Ex02.isOnOff(8191), "no");
	}

	public static String isOnOff(int n) {
		boolean[] ar = new boolean[n]; // n개의 전구가 모두 off
		for(int i=1;i<=n;i++) { // n번 반복
			for(int j=1;j<=n;j++) { // i의 배수마다 전구를 onoff
				if(j%i==0) ar[j-1] = !ar[j-1]; // onoff
			}
			// System.out.println(Arrays.toString(ar));
		}
		return ar[n-1] ? "yes":"no";
	}
	
}
