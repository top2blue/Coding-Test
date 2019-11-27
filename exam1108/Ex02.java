package exam1108;

import java.util.ArrayList;
import java.util.List;

/*
문제 2] 골드바흐의 추측(Goldbach's conjecture)
골드바흐의 추측(Goldbach's conjecture)은 오래전부터 알려진 정수론의 미해결 문제로, 
2보다 큰 모든 짝수는 두 개의 소수(Prime number)의 합으로 표시할 수 있다는 것이다. 
이때 하나의 소수를 두 번 사용하는 것은 허용한다.
2보다 큰 짝수 n을 입력 받으면, n=p1+p2 를 만족하는 소수 p1,p2의 페어를 모두 출력하는 프로그램을 작성하시오.
입력예1: n=26
출력예1: [[3, 23], [7, 19], [13, 13]]
입력예2: n=48
출력예2 [[5, 43], [7, 41], [11, 37], [17, 31], [19, 29]]
 */
public class Ex02 {
	static List<Integer> primeNumberList = new ArrayList<>(); // 소수들
	static {
		for(int i=2;i<1000;i++) {
			int j=1;
			while(i%++j!=0);
			if(i==j) primeNumberList.add(i);
		}
	}
	public static void main(String[] args) {
		getGoldbachsConjecture(26);
		getGoldbachsConjecture(48);
		getGoldbachsConjecture(128);
		getGoldbachsConjecture(1128);
	}
	private static void getGoldbachsConjecture(int n) {
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<primeNumberList.size() && primeNumberList.get(i)<=n/2;i++) {
			for(int j=i;j<primeNumberList.size();j++) {
				if(primeNumberList.get(i) + primeNumberList.get(j) == n) {
					sb.append("[" + primeNumberList.get(i) + ", " + primeNumberList.get(j) + "], ");
					break;
				}
			}
		}
		System.out.println(sb.substring(0, sb.length()-2) + "]");
	}
	
}
