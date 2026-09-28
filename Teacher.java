package interface_learning;

public class Teacher extends Contactmain implements nameprint{
	String transport;
	
	Teacher(String fname, String lname, int id, String phone,String college,String transport){
		super(fname,lname,id,phone,college);
		this.transport = transport;
	}

		
		@Override
		public String[] getname() {
			String a = lname;
			String b = fname;
			String[] arr = {a,b};
			return arr;
		}
}
