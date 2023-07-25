package pccp.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 연속된부분수열합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5);
	}

	public static int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int startIdx = 0, endIdx = 0;
        int sum = sequence[0];
        List<int[]> results = new ArrayList<>();
        
        while(true) {
        	if(sum == k) {
        		results.add(new int[] {startIdx, endIdx, endIdx-startIdx});
        	}
        	
        	if(startIdx == sequence.length && endIdx == sequence.length) break;
        	
        	if(sum < k && endIdx < sequence.length) {
        		endIdx++;
        		if(endIdx < sequence.length)sum += sequence[endIdx];
        	} else {
        		sum -= sequence[startIdx];
        		startIdx++;
        	}
        	
        }
        
        Collections.sort(results, new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
        		int res = o1[2]-o2[2];
        		if(res == 0) res = o1[0] - o2[0];
				return res;
        	};
        });

        answer = new int[] {results.get(0)[0], results.get(0)[1]};
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
