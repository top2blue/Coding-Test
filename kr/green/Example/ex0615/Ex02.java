package kr.green.Example.ex0615;
/*
다음 디브온 코드골프 문제
출처: http://agile.egloos.com/5774107
디브온에서 미니대안언어축제가 진행되던 M2 밖에 텍스트큐브 부스에서 재미있는 
코드골프 문제 풀기가 있었습니다. 
150자 이하로 푸신 분들에게는 즉석에서 제공되는 원두커피와 텀블러가 상으로 주어졌다고 합니다.
문제는 아래와 같습니다. 이 결과가 나와야 하는데 언어 제약은 없답니다.
     *
     *
    * *
   *   *
  *     *
**       **
  *     *
   *   *
    * *
     *
     *
 */
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("     *\n     *"); // 맨 위 2줄
		for(int i=1;i<4;i++) {// 3줄
			for(int j=5;j>i;j--) System.out.print(" "); // 앞의 공백 : 5 4 3 으로 감소
			System.out.print("*"); // 별
			for(int j=0;j<i*2-1;j++) System.out.print(" "); // 중간의 공백 :  1 3 5로 증가
			System.out.println("*"); // 별
		}
		System.out.println("**       **"); // 중간에 1줄
		for(int i=0;i<3;i++) { // 3줄
			for(int j=1;j<3+i;j++) System.out.print(" "); // 앞의 공백 : 3 4 5로 증가
			System.out.print("*"); // 별
			for(int j=0;j<(3-i)*2-1;j++) System.out.print(" "); // 중간의 공백 : 5 3 1로 감소
			System.out.println("*"); // 별
		}
		System.out.println("     *\n     *"); // 맨 아래 2줄
	}
}
