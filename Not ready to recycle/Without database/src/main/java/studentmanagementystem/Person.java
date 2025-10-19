package studentmanagementystem;

public class Person {
	private String _id;
	private String _name;
	private int _age;
	private String _grade;

	public Person(String name, int age) {
		this._name = name;
		setAge(age);
	}
	
	//NAME SETTER AND GETTER
	public void setName(String name) {
		this._name = name;
	}
	
	public String getName() {
		return this._name;
	}
	
	//AGE SETTER AND GETTER
	public void setAge(int age) {
		if(age > 0) {
			this._age = age;
		}else {
			System.out.println("The age must be positive");
		}
	}
	
	public int getAge() {
		return this._age;
	}
}
