package com.recruitment.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.dao.HomeDao;
import com.recruitment.model.Applicant;
import com.recruitment.model.Company;
import com.recruitment.model.Recruiter;
import com.recruitment.model.Student;
@Service

public class HomeServiceImpl implements HomeService {
	@Autowired
	HomeDao hs;
	
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		hs.addStudent(s);
	}

	@Override
	public int checkStudent(String email, String pass) {
		// TODO Auto-generated method stub
		return hs.checkStudent(email,pass);
	}

	@Override
	public Student update(Student s) {
		// TODO Auto-generated method stub
		return hs.update(s);
	}

	@Override
	public void updateStudent(Student s1) {
		// TODO Auto-generated method stub
		hs.updateStudent(s1);
		
	}

	@Override
	public void addCompany(Company c) {
		// TODO Auto-generated method stub
		hs.addCompany(c);
	}

	@Override
	public ArrayList<Student> stVerify() {
		// TODO Auto-generated method stub
		return hs.stVerify();
	}

	@Override
	public int checkCompany(String email, String pass) {
		// TODO Auto-generated method stub
		
		return hs.checkCompany(email,pass);
	}

	@Override
	public ArrayList<Company> cmpVerify() {
		// TODO Auto-generated method stub
		return hs.cmpVerify();
	}

	@Override
	public void cmpVerified(String email) {
		// TODO Auto-generated method stub
		hs.cmpVerified(email);
	}

	@Override
	public void stVerified(String email) {
		// TODO Auto-generated method stub
		hs.stVerified(email);
	}

	@Override
	public void addDrive(Recruiter rec) {
		// TODO Auto-generated method stub
		hs.addDrive(rec);
	}

	@Override
	public Company viewCompProfile(String email) {
		// TODO Auto-generated method stub
		return hs.viewCompProfile(email);
	}

	@Override
	public void updateCompany(Company c1) {
		// TODO Auto-generated method stub
		hs.updateCompany(c1);
	}

	@Override
	public ArrayList<Recruiter> deriveVerify() {
		// TODO Auto-generated method stub
	return hs.deriveVerify();
	}

	@Override
	public void deriveVerified(String email) {
		// TODO Auto-generated method stub
		hs.deriveVerified(email);
	}

	@Override
	public ArrayList<Recruiter> ComingDerivesInfo() {
		// TODO Auto-generated method stub
		return hs.ComingDerivesInfo();
	}

	@Override
	public void addApplicant(String semail, String cid) {
		// TODO Auto-generated method stub
		hs.addApplicant(semail,cid);
	}

	@Override
	public ArrayList<Applicant> viewApplications(String email) {
		// TODO Auto-generated method stub
		return hs.viewApplications(email);
	}

	@Override
	public void studentSelected(String semail, String postid) {
		// TODO Auto-generated method stub
		hs.studentSelected(semail,postid);
	}

	@Override
	public int checkAdmin(String email, String pass) {
		// TODO Auto-generated method stub
		return hs.checkAdmin(email,pass);
	}

	@Override
	public void forgotpass(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkemailverified(String email) {
		return hs.checkemailverified(email);
	}

	@Override
	public int checkstudemailverified(String email) {
		// 
		return hs.checkstudemailverified(email);
	}

	
}
