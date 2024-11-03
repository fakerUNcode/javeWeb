package bean;

public class ContactPerson {
	private String name;	//姓名
	private String phoneNumber;	//电话号码
	private String group; 	//分组

	public ContactPerson() {
	}
	public ContactPerson(String name, String phoneNumber, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getGroup() {
		return group;
	}
	public boolean equals(Object obj){
		if(obj==null) return false;
		if(obj==this) return true;
		if(obj instanceof ContactPerson){
			ContactPerson cp = (ContactPerson)obj;
			return cp.name.equals(this.name) && cp.phoneNumber.equals(this.phoneNumber) && cp.group.equals(this.group);
		}
		return false;
	}
	public int hashCode(){
		return this.name.hashCode()^this.phoneNumber.hashCode()^this.group.hashCode()^0xabd926;
	}
}
