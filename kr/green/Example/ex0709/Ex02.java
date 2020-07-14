package kr.green.Example.ex0709;

import java.util.Arrays;
import java.util.Collections;

public class Ex02 {
	public static void main(String[] args) {
		// int[] ar = { 6, 10, 2 }; // 6210
		int[] ar = {3, 30, 34, 5, 9}; // 9534330
		String[] t = new String[ar.length];
		for(int i=0;i<ar.length;i++) {
			t[i] = ar[i]+"";
		}
		Arrays.sort(t, Collections.reverseOrder());
		System.out.println(Arrays.toString(t));
	}
}
