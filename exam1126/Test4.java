package exam1126;

import java.util.Set;
import java.util.TreeSet;

public class Test4 {
	static Set<Integer> set = new TreeSet<>();
	public static void main(String[] args) {
		// String str = "17";
		// String str = "011";
		String str = "1234";
		char[] arr = str.toCharArray();
		for(int i=1;i<arr.length+1;i++) {
			permutation(arr, 0, arr.length, i);
			System.out.println();
		}
		System.out.println(set); // 모든 조합
		
		int count = 0;
		for(int i : set) {
			if(i>1 && isPrimeNumber(i)) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("소수 개수 : " + count);
	}
	
	static boolean isPrimeNumber(int n) {
    	boolean primeNumber = false;
   		int j=1;
   		while(n%++j!=0);
   		if(n==j) {
   			primeNumber = true;
   		}
    	return primeNumber;
    }
	
	// 순서 없이 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: permutation(arr, 0, n, 4);
    static void permutation(char[] arr, int depth, int n, int r) {
        if(depth == r) {
        	StringBuilder sb = new StringBuilder();
        	for(int i=0;i<depth;i++) {
        		System.out.print(arr[i] + "");
        		sb.append(arr[i]);
        	}
        	System.out.println();
        	set.add(Integer.parseInt(new String(sb.toString()))); // 숫자로 바꿔서 셑에 넣기
            return;
        }
 
        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
 
    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
