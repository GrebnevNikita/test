package CRUD;

public class Filter {
	private String id = "";
	private String name = "";
	private String age = "";
	private String status = "";
	private String dateDay = "";
	private String dateMounth = "";
	private String dateYear = "";
	public String getDateDay() {
		return dateDay;
	}

	public void setDateDay(String dateDay) {
		this.dateDay = dateDay== null ? "" : dateDay.trim();
	}

	public String getDateMounth() {
		return dateMounth;
	}

	public void setDateMounth(String dateMounth) {
		this.dateMounth = dateMounth== null ? "" : dateMounth.trim();
	}

	public String getDateYear() {
		return dateYear;
	}

	public void setDateYear(String dateYear) {
		this.dateYear = dateYear== null ? "" : dateYear.trim();
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status== null ? "" : status.trim();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id== null ? "" : id.trim();;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name== null ? "" : name.trim();;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age== null ? "" : age.trim();;
	}

}

