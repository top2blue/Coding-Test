package kr.green.Example.ex0617;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
	 @Test
	 public void test() {
		 Solution s = new Solution();
		 assertEquals(s.solution(new String[]{"mislav", "stanko", "mislav","ana"},
				                 new String[] {"stanko", "ana","mislav"}), "mislav");
	 }
	
	 public String solution(String[] participant, String[] completion) {
		 /*
		 String result = "";
		 for(int i=0;i<participant.length;i++) {
			 for(int j=0;j<completion.length;j++) {
				 if(participant[i].equals(completion[j])) {
					 participant[i]="";
					 completion[j]="";
					 break;
				 }
			 }
		 }
		 //System.out.println(Arrays.toString(participant));
		 for(int i=0;i<participant.length;i++) {
			 if(!participant[i].equals("")) {
				 result = participant[i];
				 break;
			 }
		 }
		 //System.out.println(result);
		 return result;
		 */
		 Arrays.sort(participant);
         Arrays.sort(completion);
         int i;
         for ( i=0; i < completion.length; i++){
            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
	 }
}
