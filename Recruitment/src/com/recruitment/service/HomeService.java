package com.recruitment.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.recruitment.model.Applicant;
import com.recruitment.model.Company;
import com.recruitment.model.Recruiter;
import com.recruitment.model.Student;

public interface HomeService{

	void addStudent(Student s);

	int checkStudent(String email, String pass);

	Student update(Student s);

	void updateStudent(Student s1);

	void addCompany(Company c);

	ArrayList<Student> stVerify();

	int checkCompany(String email, String pass);

	ArrayList<Company> cmpVerify();

	void cmpVerified(String email);

	void stVerified(String email);

	void addDrive(Recruiter rec);

	Company viewCompProfile(String email);

	void updateCompany(Company c1);

	ArrayList<Recruiter> deriveVerify();

	void deriveVerified(String email);

	ArrayList<Recruiter> ComingDerivesInfo();

	void addApplicant(String semail, String cid);

	ArrayList<Applicant> viewApplications(String email);

	void studentSelected(String semail, String postid);

	int checkAdmin(String email, String pass);

	void forgotpass(String email);

	int checkemailverified(String email);

	
}
