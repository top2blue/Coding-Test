package kr.green.Example.ex0616;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort02 {
	public static void main(String[] args) {
		int ar[] = new int[10];
		Random rnd = new Random();
		for(int i=0;i<ar.length;i++) {
			ar[i] = rnd.nextInt(101); // 난수로 초기화
		}
		System.out.println("정렬전 : " + Arrays.toString(ar));
		
		for(int i=ar.length-1;i>0;i--) { // n-1회전
			for(int j=i-1;j>=0;j--) { // i+1 ~ 끝까지
				if(ar[i]<ar[j]) {
					ar[i] = ar[i] ^ ar[j];
					ar[j] = ar[i] ^ ar[j];
					ar[i] = ar[i] ^ ar[j];
				}
			}
			System.out.println((10-i) + "회 : " + Arrays.toString(ar));
		}
		System.out.println("정렬후 : " + Arrays.toString(ar));
	}
}
