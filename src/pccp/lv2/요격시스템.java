package pccp.lv2;

import java.util.Arrays;

public class 요격시스템 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int targets[][] = new int[][]{ 
									{4, 5},
									{4, 8},
									{10, 14},
									{11, 13},
									{5, 12},
									{3, 7},
									{1, 4} };
		System.out.println(solution(targets));
	}

	
	public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        
        int missile = -1;
        for(int[] target : targets) {
        	
        	if(missile == -1) {
        		answer++;
        		missile = target[1]-1;
        		continue;
        	}
        	
        	if(missile >= target[0] && missile <= target[1]) {
        		continue;
        	}
        	
        	missile = target[1]-1;
        	answer++;
        }
        return answer;
    }
}
