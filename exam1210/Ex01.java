package exam1210;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

/*
문제 1]문제 1] 위장
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
예를 들어 스파이가 가진 옷이 아래와 같고 
오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류	이름
얼굴	동그란 안경, 검정 선글라스
상의	파란색 티셔츠
하의	청바지
겉옷	긴 코트

스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
스파이는 하루에 최소 한 개의 의상은 입습니다.

입출력 예
clothes																			return
[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]				3

입출력 예 설명
예제 #1
headgear에 해당하는 의상이 yellowhat, greenturban이고
eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.

1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses

예제 #2
face에 해당하는 의상이 crowmask, bluesunglasses, smoky_makeup이므로 
아래와 같이 3개의 조합이 가능합니다.

1. crow_mask
2. blue_sunglasses
3. smoky_makeup
 */

public class Ex01 {
	public static void main(String[] args) {
		// String[][] clothes = new String[][] {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
		String[][] clothes = new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"},{"smoky_makeup", "face"}};
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		 
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1]))
            	map.replace(clothes[i][1], map.get(clothes[i][1])+1);
            else
            	map.put(clothes[i][1], 1);
        }
        answer=1;
        for (int value : map.values()) {
            answer *= (value+1);
        }
        --answer;
 		System.out.println(answer);
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new String[][] {{"yellow_hat", "headgear"},
													   {"blue_sunglasses", "eyewear"},
													   {"green_turban", "headgear"}}), 5);
		
		assertEquals(solution.solution(new String[][] {{"crow_mask", "face"},
													   {"blue_sunglasses", "face"},
													   {"smoky_makeup", "face"}}), 3);
	}
	/*
	종류별로 같은 이름의 옷은 없으므로 HashMap<종류(String),등장횟수(Integer)>을 이용
	처음 등장하는 Key는 등장 횟수를 1로 설정하고, 그 이후 등장 부터는 기존 값에 1을 더하는 방식으로 구현
	
	입을 수 있는 옷 종류의 수는 각 종류별로 선택할지 안 할지 여부(+1)를 포함하여 아래와 같은 방식으로 구함
	(A종류 옷 가지수 + 1)*(B종류 옷 가지수 + 1)*(C종류 옷 가지수 + 1) - 1
	마지막의 -1은 아무것도 선택하지 않은 경우는 없어야하므로 제외 
	 */
	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 0;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			 
	        for (int i = 0; i < clothes.length; i++) {
	            if (map.containsKey(clothes[i][1]))
	            	map.replace(clothes[i][1], map.get(clothes[i][1])+1);
	            else
	            	map.put(clothes[i][1], 1);
	        }
	        System.out.println(map);
	        answer=1;
	        for (int value : map.values()) {
	            answer *= (value+1);
	        }
	        --answer;	        
	        System.out.println(answer);
	        return answer;
	    }
	}
}
