package kr.green.Example.ex0610;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
/*
문제 1] 다음 입사문제 중에서
1차원의 점들이 주어졌을 때, 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오. 
(단 점들의 배열은 모두 정렬되어있다고 가정한다.)
예를들어 S={1, 3, 4, 8, 13, 17, 20} 이 주어졌다면, 결과값은 (3, 4)가 될 것이다. 
*/
public class Ex01 {
	@Test
	public void minTest() {
		assertArrayEquals(Ex01.lengthMin(new int[]{1, 3, 4, 8, 13, 17, 20}), new int[] {3,4});
		assertArrayEquals(Ex01.lengthMin(new int[]{1, 2, 4, 8, 13, 17, 20}), new int[] {1,2});
		assertArrayEquals(Ex01.lengthMin(new int[]{1, 2, 4, 8, 13, 19, 20}), new int[] {19,20});
	}
	public static int[] lengthMin(int[] ar) {
		int[] result = new int[2]; // 결과는 2개
		int min = 999, index=0; // 차이의 최소값 변수, 위치변수
		for(int i=1;i<ar.length;i++) { // 두번째 부터 반복
			// 최소값이 적으면 이면 최소값 처음위치의 값, 적거나 같으면 최소값 마지막 위치가 나온다.
			if(ar[i]-ar[i-1]<=min) { 
				min = ar[i]-ar[i-1]; // 최소값 변경
				index = i; // 위치 저장
			}
		}
		System.out.println(min + ":" + index); // 최소값과 위치
		result[0] = ar[index-1];  // 위치의 왼쪽값을 첫번째에 
		result[1] = ar[index];    // 위치 값을 두번째에 넣기
		return result; // 리턴
	}
}
