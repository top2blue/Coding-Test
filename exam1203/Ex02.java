package exam1203;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/*
문제 2] 카카오프렌즈 컬러링북
출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 
여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 
사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

alt text
위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

입력 형식
입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 

제한조건은 아래와 같다.
1 <= m, n <= 100
picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.

출력 형식
리턴 타입은 원소가 두 개인 정수 배열이다. 
그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

예제 입출력
m	n	picture																					answer
6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]

예제에 대한 설명
예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 
왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 
가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.
 */

public class Ex02 {
	public static void main(String[] args) {

	}

	@Test
	public void test() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(6,4,
				new int[][] {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}}),new int[]{4,5});
	}

	class Solution {
		public int[] solution(int m, int n, int[][] picture) {
			int[] answer = new int[2];
			boolean[][] visited = new boolean[m][n];
			Stack<Integer> stackX = new Stack<>();
			Stack<Integer> stackY = new Stack<>();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int count = 0;
					if (picture[i][j] > 0 && visited[i][j] == false) {
						plus(stackX, stackY, visited, j, i);
						count++;
						answer[0]++;
					}
					while (!stackX.isEmpty()) {
						int x = stackX.pop();
						int y = stackY.pop();
						// 위 이동
						if (y > 0 && picture[y - 1][x] == picture[i][j] && visited[y - 1][x] == false) {
							plus(stackX, stackY, visited, x, y - 1);
							count++;
						}
						// 좌측 이동
						if (x > 0 && picture[y][x - 1] == picture[i][j] && visited[y][x - 1] == false) {
							plus(stackX, stackY, visited, x - 1, y);
							count++;
						}
						// 아래 이동
						if (y < m - 1 && picture[y + 1][x] == picture[i][j] && visited[y + 1][x] == false) {
							plus(stackX, stackY, visited, x, y + 1);
							count++;
						}
						// 우측 이동
						if (x < n - 1 && picture[y][x + 1] == picture[i][j] && visited[y][x + 1] == false) {
							plus(stackX, stackY, visited, x + 1, y);
							count++;
						}
					}
					answer[1] = Math.max(answer[1], count);
				}
			}
			return answer;
		}

		public void plus(Stack<Integer> stackX, Stack<Integer> stackY, boolean[][] visited, int j, int i) {
			stackX.add(j);
			stackY.add(i);
			visited[i][j] = true;
		}
	}
}
