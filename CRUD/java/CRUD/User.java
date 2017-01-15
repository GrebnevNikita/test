package CRUD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	private int id;

	public List<String> getStatuses() {
		return statuses;
	}

	private String name;
	private int age;
	private Date timeCreared;
	private boolean isAdmn;
	private String status="false";
	private final List<String> statuses = new ArrayList<String>();
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getTimeCreared() {
		return timeCreared;
	}

	public void setTimeCreared(Date timeCreared) {
		this.timeCreared = timeCreared;
	}

	public boolean getAdmn() {
		return isAdmn;
	}
	public void setAdmn(String Admn) {
		System.out.println(Admn);

	}
	public void setAdmn(boolean Admn) {
		this.isAdmn = Admn;
	}

	public User() {
		statuses.add("true");
		statuses.add("false");

	}
}
