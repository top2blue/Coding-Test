package kr.green.Example.ex0616;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort02 {
	public static void main(String[] args) {
		int ar[] = new int[10];
		Random rnd = new Random();
		for(int i=0;i<ar.length;i++) {
			ar[i] = rnd.nextInt(101); // 난수로 초기화
		}
		System.out.println("정렬전 : " + Arrays.toString(ar));
		for(int i=0;i<ar.length-1;i++) { // n-1회전
			boolean flag = true; // 이미 정렬이 되었다고 가정 
			for(int j=0;j<ar.length-i-1;j++) { // i+1 ~ 끝까지
				if(ar[j]>ar[j+1]) {
					ar[j] = ar[j] ^ ar[j+1];
					ar[j+1] = ar[j] ^ ar[j+1];
					ar[j] = ar[j] ^ ar[j+1];
					flag  =false; // 교환이 이루어지면 아직 정렬 중이다.
				}
			}
			if(flag) break; // flag가 참이라는것은 교환이 한번이 없었다. 즉 정렬 완료!!!
			System.out.println((i+1) + "회 : " + Arrays.toString(ar));
		}
		System.out.println("정렬후 : " + Arrays.toString(ar));
	}
}
