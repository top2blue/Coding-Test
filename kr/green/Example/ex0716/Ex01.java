package kr.green.Example.ex0716;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
숫자 야구
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 
각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 
3자리의 숫자를 불러서 결과를 확인합니다. 
그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃

예를 들어, 아래의 경우가 있으면
A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 
가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항
질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

입출력 예
baseball												return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2

완전탐색(exhaustive search)
'무식하게 푼다(brute-force)'는 컴퓨터의 빠른 계산 능력을 이용해 가능한 경우의 수를 일일이 
나열하면서 답을 찾는 방법을 의미. 이렇게 가능한 방법을 전부 만들어 보는 알고리즘을 뜻한다.

 */
public class Ex01 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[][] {{123, 1, 1},{356, 1, 0},{327, 2, 0},{489, 0, 1}}), 2);
	}
	class Solution {
	    public int solution(int[][] baseball) {
	        int answer = 0;
	        // 가장 작은 숫자 : 123 // 가장 큰 숫자 : 987 까지 비교하면서 스트라이크 볼이 맞는 수를 찾아간다. 
	        //수 비교는 string으로 바꿔서 해도 될듯 (안 그러면 10 나누고 mod 연산 해야하니까 )
	        for (int i = 123; i <= 987; i++){
	            String tmp = i+""; // 문자로 변경
	            // 숫자 중복 비허용 
	            if (tmp.charAt(0)==tmp.charAt(1)||tmp.charAt(1)==tmp.charAt(2)||tmp.charAt(0)==tmp.charAt(2)) continue;
	            if (tmp.contains("0")) continue;  //숫자 0 비허용 
	            boolean flag = true;
	            for (int j = 0; j < baseball.length; j++) {
	                int strike = 0, ball = 0; // 스트라이크 볼 확인
	                for (int k = 0; k < 3; k++) {
	                    for (int l = 0; l < 3; l++) {
	                        String num = baseball[j][0]+"";  
	                        if (k == l && tmp.charAt(k) == num.charAt(l) ){
	                            strike++; continue;
	                        } else if (tmp.charAt(k) == num.charAt(l)) {
	                            ball++; continue;
	                        }
	                    }
	                }
	                // 스트라이크 볼이 다르면 아님
	                if (strike != baseball[j][1] || ball != baseball[j][2]) {
	                    flag = false;
	                    break;
	                }
	            }
	            if (flag) answer++;
	        }
	        return answer;
	    }
	}
}
