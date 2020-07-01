package kr.green.Example.ex0611;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*
문제 1] 그 시간 사무실에 몇 명이 있었나?
아마존 면접문제
A사무실에는 특정일자의 출퇴근 시간이 기록된 거대한 로그파일이 있다고 한다.
파일의 형식은 다음과 같다. (한 라인에서 앞부분은 출근시간(HH:MM:SS), 뒷부분은 퇴근시간이다)
09:12:23 11:14:35
10:34:01 13:23:40
10:34:31 11:20:10
특정시간을 입력(예:11:05:20)으로 주었을 때 그 시간에 총 몇 명이 사무실에 있었는지 알려주는 함수를 작성하시오.
*/
public class Ex01 {
	@Test
	public void minTest() {
		String data[][] = {
				{"09:12:23", "11:04:35"},
				{"11:04:01", "13:23:40"},
				{"10:34:31", "11:20:10"}	
		};
		assertEquals(Ex01.getCount(data, "11:05:20"), 2);
	}
	
	public static int getCount(String data[][], String time) {
		int count = 0;
		for(int i=0;i<data.length;i++) {
			if(hasTime(data[i], time)) count++;
		}
		return count;
	}
	
	public static boolean hasTime(String[] data, String time) {
		String s[] = data[0].split(":"); // String을 배열로
		String e[] = data[1].split(":");
		String t[] = time.split(":");
		int[] tt = new int[3];
		int[] ss = new int[3];
		int[] ee = new int[3];
		// String값을 int로 변경
		tt[0] = Integer.parseInt(t[0]); // 시
		tt[1] = Integer.parseInt(t[1]); // 분
		tt[2] = Integer.parseInt(t[2]); // 초
		ss[0] = Integer.parseInt(s[0]); // 시
		ss[1] = Integer.parseInt(s[1]); // 분
		ss[2] = Integer.parseInt(s[2]); // 초
		ee[0] = Integer.parseInt(e[0]); // 시
		ee[1] = Integer.parseInt(e[1]); // 분
		ee[2] = Integer.parseInt(e[2]); // 초
		boolean result=false;
		if(tt[0]>=ss[0] && tt[0]<=ee[0]) { // 시간이 사이에 있으면
			if(tt[0]==ss[0]) { // 시작 시간과 같다면
				if(tt[1]>ss[1]) { // 분
					result = true;
				}else if(tt[1]==ss[1]) { // 분도 같다면
					if(tt[2]>=ss[2]) { // 초
						result=true;
					}
				}
			}else if(tt[0]==ee[0]) { // 종료시간과 같다면
				if(tt[1]<ee[1]) {
					result = true;
				}else if(tt[1]==ee[1]) {
					if(tt[2]<=ee[2]) {
						result=true;
					}
				}
			}else {
				result = true; // 시간이 사이에 있으면 
			}
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		String[] data = {"09:12:23", "11:04:35"};
		String   time = "11:05:20";
		String s[] = data[0].split(":"); // String을 배열로
		String e[] = data[1].split(":");
		String t[] = time.split(":");
		int[] tt = new int[3];
		int[] ss = new int[3];
		int[] ee = new int[3];
		// String값을 int로 변경
		tt[0] = Integer.parseInt(t[0]); // 시
		tt[1] = Integer.parseInt(t[1]); // 분
		tt[2] = Integer.parseInt(t[2]); // 초
		ss[0] = Integer.parseInt(s[0]); // 시
		ss[1] = Integer.parseInt(s[1]); // 분
		ss[2] = Integer.parseInt(s[2]); // 초
		ee[0] = Integer.parseInt(e[0]); // 시
		ee[1] = Integer.parseInt(e[1]); // 분
		ee[2] = Integer.parseInt(e[2]); // 초
		System.out.printf("%d시 %d분 %d초\n", tt[0],tt[1],tt[2]);
		System.out.printf("%d시 %d분 %d초\n", ss[0],ss[1],ss[2]);
		System.out.printf("%d시 %d분 %d초\n", ee[0],ee[1],ee[2]);
		String result="out";
		if(tt[0]>=ss[0] && tt[0]<=ee[0]) { // 시간이 사이에 있으면
			if(tt[0]==ss[0]) { // 시작 시간과 같다면
				if(tt[1]>ss[1]) { // 분
					result = "in";
				}else if(tt[1]==ss[1]) { // 분도 같다면
					if(tt[2]>=ss[2]) { // 초
						result="in";
					}
				}
			}else if(tt[0]==ee[0]) { // 종료시간과 같다면
				if(tt[1]<ee[1]) {
					result = "in";
				}else if(tt[1]==ee[1]) {
					if(tt[2]<=ee[2]) {
						result="in";
					}
				}
			}else {
				result = "in";
			}
		}
		System.out.println(result);
		
	}
}
