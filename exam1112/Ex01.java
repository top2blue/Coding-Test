package exam1112;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/*
문제 1] 수포자는 수학을 포기한 사람의 준말입니다. 
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	    return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]

입출력 예 설명
입출력 예 #1
수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2
모든 사람이 2문제씩을 맞췄습니다.
*/
public class Ex01 {
	/*
	@Before, @After가 메소드 위에 선언되면 해당 테스트 클래스 안에 메소드들이 
	테스트 되기 전과 후에 각각 실행되게 지정하는 어노테이션 입니다.
	@BeforeClass, @AfterClass가 메소드 위에 선언되면 해당 테스트 클래스에서 
	딱 한 번씩만 수행되도록 지정하는 어노테이션 입니다.
    @BeforeClass
    public void setUpBeforeClass() throws Exception { }
    @AfterClass
    public void tearDownAfterClass() throws Exception { }
	@Before
    public void setUp() throws Exception { }
	@After
    public void tearDown() throws Exception { }
	*/
	
	@Test
	public void test1() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(new int[] {1,2,3,4,5}), new int[] {1});
	}
	@Test
	public void test2() {
		Solution solution = new Solution();
		assertArrayEquals(solution.solution(new int[] {1,3,2,4,2}), new int[] {1,2,3});
	}
}

class Solution {
	public int[] solution(int[] answers) {
        int[] answer = {};
        int[] ar = new int[3];
        // 1번 수포자 : 1, 2, 3, 4, 5
        int[] t1 = {1,2,3,4,5};
        for(int i=0;i<answers.length;i++) {
        	if(answers[i]==t1[i%t1.length]) ar[0]++;
        }
        System.out.println("1번 수포자 : " + ar[0]);
        // 2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5
        int[] t2 = {2, 1, 2, 3, 2, 4, 2, 5};
        for(int i=0;i<answers.length;i++) {
        	if(answers[i]==t2[i%t2.length]) ar[1]++;
        }
        System.out.println("2번 수포자 : " + ar[1]);
        // 3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        int[] t3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i=0;i<answers.length;i++) {
        	if(answers[i]==t3[i%t3.length]) ar[2]++;
        }
        System.out.println("3번 수포자 : " + ar[2]);
        int max = -1;
        for(int i=0;i<ar.length;i++) {
        	if(max<ar[i]) max = ar[i];
        }
        System.out.println("최대 값 : " + max);
        // 최대값과 같은 개수 구한다.
        int count=0;
        for(int i=0;i<ar.length;i++) {
        	if(max==ar[i]) count++;
        } 
        // 배열 생성
        answer = new int[count];
        // 배열에 최대값과 같은 값을 가지는 위치를 저장
        for(int i=0;i<count;i++) {
        	if(max==ar[i]) answer[i] = i+1;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
