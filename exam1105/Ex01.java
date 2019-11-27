package exam1105;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
문제 1] 약수를 찾아라
약수를 모두 찾는 수학 문제를 풀다가 지친 X는 컴퓨터의 도움을 받아 문제를 풀어 보기로 하였다. 
하지만 계산기를 이용하자니 계산기로 하고 싶지만 찾기도 어려우며, 쉽게 찾아낼 수도 없었다.
풀이에 지친 그는 결국 약수들이 가지고 있는 특징을 찾아 결국 몇시간에 걸쳐 복잡한 수라도 약수를 찾아줄 수 있고 
개수도 알려주는 프로그램을 짜게 된다.
다음은 약수를 얻기 위한 입력과 출력 예제들이다.
입력 1
24
출력 1
{ 1, 2, 3, 4, 6, 8, 12, 24}
약수의 개수는 8개 입니다.
소스코드를 디버깅하여 123456789를 입력해 출력된 결과를 '{ a, b, ... } / 약수의 개수는 ~개 입니다' 형식으로 하시오.
 */
public class Ex01 {
	public static void main(String[] args) {
		List<Integer> divisor_list = divisor1(24);
		System.out.println(divisor_list);
		System.out.println("약수의 개수는 " + divisor_list.size() + "개 입니다.");
		divisor_list = divisor1(123456789);
		System.out.println(divisor_list);
		System.out.println("약수의 개수는 " + divisor_list.size() + "개 입니다.");
		System.out.println();

		List<Integer> divisor_list2 = divisor2(24);
		System.out.println(divisor_list2);
		System.out.println("약수의 개수는 " + divisor_list2.size() + "개 입니다.");
		divisor_list2 = divisor2(123456789);
		System.out.println(divisor_list2);
		System.out.println("약수의 개수는 " + divisor_list2.size() + "개 입니다.");

		System.out.println(divisor3(24));
		System.out.println(divisor4(24));
	}

	private static List<Integer> divisor1(int n) {
		List<Integer> divisor_list = new ArrayList<>();
		// 자신까지 나눠본다
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				divisor_list.add(i);
		}
		return divisor_list;
	}

	private static List<Integer> divisor2(int n) {
		List<Integer> divisor_list = new ArrayList<>();
		divisor_list.add(n); // 자신을 먼저 추가
		// 절반까지만 나눠본다.
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0)
				divisor_list.add(i);
		}
		Collections.sort(divisor_list); // 정렬
		return divisor_list;
	}
	// JDK7의 스트림
	private static List<Integer> divisor3(int n) {
		List<Integer> divisor_list = new ArrayList<>();
		IntStream.rangeClosed(1, n).filter(i -> (n % i) == 0).forEach(i -> {
			divisor_list.add(i);
		});
		return divisor_list;
	}
	
	private static List<Integer> divisor4(int n) {
		List<Integer> divisor_list = new ArrayList<>();
		divisor_list.add(n);
		IntStream.rangeClosed(1, n/2).filter(i -> (n % i) == 0).forEach(i -> {
			divisor_list.add(i);
		});
		Collections.sort(divisor_list);
		return divisor_list;
	}

}
