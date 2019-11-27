package exam1126;

public class Test {
	// N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
	public static void main(String[] args) {
		int n = 3;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					if(i!=j && i!=k && j!=k)
						System.out.println(i+""+j+""+k);
				}
			}
		}
	}
}
