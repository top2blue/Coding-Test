package exam1212;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
문제 1] 가장 큰 정사각형 찾기
문제 설명
1와 0로 채워진 표(board)가 있습니다. 
표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. 
(단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

예를 들어

1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
가 있다면 가장 큰 정사각형은

1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

제한사항
표(board)는 2차원 배열로 주어집니다.
표(board)의 행(row)의 크기 : 1,000 이하의 자연수
표(board)의 열(column)의 크기 : 1,000 이하의 자연수
표(board)의 값은 1또는 0으로만 이루어져 있습니다.

입출력 예
board	answer
[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]	9
[[0,0,1,1],[1,1,1,1]]	4

입출력 예 설명
입출력 예 #1
위의 예시와 같습니다.

입출력 예 #2
| 0 | 0 | 1 | 1 |
| 1 | 1 | 1 | 1 |
로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return합니다.
 */

public class Ex01 {
	public static void main(String[] args) {
		int answer = 0;
		// int[][] board = new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int[][] board = new int[][] {{0,0,1,1},{1,1,1,1}};
	    int lengthY = board.length;
	    int lengthX = board[0].length;
	    int max = 0;

	    if (lengthY < 2 || lengthY < 2) {
	    	// 행이나 열의 길이가 2 미만이라면 직접 돌리면서 1이 하나라도 있는지 체크 합니다.
	    	// 하나라도 있으면 통과.
	        for(int i = 0 ; i < lengthY ; i++){
	            for(int j = 0;  j < lengthX ; j++) {
	                if (board[i][j] == 1) {
	                    max = 1;
	                }
	            }
	        }
	    } else {
	        // 첫 번째 행열을 제외시키기 위해서 i와 j에 1을 할당합니다.
	        for(int i = 1 ; i < lengthY ; i++){
	            for(int j = 1;  j < lengthX ; j++) {
	            	// 1이 아닐 경우 패스! 1인 값만 동적으로 변경해 줍니다.
	                if(board[i][j] == 1 ){
	                	// 현재 값의 좌측값, 상단값, 좌측상단값 중 최소값에 +1을 해줍니다.
	                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
	                    // 다시 배열을 돌리는 수고를 하지않기 위해서 max값을 찾아 저장해 줍니다.
	                    if (board[i][j] > max) max = board[i][j];
	                }
	            }
	        }
	    }
	    answer = max*max;
		System.out.println(answer);
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}), 9);
		assertEquals(solution.solution(new int[][] {{0,0,1,1},{1,1,1,1}}), 4);
	}
	/*
	그럼 정사각형을 어떻게 찾는지 간단하게 설명하자면
	1. 배열의 [1][1]부터 반복문을 돌린다. (첫 번째 행, 첫 번째 열 무시, 이유는 2번 참고)
	2. 현재 값이 1일 경우, 좌측값, 상단값, 좌측상단값 중 가장 작은 값의 +1 한 값을 현재 값으로 할당.
	3. 배열이 끝날 때 까지 반복.
	4. 배열의 가장 큰 값이 현재 배열의 가장 큰 정사각형의 값이 된다.
	5. 그림을 참고하여 어떻게 돌아가는지 봅시다.
	 */
	class Solution {
		public int solution(int[][] board) {
			int answer = 0;
			int lengthY = board.length;
		    int lengthX = board[0].length;
		    int max = 0;

		    if (lengthY < 2 || lengthY < 2) {
		    	// 행이나 열의 길이가 2 미만이라면 직접 돌리면서 1이 하나라도 있는지 체크 합니다.
		    	// 하나라도 있으면 통과.
		        for(int i = 0 ; i < lengthY ; i++){
		            for(int j = 0;  j < lengthX ; j++) {
		                if (board[i][j] == 1) {
		                    max = 1;
		                }
		            }
		        }
		    } else {
		        // 첫 번째 행열을 제외시키기 위해서 i와 j에 1을 할당합니다.
		        for(int i = 1 ; i < lengthY ; i++){
		            for(int j = 1;  j < lengthX ; j++) {
		            	// 1이 아닐 경우 패스! 1인 값만 동적으로 변경해 줍니다.
		                if(board[i][j] == 1 ){
		                	// 현재 값의 좌측값, 상단값, 좌측상단값 중 최소값에 +1을 해줍니다.
		                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
		                    // 다시 배열을 돌리는 수고를 하지않기 위해서 max값을 찾아 저장해 줍니다.
		                    if (board[i][j] > max) max = board[i][j];
		                }
		            }
		        }
		    }
		    answer = max*max;
			return answer;
		}
	}
}
