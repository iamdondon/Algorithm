package pccp.lv2;

public class 광물캐기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] picks = new int[] {1, 3, 2};
		String[] minerals = new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		System.out.println(solution(picks, minerals));
		
	}

	public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int idx = 0;
        
        int diaGok = picks[0]*5;
        int ironGok = picks[0]*5;
        int stoneGok = picks[0]*5;
        
        if(minerals.length <= diaGok) answer += minerals.length;
        else {
        	answer += diaGok;
        	
        	if(minerals.length - diaGok <= ironGok) {
        		for(int i=diaGok; i<minerals.length; i++) {
        			if(minerals[i].equals("diamond")) {
        				answer += 5;
        			} else {
        				answer += 1;
        			}
        		}
        	} else {
        		
        	}
        }
        return answer;
    }
}
