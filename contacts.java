package interface_learning;
import java.util.*;

public class contacts {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		nameprint cont_obj;
		Contactstore cont_store = new Contactstore();
		
		
		
		System.out.println("Which contact do you want to create:");
		System.out.println("1. Student");
		System.out.println("2. Teacher");
		int option = scan.nextInt();
		
		if(option == 1) {
			System.out.println("Enter fname, lname, id, phone, college,dept");
			String fname = scan.next();
			String lname = scan.next();
			scan.nextLine();
			int id = scan.nextInt();
			scan.nextLine();
			String phone = scan.nextLine();
			String college = scan.nextLine();
			String department = scan.nextLine();
			System.out.println("fname: "+fname+" lastname: "+lname+" id: "+id+" phone: "+phone+" college: "+college+" dept: "+department);
			cont_obj = new Student(fname,lname,id,phone,college,department);
			Student stud_obj = (Student) cont_obj;
			cont_store.add_students_contacts(stud_obj);
			//((Student) cont_obj.getname();
			
		}
		else {
			System.out.println("Enter fname, lname, id, phone, college, mode of transport");
			String fname = scan.nextLine();
			String lname = scan.nextLine();
			int id = scan.nextInt();
			String phone = scan.nextInt();
			String college = scan.nextLine();
			String transport = scan.nextLine();
			cont_obj = new Teacher(fname,lname,id,phone,college,transport);
			Teacher t_obj = (Teacher) cont_obj;
			cont_store.add_teacher_contacts(t_obj);
			
		}
		
		cont_obj.getname();
		
	}

}
