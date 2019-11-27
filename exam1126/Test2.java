package exam1126;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static boolean nextPermutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
 
        // 마지막 순열
        if (i <= 0) {
            return false;
        }
 
        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 입력
        int[] ar = new int[n]; // 배열
        for (int i=0; i<n; i++)ar[i] = i+1; // 배열 채우기
        int count = 0;
        do {
           System.out.println(++count + " : " + Arrays.toString(ar));
        } while (nextPermutation(ar));
        sc.close();
    }
}
