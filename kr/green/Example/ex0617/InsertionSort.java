package kr.green.Example.ex0617;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
	public static void main(String[] args) {
		int ar[] = new int[10];
		Random rnd = new Random();
		for(int i=0;i<ar.length;i++) {
			ar[i] = rnd.nextInt(101); // 난수로 초기화
		}
		System.out.println("정렬전 : " + Arrays.toString(ar));
		insertionSort(ar);
		System.out.println("정렬후 : " + Arrays.toString(ar));
	}
	public static void insertionSort(int ar[]) {
		// 0번은 정렬되었다고 가정하고 1번부터 시작
		for (int j = 1; j < ar.length; j++) {
			int key = ar[j]; // 현재값 저장
			int i = j - 1; // 현재부터 왼쪽으로 이동 
			while ((i > -1) && (ar[i] > key)) { // 처음까지 가면서 나보다 값이 크다면
				ar[i + 1] = ar[i]; // 뒤로 이동
				i--; // 다시 앞으로
			}
			ar[i + 1] = key; // 찾은 위치에 자신이 들어감
		}
	}
}
