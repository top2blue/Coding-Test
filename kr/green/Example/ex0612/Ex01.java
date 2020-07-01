package kr.green.Example.ex0612;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*
문제 1] Every Other Digit
모든 짝수번째 숫자를 * 로 치환하시오.
(홀수번째 숫자,또는 짝수번째 문자를 치환하면 안됩니다.) 
로직을 이용하면 쉬운데 정규식으로는 어려울거 같아요.

Example: a1b2cde3~g45hi6 → a*b*cde*~g4*hi6
출처:http://regex101.com/quiz/
*/
public class Ex01 {
	@Test
	public void minTest() {
		assertEquals(Ex01.replace("a1b2cde3~g45hi6"), "a*b*cde*~g4*hi6");
	}
	
	public static String replace(String data) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<data.length();i++) {
			char ch = data.charAt(i); // 1글자 얻기
			if(i%2==1) { // 짝수번째 라면
				if(ch>='0' && ch<='9') // 숫자면
					sb.append("*"); // 치환
				else
					sb.append(ch); // 아니면 그냥
			}else {
				sb.append(ch); // 홀수번째는 그냥
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
