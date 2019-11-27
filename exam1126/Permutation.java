package exam1126;

import java.util.*;

/**
 * 순열 : n 개 중에서 r 개 선택
 * 시간복잡도는 O(n!)
 * 연습문제 : https://www.acmicpc.net/problem/10974
 */
 
public class Permutation {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};        
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
 
        perm(arr, output, visited, 0, n, 2);
        System.out.println();
        permutation(arr, 0, n, 2);
    }
 
    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }
 
        for(int i=0; i<n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);       
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }
 
    // 순서 없이 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: permutation(arr, 0, n, 4);
    static void permutation(int[] arr, int depth, int n, int r) {
        if(depth == r) { // 깊이가 조합할 개수가되는 순간
        	System.out.println(Arrays.toString(arr));
            return;
        }
 
        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r); // 깊이 증가 되면서 재귀호출
            swap(arr, depth, i);
        }
    }
 
    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
 
}

