package interface_learning;

public class Student extends Contactmain implements nameprint{
	String department;
	
	Student(String fname, String lname, int id, String phone,String college,String department){
		super(fname,lname,id,phone,college);
		this.department = department;
	}
	
	
	
	@Override
	public String[] getname() {
		return new String[] {fname, lname};
	}
}
