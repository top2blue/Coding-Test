package exam1108;

/*
문제 1] 낱말퍼즐 만들기
어떤 두 단어를 비교하여 낱말퍼즐이 형성될 수 있는지 확인하는 프로그램을 만들고자 한다. 
두 단어가 A와 B의 순서로 공백문자를 포함하여 있다. 이 둘 중에서 겹치는 문자를 찾아서 서로 겹치게 하여 낱말 퍼즐이 형성되는지 확인한다.
만약 겹치게 할 수 있는 문자가 두 개 이상이라면 A 문자에서 가장 먼저 오는 위치를 선정하여 서로 겹치게 한다.
예를들어 lazy crossword 두단어를 넣으면 >> None
crossword boolean 두단어를 넣으면
..b......
crossword
..o......
..l......
..e......
..a......
..n......
*/
public class Ex01 {
	public static void main(String[] args) {
		makeCrossword("lazy", "crossword");
		makeCrossword("crossword", "boolean");
		makeCrossword("cross", "system");
		makeCrossword("system", "make");
	}
	private static int checkCol(String str1, String str2) { // 열
		int position = -1;
		for(int i=str2.length()-1;i>=0;i--) {
			if(str1.contains(str2.charAt(i)+"")) {
				position = str1.indexOf(str2.charAt(i));
				break;
			}
		}
		return position;
	}
	private static int checkRow(String str1, String str2) { // 행
		int position = -1;
		for(int i=str1.length()-1;i>=0;i--) {
			if(str2.contains(str1.charAt(i)+"")) {
				position = str2.indexOf(str1.charAt(i));
				//break;
			}
		}
		return position;
	}
	private static void makeCrossword(String str1, String str2) {
		int col = checkCol(str1, str2);
		int row = checkRow(str1, str2);
		if(col<0) {
			System.out.println("None");
			return;
		}
		char[][] word = new char[str2.length()][str1.length()]; // 배열
		for(int i=0;i<word.length;i++) { // 배열 초기화
			for(int j=0;j<word[i].length;j++) {
				word[i][j] = '.';
			}
		}
		for(int i=0;i<str1.length();i++) word[row][i] = str1.charAt(i); // 가로
		for(int i=0;i<str2.length();i++) word[i][col] = str2.charAt(i); // 세로
		
		for(int i=0;i<word.length;i++) { // 출력
			for(int j=0;j<word[i].length;j++) {
				System.out.print(word[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
