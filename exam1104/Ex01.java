package exam1104;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
문제 1] 단어 세기(Word Counting)
텍스트가 입력으로 주어질 때, 단어의 개수를 세는 프로그램을 작성한다.
"문자 세기"와 "단어 세기"는 프로그래밍 입문에 성공했는지를 가늠하는 문제라고 할 수 있습니다.
지금은 발가락으로도 만드는 분들이 많겠지만 처음에는 의외로 많이 어려워합니다.
추억을 살려 봅시다.

입력
아래 내용을 가진 텍스트파일을 미리 만들어 두고, 프로그램을 실행하면 파일 내용을 읽어들인다

As the country became embroiled in a domestic crisis, the first government 
was dislodged and succeeded by several different administrations. Bolikango 
served as Deputy Prime Minister in one of the new governments before a partial 
state of stability was reestablished in 1961. He mediated between warring factions 
in the Congo and briefly served once again as Deputy Prime Minister in 1962 before
returning to the parliamentary opposition. After Joseph-Desire Mobutu took power 
in 1965, Bolikango became a minister in his government. Mobutu soon dismissed him 
but appointed him to the political bureau of the Mouvement Populaire de la Revolution. 
Bolikango left the bureau in 1970. He left Parliament in 1975 and died seven years later. 
His grandson created the Jean Bolikango Foundation in his memory to promote social progress. 
The President of the Congo posthumously awarded Bolikango a medal in 2005 for his long career
in public service.

출력
구분자(Separator)는 마침표 '.', 쉼표 ',', 공백 ' ', 줄바꿈('\n') 이다.
가장 많이 나온 순서대로 단어 10개와 그 단어의 빈도를 출력한다.
빈도가 같은 단어들 사이의 순서는 무시한다.

in 12
the 10
Bolikango 5
a 4
of 4
and 3
to 3
his 3
became 2
government 2
 */
public class Ex01 {
	public static void main(String[] args) {
		String content = readTextFiles("src/exam1104/data.txt");
		// 모두 단어로 변경해서 배열로 만듬
		String[] strArray = content.replaceAll("[^a-zA-Z0-9 ]", "").split(" ");
		System.out.println("단어수 : " + strArray.length); 
		
		System.out.println(Arrays.toString(strArray));
		
		Map<String,Integer> map = new HashMap<>(); // 맵
		for (int i = 0; i < strArray.length-1; i++) {
			int count = 0;
			for(int j=i;j<strArray.length;j++) {
				if(strArray[i].equals(strArray[j])) count++; // 같은단어 세기
			}
			if(map.containsKey(strArray[i])) {
				if(map.get(strArray[i])< count) map.put(strArray[i], count); // 이미 저장된 단어가 있으면 개수가 크면 저장
			}else {
				map.put(strArray[i], count);
			}
		}
		Set<String> set = new TreeSet<>(); // 정렬이 지원되는 셑
		for(String key : map.keySet()) {
			set.add(String.format("%05d : %s", map.get(key), key)); // 붙여서 셑에 저장
		}
		List<String> result = new ArrayList<>();
		for(String t : set)	result.add(t); // 리스트로 변경
		Collections.reverse(result); // 뒤집기
		for(int i=0;i<10;i++) // 10개 출력
			System.out.println(result.get(i));
		
		
	}
	// 읽기
	private static String readTextFiles(String fileName) {
		String content = "";
		try {
			Path filePath = Paths.get(fileName);
			byte[] data = Files.readAllBytes(filePath);
			content = new String(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("-------------------------------------------------");
		System.out.println("-----------------------------------------------");
		System.out.println(content);
		System.out.print("-------------------------------------------------");
		System.out.println("-----------------------------------------------");
		return content;
	}
}
