package interface_learning;

import java.sql.SQLException;
import java.util.ArrayList;





public class Contactstore {

	
	
	Dboperations persistantHandler = new Dboperations();
	
	ArrayList<Student> student_contacts = new ArrayList<>();
	ArrayList<Teacher> teacher_contacts = new ArrayList<>();
	
	Contactstore(){
		try {
			persistantHandler.load();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void add_students_contacts(Student stud_obj) {
		student_contacts.add(stud_obj);
		try {
			persistantHandler.getstudentval(stud_obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void add_teacher_contacts(Teacher teacher_obj) {
		teacher_contacts.add(teacher_obj);
	}
	void print_student_contacts() {
		for(Student val:student_contacts) {
			System.out.println(val.fname+" "+val.lname+" "+val.phone+" "+val.id);
		}
	}
	void print_teacher_contacts() {
		for(Teacher val:teacher_contacts) {
			System.out.println(val.fname+" "+val.lname+" "+val.phone+" "+val.id);
		}
	}

}
