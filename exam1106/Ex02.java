package exam1106;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
문제 2] 여러 가지 수의 최대공약수, 최소공배수 찾기
3개 이상의 여러 가지의 수가 주어졌을 때, 공약수, 최대공약수, 최소공배수를 찾는 알고리즘을 구하시오.
6015240, 1507968, 4530816
의 공약수, 최대공약수, 최소공배수를 구하시오.
 */
public class Ex02 {
	public static void main(String[] args) {
		int[] ar = {6015240, 1507968, 4530816};
		//int[] ar = {12, 6, 9};
		List<Integer> list = intersection(divisor(ar[0]),intersection(divisor(ar[1]),divisor(ar[2])));
		System.out.println("공약수 : " + list);
		int gcd = list.get(list.size()-1);
		System.out.println("최대공약수 : " + gcd);
		gcd = recursiveGCD(recursiveGCD(ar[0],ar[1]),ar[2]);
		System.out.println("최대공약수 : " + gcd);
		int lcm = LCM(LCM(ar[0], ar[1]),ar[2]);
		System.out.println("최소공배수 : " + lcm);
		
	}
	// List 교집합(intersection)
	private static List<Integer> intersection(List<Integer> list1, List<Integer> list2){
		List<Integer> list = new ArrayList<Integer>();
		for(Integer t : list1) {
			if(list2.contains(t)) list.add(t);
		}
		return list;
	}
	// 약수구하는 메서드
	private static List<Integer> divisor(int n) {
		List<Integer> divisor_list = new ArrayList<>();
		divisor_list.add(n);
		IntStream.rangeClosed(1, n/2).filter(i -> (n % i) == 0).forEach(i -> {
			divisor_list.add(i);
		});
		Collections.sort(divisor_list);
		return divisor_list;
	}
	
	// 반복문을 이용해서 최대공약수(GCD)를 구하는 메서드
	public static int loopGCD(int a, int b){
	    int tmp, n;
	    if(a<b){
	        tmp = a;
	        a = b;
	        b = tmp;
	    }
	    // 유클리드 알고리즘 부분입니다.
	    // b가 0이 될때까지(a%b), 반복문을 돌게되고, b가 0인 순간의 a를 GCD로 판단하고 리턴합니다.
	    while(b!=0){
	        n = a%b;
	        a = b;
	        b = n;
	    }
	    return a;
	}
	
	// 재귀함수(recursive)를 이용해서 최대공약수(GCD)를 구하는 메서드
	public static int recursiveGCD(int a, int b){
        return (b==0) ?  a : recursiveGCD(b, a%b);
	}
	
	// 최소공배수 공식(최대공약수를 이용) : (최소공배수 * 최대공약수 = a * b)를 이용 식) a * b / gcd(a,b)
	public static int LCM(int a, int b){
	    return a * b / recursiveGCD(a,b);
	}
}
