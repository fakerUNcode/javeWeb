package forum;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;

/***
 * ∞¥’’»»√≈°¢∫√∆¿≈≈–Ú
 */
public class ComparatorHotBest implements Comparator {
	public int compare(Object obj1, Object obj2) {
		if(obj1 instanceof Message && obj2 instanceof Message){
			Message s1=(Message)obj1;
			Message s2=(Message)obj2;
			int diff = s2.getVote_count()-s1.getVote_count();  //Õ∂∆±Ωµ–Ú
			if(diff==0){
				return 	s2.getScore()-s1.getScore();  //∆¿∑÷Ωµ–Ú
			}else{
				return diff;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		List<Message> list = new ArrayList<Message>();
		list.add(new Message("song",1,4));
		list.add(new Message("yan",2,5));
		list.add(new Message("Lucy",2,5));
		
		list.sort(new ComparatorHotBest());
		for(Message m:list){
			System.out.println(m);
		}
	}
}
