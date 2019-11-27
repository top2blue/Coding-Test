package exam1126;

import java.util.ArrayList;
import java.util.List;

/*
부분 집합이란 전체의 집합에서 하나의 원소를 '고른다 / 안 고른다' 
두 가지의 경우에 대해 살펴보는 것이므로 2^n 가지의 경우가 나옵니다.
이는 비트를 이용하면 굉장히 쉽게 구할 수 있습니다! 
왜냐하면 비트는 이진수이기 때문에, 하나의 자리수마다 고른다 (1) / 안 고른다(0)을 설정할 수 있기 때문입니다!
 */
public class Test3 {
	public static void main(String[] args) {
		System.out.println(makeSet("17")+ "\n");
		System.out.println(makeSet("011")+ "\n");
		System.out.println(makeSet("122")+ "\n");
	}
	// 부분 집합을 구하는 방법
	private static List<Integer> makeSet(String str) {
		List<Integer> list = new ArrayList<Integer>();
		
		char[] cs = str.toCharArray(); // 배열로 변경
		int length = str.length(); // 길이

		int num = 1;
		for(int i=0;i<length;i++) num *= 2; // 개수 : 000 - 111 = 8 --> 2의 원소의개수 승
		num--; // 0 제외
		
		// 비트 마스크 만들기
		String bin="1";
		for(int i=1;i<length;i++) bin += "0";
		
		while(num>0) {
			int mask = Integer.parseInt(bin, 2); 
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<length;i++) {
				if((mask&num)==mask) {
					sb.append(cs[i]+"");
				}
				mask = mask >> 1; // 우측으로 1칸씩 이동하면서 1이있는 위치의 숫자만 뽑았다.
			}
			list.add(Integer.parseInt(sb.toString()));
			num--;		
		}
		return list;
	}
}
