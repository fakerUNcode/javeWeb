package forum;

import java.util.ArrayList;
import java.util.List;

public class MessageBean {
	private List<Message> list;

	public MessageBean() {
		list = new ArrayList<Message>();
	}

	public List<Message> getList() {
		return list;
	}

	public void setList(List<Message> list) {
		this.list = list;
	}
	
	public void add(Message m){
		list.add(m);
	}
	
	public int modifyVote(int id){
		for(Message m : list){
			if(m.getId()==id){
				m.setVote_count(m.getVote_count()+1);
				return m.getVote_count();
			}
		}
		return 0;
	}
}
