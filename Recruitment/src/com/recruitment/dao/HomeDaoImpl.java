package com.recruitment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.recruitment.model.Applicant;
import com.recruitment.model.Company;
import com.recruitment.model.Recruiter;
import com.recruitment.model.Student;

@Repository
public class HomeDaoImpl implements HomeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		final String procedureCall = "{call Proc_App(?,?,?,?,?)}";
		Connection conn = null;
		System.out.println("student roll no is:"+s.getRollno());
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(procedureCall);
			callableSt.setString(1, "insert");
			callableSt.setString(2, s.getName());
			callableSt.setString(3, s.getRollno());
			callableSt.setString(4, s.getEmail());
			callableSt.setString(5, s.getPassword());
			callableSt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int checkStudent(String email, String pass) {
		// TODO Auto-generated method stub
		int flag = 0;
		final String procedureCall = "{call Proc_App(?,?)}";
		Connection connection = null;
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "login");
			callableSt.setString(2, email);
			System.out.println(pass);
			ResultSet rst = callableSt.executeQuery();
			if (rst.next()) {
				System.out.println(rst.getString("password"));
				if (rst.getString("password").equals(pass)) {
					flag = 1;
				} else {
					flag = 2;
				}
			} else {
				flag = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Student update(Student s) {
		// TODO Auto-generated method stub
		String email = s.getEmail();
		final String proCall = "{call Proc_App(?,?)}";
		Connection conn = null;
		Student st = new Student();
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proCall);
			callableSt.setString(1, "update");
			callableSt.setString(2, email);
			ResultSet rst = callableSt.executeQuery();

			if (rst.next()) {
				st.setName(rst.getString("name"));
				st.setRollno(rst.getString("rollno"));
				st.setBranch(rst.getString("branch"));
				st.setFatherName(rst.getString("Fname"));
				st.setMotherName(rst.getString("Mname"));
				st.setPer10(rst.getString("per10"));
				st.setPer12(rst.getString("per12"));
				st.setAddress(rst.getString("address"));
				st.setContact(rst.getString("contact"));
				st.setPassword(rst.getString("password"));
				st.setAggregate(rst.getString("aggregate"));
				st.setBack(rst.getString("backlogs"));
				st.setDob(rst.getString("dob"));
				st.setGender(rst.getString("gender"));
				st.setPassingYear(rst.getString("passingYear"));
				st.setSkills(rst.getString("skills"));
				st.setEmail(email);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public void updateStudent(Student s1) {
		// TODO Auto-generated method stub
		final String procedureCall = "{call Proc_App(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection conn = null;
		System.out.println("update student info roll"+s1.getRollno());
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(procedureCall);
			callableSt.setString(1, "updateall");
			callableSt.setString(2, s1.getName());
			callableSt.setString(3, s1.getRollno());
			callableSt.setString(4, s1.getBranch());
			callableSt.setString(5, s1.getFatherName());
			callableSt.setString(6, s1.getMotherName());
			callableSt.setString(7, s1.getPer10());
			callableSt.setString(8, s1.getPer12());
			callableSt.setString(9, s1.getEmail());
			callableSt.setString(10, s1.getAddress());
			callableSt.setString(11, s1.getContact());
			callableSt.setString(12, s1.getPassword());
			callableSt.setString(13, s1.getAggregate());
			callableSt.setString(14, s1.getBack());
			callableSt.setString(15, s1.getSkills());
			callableSt.setString(16, s1.getDob());
			callableSt.setString(17, s1.getGender());
			callableSt.setString(18, s1.getPassingYear());
			callableSt.execute();
			System.out.println("completed updation");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addCompany(Company c) {
		// TODO Auto-generated method stub
		final String procedureCall = "{call Proc_Comp(?,?,?,?,?,?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(procedureCall);
			callableSt.setString(1, "insert");
			callableSt.setString(2, c.getName());
			callableSt.setString(3, c.getEmail());
			callableSt.setString(4, c.getLocation());
			callableSt.setString(5, c.getPass());
			callableSt.setString(6, c.getContact());
			callableSt.setString(7, c.getWebsite());
			callableSt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Student> stVerify() {
		// TODO Auto-generated method stub
		ArrayList<Student> li = new ArrayList<Student>();
		final String proCall = "{call Proc_App(?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proCall);
			callableSt.setString(1, "view");
			ResultSet rst = callableSt.executeQuery();
			while (rst.next()) {
				Student st = new Student();
				st.setName(rst.getString("name"));
				st.setEmail(rst.getString("email"));
				st.setRollno(rst.getString("rollno"));
				li.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public int checkCompany(String email, String pass) {
		// TODO Auto-generated method stub
		int flag = 0;
		final String procedureCall = "{call Proc_Comp(?,?)}";
		Connection connection = null;
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = connection.prepareCall(procedureCall);
			callableSt.setString(1, "login");
			callableSt.setString(2, email);
			System.out.println(pass);
			ResultSet rst = callableSt.executeQuery();
			if (rst.next()) {
				System.out.println(rst.getString("password"));
				if (rst.getString("password").equals(pass)) {
					flag = 1;
				} else {
					flag = 2;
				}
			} else {
				flag = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ArrayList<Company> cmpVerify() {
		// TODO Auto-generated method stub
		ArrayList<Company> li = new ArrayList<Company>();
		final String proCall = "{call Proc_Comp(?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proCall);
			callableSt.setString(1, "view");
			ResultSet rst = callableSt.executeQuery();
			while (rst.next()) {
				Company c = new Company();
				c.setName(rst.getString("Cname"));
				c.setEmail(rst.getString("Cemail"));
				c.setLocation(rst.getString("location"));
				c.setContact(rst.getString("contact"));
				c.setPass(rst.getString("password"));
				c.setWebsite(rst.getString("website"));
				li.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void cmpVerified(String email) {
		// TODO Auto-generated method stub
		final String proccall = "{call Proc_Comp(?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proccall);
			callableSt.setString(1, "verified");
			callableSt.setString(2, email);
			callableSt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stVerified(String email) {
		// TODO Auto-generated method stub
		final String proccall = "{call Proc_App(?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proccall);
			callableSt.setString(1, "verified");
			callableSt.setString(2, email);
			callableSt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addDrive(Recruiter rec) {
		// TODO Auto-generated method stub
		final String proccall = "{Call Proc_Drive(?,?,?,?,?,?,?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement st = conn.prepareCall(proccall);
			st.setString(1, "insert");
			st.setString(2, rec.getEmail());
			st.setString(3, rec.getPosition());
			st.setString(4, rec.getSalary());
			st.setString(5, rec.getDate());
			st.setString(6, rec.getRequirements());
			st.setString(7, rec.getCriteria());
			st.setString(8, rec.getName());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Company viewCompProfile(String email) {
		// TODO Auto-generated method stub
		final String proccall = "{call Proc_Comp(?,?)}";
		Connection conn = null;
		Company cmp = new Company();
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proccall);
			callableSt.setString(1, "see");
			callableSt.setString(2, email);
			ResultSet rst = callableSt.executeQuery();
			if (rst.next()) {
				cmp.setContact(rst.getString("contact"));
				cmp.setEmail(rst.getString("Cemail"));
				cmp.setLocation(rst.getString("location"));
				cmp.setName(rst.getString("Cname"));
				cmp.setWebsite(rst.getString("website"));
				cmp.setPass(rst.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmp;
	}

	@Override
	public void updateCompany(Company c1) {
		// TODO Auto-generated method stub
		final String procedureCall = "{call Proc_Comp(?,?,?,?,?,?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(procedureCall);
			callableSt.setString(1, "updateall");
			callableSt.setString(2, c1.getName());
			callableSt.setString(3, c1.getEmail());
			callableSt.setString(4, c1.getLocation());
			callableSt.setString(5, c1.getPass());
			callableSt.setString(6, c1.getContact());
			callableSt.setString(7, c1.getWebsite());
			callableSt.execute();
			System.out.println("completed updation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Recruiter> deriveVerify() {
		// TODO Auto-generated method stub
		ArrayList<Recruiter> li = new ArrayList<Recruiter>();
		final String proCall = "{call Proc_Drive(?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proCall);
			callableSt.setString(1, "view");
			ResultSet rst = callableSt.executeQuery();
			while (rst.next()) {
				Recruiter st = new Recruiter();
				st.setEmail(rst.getString("Cemail"));
				st.setPosition(rst.getString("position"));
				st.setSalary(rst.getString("salary"));
				st.setDate(rst.getString("driveDate"));
				st.setRequirements(rst.getString("requirements"));
				st.setCriteria(rst.getString("criteria"));
				li.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;

	}

	@Override
	public void deriveVerified(String email) {
		// TODO Auto-generated method stub
		final String proccall = "{call Proc_Drive(?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proccall);
			callableSt.setString(1, "verified");
			callableSt.setString(2, email);
			callableSt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Recruiter> ComingDerivesInfo() {
		// TODO Auto-generated method stub
		ArrayList<Recruiter> li = new ArrayList<Recruiter>();
		final String proCall = "{call Proc_Drive(?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proCall);
			callableSt.setString(1, "info");
			ResultSet rst = callableSt.executeQuery();
			while (rst.next()) {
				Recruiter st = new Recruiter();
				st.setName(rst.getString("Cname"));
				st.setPosition(rst.getString("position"));
				st.setSalary(rst.getString("salary"));
				st.setDate(rst.getString("driveDate"));
				st.setRequirements(rst.getString("requirements"));
				st.setCriteria(rst.getString("criteria"));
				st.setId(rst.getString("id"));
				st.setEmail(rst.getString("Cemail"));
				li.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void addApplicant(String semail, String cid) {
		// TODO Auto-generated method stub
		final String procedureCall = "{call Proc_Apply(?,?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(procedureCall);
			callableSt.setString(1, "insert");
			callableSt.setString(2, semail);
			callableSt.setInt(3, Integer.parseInt(cid));
			callableSt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Applicant> viewApplications(String email) {
		// TODO Auto-generated method stub
		ArrayList<Applicant> li = new ArrayList<Applicant>();
		final String proCall = "{call Proc_Apply(?,?)}";
		Connection conn = null;
		System.out.println("new email" + email);
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proCall);
			callableSt.setString(1, "info");
			callableSt.setString(2, email);
			ResultSet rst = callableSt.executeQuery();
			while (rst.next()) {
				Applicant st = new Applicant();
				System.out.println("name i printed" + rst.getString("name"));
				st.setStudentname(rst.getString("name"));
				st.setStudentemail(rst.getString("email"));
				st.setSkills(rst.getString("skills"));
				st.setAggregate(rst.getString("aggregate"));
				st.setBacklogs(rst.getString("backlogs"));
				st.setBranch(rst.getString("branch"));
				st.setContact(rst.getString("contact"));
				st.setPassingyear(rst.getString("passingYear"));
				st.setPost(rst.getString("position"));
				st.setPer10(rst.getString("per10"));
				st.setPer12(rst.getString("per12"));
				st.setPostid(rst.getString("Cid"));
				li.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void studentSelected(String semail, String postid) {
		// TODO Auto-generated method stub
		final String proccall = "{call Proc_Apply(?,?,?)}";
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proccall);
			callableSt.setString(1, "selected");
			callableSt.setString(2, semail);
			callableSt.setInt(3, Integer.parseInt(postid));
			callableSt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int checkAdmin(String email, String pass) {
		// TODO Auto-generated method stub
		int flag = 0;
		String password = new String("admin123");
		String email1 = new String("ronish@hotmail.com");

		System.out.println(pass);
		System.out.println(email);
		System.out.println(password + "password");
		System.out.println(email1 + "email1");

		if (email1.equalsIgnoreCase(email)) {
			System.out.println("in if");
			if (pass.equals(password))
				flag = 1;
			else
				flag = 2;
		} else
			flag = 0;
		return flag;

	}

	@Override
	public int checkemailverified(String email) {
		final String proccall = "{call Proc_Comp(?,?)}";
		Connection conn = null;
		int count=0;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proccall);
			callableSt.setString(1, "verifymail");
			callableSt.setString(2, email);
			ResultSet rst = callableSt.executeQuery();
			while (rst.next()) {
				count++;  
				}	
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("the number of rows output:"+count);
			return count;
	}

	@Override
	public int checkstudemailverified(String email) {
		// TODO Auto-generated method stub
		final String proccall = "{call Proc_App(?,?)}";
		Connection conn = null;
		int count=0;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = conn.prepareCall(proccall);
			callableSt.setString(1, "verifymail");
			callableSt.setString(2, email);
			ResultSet rst = callableSt.executeQuery();
			while (rst.next()) {
				count++;  
				}	
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("the number of rows output:"+count);
			return count;

	}

}