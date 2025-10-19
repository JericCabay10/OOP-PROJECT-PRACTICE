package studentmanagementystem;

public class Student extends Person {
	private String _id;
	private String _grade;
	private int _studentnumber;
	
	public Student(String id, String name, int age, String grade) {
		super(name, age);
		setId(id);
		this._grade = grade;
		
	}
	
	//ID SETTER AND GETTER 
	public void setId(String id) {
		int digit = 0;
		int chr = 0;
		
		for(int a = 0; a < id.length(); a++) {
			char ch = id.charAt(a);
			
			if(ch >= '0' && ch <= '9') {
				digit++;
			}
			
			if(ch >= 'A' && ch <= 'Z') {
				chr++;
			}
		}
		
		if(digit == 6 && chr == 2) {
			this._id = id;
		}else {
			System.out.println("The length of id must be 6 digit.");
			this._id = null;
		}
	}
	
	public String getId() {
		return this._id;
	}
	
	//GRADE SETTER AND GETTER
	public void setGrade(String grade) {
		this._grade = grade;
	}
	
	public String getGrade() {
		return this._grade;
	}

	//STUDENT COUNT GETTER AND SETTER
	public void setStudentNumber(int count) {
		this._studentnumber = count;
	}
	
	public int getStudentNumber() {
		return this._studentnumber;
	}
	

	public void studentInfo() {
		System.out.println("Student: " + this._studentnumber);
		System.out.println("Student Id: " + this._id);
		System.out.println("Student name: " + getName());
		System.out.println("Student age: " + getAge());
		System.out.println("Student grade: " + this._grade);
		System.out.println("");
	}
	
}
