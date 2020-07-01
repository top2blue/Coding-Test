package kr.green.Example.ex0615;
/*
Reverse And Add
출처: programming-challenges

일단 어떤 수를 받아서 그 수를 뒤집은 다음 뒤집어진 수를 원래의 수에 더하는 과정을 뒤집어서 \\
더하기라고 부르자. 그 합이 회문(palindrome, 앞뒤 어느 쪽에서 읽어도 같은 말이 되는 어구. 
예:eye, madam, 소주만병만주소)이 아니면 회문이 될 때까지 이 과정을 반복한다.
예를 들어 처음에 195에서 시작해서 다음과 같이 네 번 뒤집어서 더하기를 반복하면 9339라는 
회문이 만들어진다.
 195      786       1473      5214
+591     +687      +3741     +4125
----     -----     -----     -----
 786     1473       5214      9339
대부분의 정수는 이 방법을 몇 단계만 반복하면 회문이 된다. 하지만 예외도 있다. 
회문을 찾을 수 없는 것으로 밝혀진 첫번째 수는 196이다. 
하지만 회문이 없다는 것이 증명된 적은 없다.
어떤 수가 주어졌을 때 회문이 있으면 출력하고, 그 회문을 찾기까지 뒤집어서 더하기를 반복한 
횟수를 출력하는 프로그램을 만들어야 한다.
테스트 데이터로 사용되는 수는 모두 뒤집어서 더하기를 1,000번 미만 반복해서 회문을 
찾을 수 있는 수고, 그렇게 만들어진 회문을 4,294,967,295보다 크지 않다고 가정해도 된다.
Input
첫번째 줄에는 테스트 케이스를 나타내는 정수 N(0<N<=100)이 들어있고,
그 아래로 N개의 줄에 걸쳐서 회문을 구해야 하는 정수가 한 줄에 하나씩 들어있다.
output
N개의 각 정수에 대해 회문을 발견하는 데 필요한 최소한의 반복 횟수를 출력하고, 
스페이스를 한 칸 출력한 다음, 그 회문을 출력한다.
Sample Input
3
195
265
750
Sample Output
4 9339
5 45254
3 6666
*/
public class Ex01 {
	public static void main(String[] args) {
		System.out.println(palindrome(195));
		System.out.println(palindrome(265));
		System.out.println(palindrome(750));
	}
	public static String palindrome(long n) {
		int count =0;
		while(true) {
			StringBuffer sb =new StringBuffer(n+""); // StringBuffer로 만들기
			if(sb.toString().equals(sb.reverse().toString())) { // 뒤집어서 같으면 종료 
				return String.format("%d %d", count, n);
			}
			long m = Long.parseLong(sb.toString()); // 숫자로 만들기
			// System.out.println( n + " : " + m);
			n = n + m; // 더하기
			count++; // 횟수 증가
		}
	}
}
