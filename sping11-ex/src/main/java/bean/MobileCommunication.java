package bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MobileCommunication {
	private Set<ContactPerson> contacts;
	
	public MobileCommunication() {
		super();
	}

	public Set<ContactPerson> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactPerson> contacts) {
		this.contacts = contacts;
	}

	public Map<String,Set<ContactPerson>> groupByGroup(){
		Set<ContactPerson> colleagues = new HashSet<ContactPerson>();
		Set<ContactPerson> family = new HashSet<ContactPerson>();
		Set<ContactPerson> friends = new HashSet<ContactPerson>();
		
		Map<String,Set<ContactPerson>> map= new HashMap<String,Set<ContactPerson>>();
		
		Iterator<ContactPerson> it = contacts.iterator();
		while(it.hasNext()){
			ContactPerson cp = it.next();
			if(cp.getGroup().equals("colleagues")){
				colleagues.add(cp);
			}else if(cp.getGroup().equals("family")){
				family.add(cp);
			}else if(cp.getGroup().equals("friends")){
				friends.add(cp);
			}
			
			map.put("colleagues",colleagues);
			map.put("family",family);
			map.put("friends", friends);			
		}	
		return map;
	}
	
	public void printGroup(Map<String, Set<ContactPerson>> map){
		Set<String> groups = map.keySet();
		Iterator<String> it = groups.iterator();
		while(it.hasNext()){
			String group = it.next();
			Set<ContactPerson> contacts = map.get(group);
			if(contacts.size()>0){
				System.out.println(group+"组内包含的联系人如下:");
				//输出组内信息
				Iterator<ContactPerson> itit = contacts.iterator();
				while(itit.hasNext()){
					ContactPerson cp = itit.next();
					System.out.println(cp.getName()+"\t"+cp.getPhoneNumber());
				}	
			}			
		}
	}
}
