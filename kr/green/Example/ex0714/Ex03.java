package kr.green.Example.ex0714;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*

 */
public class Ex03 {
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}), 2);
	}
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        for(String t : skill_trees) {
				String str = "";
				for(String x : t.split("[^"+skill+"]")) {
					if(x.trim().length()>0) str+=x;
				}
				if(skill.startsWith(str)) {
					answer++;
				}
			}     
	        System.out.println(answer);
	        return answer;
	    }
	}
}
