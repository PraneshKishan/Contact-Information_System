package interface_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dboperations {
	
	public String createconttable() {
		String query = "create table if not exists contacts(fname varchar(50), lname varchar(50),id int primary key,phone varchar(20),college varchar(100))";
		return query;
	}
	
	public String createstudtable() {
		String query = "create table if not exists students(id int,department varchar(100))";
		return query;
	}
	
	public String createteachertable() {
		String query = "create table if not exists teachers(id int,transport varchar(100))";
		return query;
	}
	
	public String getvaluesfromdb() {
		String query = "select contacts.*,students.department from contacts inner join students on contacts.id = students.id;";
		return query;
	}
	
//	public String addvalue() {
//		String query = "insert into contacts(fname,lname,id,phone,college) values (\"Pranesh\",\"Kishan\",11,\"9360845468\",\"Kalasalingam\"),(\"Shravan\",\"Babu\",12,\"992762909\",\"Velammal\");";
//		return query;
//	}
	
	Connection con;
	Statement st;
	
	Dboperations() {
		try {
			con = DriverManager.getConnection("jdbc:mysql:///dummy","root","Pranesh@26");
			st = con.createStatement();
			st.execute(createconttable());
			String query = createstudtable();
			st.execute(query);
			st.execute(createteachertable());
			
			
		}catch(SQLException e) {
			System.out.println("Error" + e);
		}catch(Exception e) {
			
		}
	}
	
	public void load() throws SQLException {
		ResultSet result = st.executeQuery(getvaluesfromdb());
		ArrayList<Student> stud_entity = new ArrayList<>();
		 while (result.next()) {
		        String fname = result.getString("fname");
		        String lname = result.getString("lname");
		        int id = result.getInt("id");
		        String phone = result.getString("phone");
		        String college = result.getString("college");
		        String department = result.getString("department");

		        System.out.printf("%-10s %-10s %-5d %-15s %-20s %-15s%n", 
		                          fname, lname, id, phone, college, department);
		        
		        Student stud_temp_obj = new Student(fname,lname,id,phone,college,department);
		        stud_entity.add(stud_temp_obj);
		        
		    }
		
		System.out.println(stud_entity);
		
		
	}
	
	public void getstudentval(Student s) throws SQLException {
		String query = "insert into contacts(fname,lname,id,phone,college) values ('" +s.fname + "','" + s.lname + "','" + s.id + "','" + s.phone + "','" + s.college + "');" ;
		System.out.println(query);
		
		String query2 = "insert into students(id,department) values ('" +s.id + "','" + s.department + "')";
		st.execute(query2);
		
		st.execute(query);
		
	}
	
	public void getteacherval() {
		
	}
	
	
	public static void DB(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql:///dummy","root","Pranesh@26");
			
//			String query = "create table contacts(fname varchar(50), lname varchar(50),id int primary key,phone varchar(20),college varchar(100))";
//			st.executeUpdate(query);
			
//			ResultSet rs = st.executeQuery(query);
//			while(rs.next()) {
//				System.out.println(rs.getString(1)+" "+rs.getString(2));
//			}
			con.close();
		}catch(SQLException e) {
			System.out.println("Error" + e);
		}catch(Exception e) {
			
		}
	}

}
