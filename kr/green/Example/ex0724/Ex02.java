package kr.green.Example.ex0724;

import static org.junit.Assert.assertArrayEquals;

import java.util.Stack;

import org.junit.Test;
public class Ex02 {
	@Test
	public void test() {
		Solution solution = new Solution();
		// [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	
		assertArrayEquals(solution.solution(6,4,new int[][]{{1, 1, 1, 0},
															{1, 2, 2, 0},
															{1, 0, 0, 1},
															{0, 0, 0, 1},
															{0, 0, 0, 3},
															{0, 0, 0, 3}}), new int[] {4,5});
	}
	
	
	class Solution {
		
			public int[] solution(int m, int n, int[][] picture) {
				int[] answer = new int[2];
				boolean[][] visited = new boolean[m][n]; // 이미 카운트 했는지를 표시
				Stack<Integer> stackX = new Stack<>(); // 같은 값이 있는 x좌표를 저장할 스택
				Stack<Integer> stackY = new Stack<>(); // 같은 값이 있는 y좌표를 저장할 스택
				// 전체를 반복한다.
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						int count = 0;
						// 색상이 있으면서 방문한적이 없다면
						if (picture[i][j] > 0 && visited[i][j] == false) {
							plus(stackX, stackY, visited, j, i); // 현재위치를 스텍에 저장하고 방문 표시해주는 함수
							count++; // 새로운 영역의 크기
							answer[0]++; // 영역의 개수
						}
						// 상하좌우에 같은 색상이 있는 동안 반복
						while (!stackX.isEmpty()) {
							// 스택에서 좌표 꺼내기
							int x = stackX.pop();
							int y = stackY.pop();
							// 위 이동 : y>0(위쪽 검사 가능), 같은 색상, 방문한적이 없다면
							if (y > 0 && picture[y - 1][x] == picture[i][j] && visited[y - 1][x] == false) {
								plus(stackX, stackY, visited, x, y - 1);// 현재위치를 스텍에 저장하고 방문 표시해주는 함수
								count++; // 개수 증가
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
						answer[1] = Math.max(answer[1], count); // 영역 개수의 최대값
					}
				}
				return answer;
			}

			public void plus(Stack<Integer> stackX, Stack<Integer> stackY, boolean[][] visited, int j, int i) {
				stackX.add(j); // x좌표 저장
				stackY.add(i); // y좌표 저장
				visited[i][j] = true; // 방문표시
			}
		}
}
