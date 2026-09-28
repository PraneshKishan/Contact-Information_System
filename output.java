package interface_learning;

interface nameprint{
	String[] getname();
}

public class output {
	public void print_name(nameprint print_obj) {
		String[] fullname = print_obj.getname();
		System.out.println(fullname[0]+" "+fullname[1]);
	}

}
