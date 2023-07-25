package pccp.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class 호텔대실 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String book_time[][] = {
				{"15:00", "17:00"},
				{"16:40", "18:20"},
				{"14:20", "15:20"},
				{"14:10", "19:20"},
				{"18:20", "21:20"}
		};
		
		System.out.println(solution(book_time));
	}

	public static int solution(String[][] book_time) {
        int answer = 0;
        ArrayDeque<LinkedList<String[]>> hotel = new ArrayDeque<LinkedList<String[]>>();
        Arrays.sort(book_time, myComp());
        
        LinkedList<String[]> initRoom = new LinkedList<>();
        initRoom.add(book_time[0]);
        hotel.add(initRoom);
        
        
        for(int i=0; i<book_time.length; i++) {
        	if(i==0) continue;
        	String start= book_time[i][0];
        	
        	int startHour = Integer.parseInt(start.split(":")[0]);
        	int startMin= Integer.parseInt(start.split(":")[1]);
        	boolean needNewRoom = true;
        	
        	for(LinkedList<String[]> curRoom : hotel) {
        		
        		int lastBookEndHour = Integer.parseInt(curRoom.getLast()[1].split(":")[0]);
        		int lastBookEndMin= Integer.parseInt(curRoom.getLast()[1].split(":")[1]);
        		if(lastBookEndMin < 50) lastBookEndMin += 10;
        		else {
        			lastBookEndHour += 1;
        			lastBookEndMin -= 50;
        		}
        		
        		if(startHour < lastBookEndHour) continue;
        		
        		if((startHour == lastBookEndHour && startMin >= lastBookEndMin)
        			|| (startHour > lastBookEndHour) ) {
        			curRoom.add(book_time[i]);
        			needNewRoom = false;
        			break;
        		}
        	}
        	
        	if(needNewRoom) {
        		LinkedList<String[]> newRoom = new LinkedList<>();
        		newRoom.add(book_time[i]);
                hotel.add(newRoom);
        	}
        }
        answer = hotel.size();
        return answer;
    }

	private static Comparator<String[]> myComp() {
		return new Comparator<String[]>() {
        	public int compare(String[] o1, String[] o2) {
        		int o1Hour = Integer.parseInt(o1[0].split(":")[0]);
        		int o1Minute = Integer.parseInt(o1[0].split(":")[1]);
        		
        		int o2Hour = Integer.parseInt(o2[0].split(":")[0]);
        		int o2Minute = Integer.parseInt(o2[0].split(":")[1]);
        		
        		int res = o1Hour-o2Hour;
        		if(res == 0) {
        			res = o1Minute-o2Minute;
        			if(res == 0) {
        				o1Hour = Integer.parseInt(o1[1].split(":")[0]);  
        				o1Minute = Integer.parseInt(o1[1].split(":")[1]);
        				                                                 
        				o2Hour = Integer.parseInt(o2[1].split(":")[0]);  
        				o2Minute = Integer.parseInt(o2[1].split(":")[1]);
        				
        				res = o1Hour-o2Hour != 0 ? o1Hour-o2Hour : o1Minute-o2Minute;
        			}
        		}
        		return res;
        	}
        };
	}
}
