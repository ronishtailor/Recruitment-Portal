package com.recruitment.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.precise.mail.SendMail;
import com.recruitment.model.Applicant;
import com.recruitment.model.Company;
import com.recruitment.model.Recruiter;
import com.recruitment.model.SessionBean;
import com.recruitment.model.Student;
import com.recruitment.service.HomeService;

@Controller
public class HomeController {
@Autowired
HomeService hs;

@RequestMapping(value="/")
public String home()
{
	return "index";
}
@RequestMapping(value="firstlogin")
public String firstlogin()
{
	return "login";
}

@RequestMapping(value="login")
public String login(HttpServletRequest req,HttpSession session)
{	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	req.setAttribute("email",email);
	int i=hs.checkStudent(email,pass);
	if(i==0)
	{
		req.setAttribute("msg","email id not valid");
		return "login";
	}
	else if(i==2)
	{
		req.setAttribute("msg","password not valid");
		return "login";
	}
	else
	{   SessionBean s=new SessionBean();
		s.setEmail(email);
		session.setAttribute("sessionbean",s);
		req.setAttribute("msg","password valid");
		req.setAttribute("email",email);
		return "showStOption"; 
	}
}
@RequestMapping(value="addstudent")
public String addStudent(HttpServletRequest req,Student s,HttpSession session)
{	SessionBean sb=(SessionBean)session.getAttribute("sessionbean");
	hs.addStudent(s);
	return "login";
}
@RequestMapping(value="addcompany")
public String addCompany(HttpServletRequest req,Company c)
{
	hs.addCompany(c);
	return "companyLogin";
}
@RequestMapping(value="register")
public String register(HttpServletRequest req)
{   
	return "register";
}
@RequestMapping(value="studProfile")
public String studprofile(HttpServletRequest req,Student s,HttpSession session)
{   SessionBean sb=(SessionBean)session.getAttribute("sessionbean");
	if(sb!=null)
	{	String email=req.getParameter("email");
	s.setEmail(email);
	Student s1=hs.update(s);
	req.setAttribute("name", s1.getName());
	req.setAttribute("email",s1.getEmail());
	req.setAttribute("password",s1.getPassword());
	req.setAttribute("rollno",s1.getRollno());
	req.setAttribute("aggregate",s1.getAggregate());
	req.setAttribute("back",s1.getBack());
	req.setAttribute("per10",s1.getPer10());
	req.setAttribute("per12",s1.getPer12());
	req.setAttribute("branch",s1.getBranch());
	req.setAttribute("dob",s1.getDob());
	req.setAttribute("fname",s1.getFatherName());
	req.setAttribute("mname",s1.getMotherName());
	req.setAttribute("skills",s1.getSkills());
	req.setAttribute("passingyear", s1.getPassingYear());
	req.setAttribute("address",s1.getAddress());
	req.setAttribute("contact", s1.getContact());
	return "studProfile";
	}
	else
		return "index";
}
@RequestMapping(value="companyLogin")
public String companylogin(HttpServletRequest req)
{	
		return "companyLogin";
}
@RequestMapping(value="companyRegister")
public String companyregister()
{	
	return "companyRegister";
}
@RequestMapping(value="showStOption")
public String showstoption(HttpSession session)
{	SessionBean sb=(SessionBean)session.getAttribute("sessionbean");
if(sb!=null)
{
	return "showStOption";
}
else
	return "index";
}
@RequestMapping(value="viewCompany")
public String viewcompany()
{
	return "viewCompany";
}
@RequestMapping(value="studProfilereadonly")
public String studprofilereadonly(HttpServletRequest req,Student s,HttpSession session)
{   SessionBean sb=(SessionBean)session.getAttribute("sessionbean");
	if(sb!=null)
	{	String email=req.getParameter("email");
	s.setEmail(email);
	Student s1=hs.update(s);
	req.setAttribute("name", s1.getName());
	req.setAttribute("email",s1.getEmail());
	req.setAttribute("password",s1.getPassword());
	req.setAttribute("rollno",s1.getRollno());
	req.setAttribute("aggregate",s1.getAggregate());
	req.setAttribute("back",s1.getBack());
	req.setAttribute("per10",s1.getPer10());
	req.setAttribute("per12",s1.getPer12());
	req.setAttribute("branch",s1.getBranch());
	req.setAttribute("dob",s1.getDob());
	req.setAttribute("fname",s1.getFatherName());
	req.setAttribute("mname",s1.getMotherName());
	req.setAttribute("skills",s1.getSkills());
	req.setAttribute("passingyear", s1.getPassingYear());
	req.setAttribute("address",s1.getAddress());
	req.setAttribute("contact", s1.getContact());
	return "studProfilereadonly";
	}
	else
		return "index";
}
@RequestMapping(value="updatestudentpage")
public String updatestudentpage(HttpServletRequest req,Student s1)
{ 
	return "studProfile";
}

@RequestMapping(value="updatestudent")
public String updatestudent(HttpServletRequest req,Student s1)
{ req.setAttribute("email",s1.getEmail());
  hs.updateStudent(s1);
  return "showStOption";
}
@RequestMapping(value="adminLogin")
public String adminlogin()
{
	return "adminLogin";
}
@RequestMapping(value="adminOption")
public String adminoption()
{
	return "adminOption";
}
@RequestMapping(value="cmpVerify")
public String cmpverify(HttpServletRequest req)
{	ArrayList<Company> cmp=hs.cmpVerify();
	req.setAttribute("cmplist",cmp);
	return "cmpVerify";
}
@RequestMapping(value="stVerify")
public String stverify(HttpServletRequest req)
{	
	ArrayList<Student> s=hs.stVerify();
	req.setAttribute("list", s);
	return "stVerify";
}
@RequestMapping(value="cmpVerified")
public String cmpVerified(HttpServletRequest req)
{	String email=req.getParameter("email");
	hs.cmpVerified(email);
	return "redirect:cmpVerify";
}
@RequestMapping(value="stVerified")
public String stVerified(HttpServletRequest req)
{	String email=req.getParameter("email");
	hs.stVerified(email);
	return "redirect:stVerify";
}
@RequestMapping(value="checkadmin")
public String checkAdmin(HttpServletRequest req)
{	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	req.setAttribute("email",email);
	int i=hs.checkAdmin(email,pass);
	System.out.println(i);
	if(i==0)
	{
		req.setAttribute("msg","email id not valid");
		return "adminLogin";
	}
	else if(i==2)
	{
		req.setAttribute("msg","password not valid");
		return "adminLogin";
	}
	else
	{
		req.setAttribute("msg","password valid");
		req.setAttribute("email",email);
		return "adminOption"; 
	}
}
@RequestMapping(value="showCompanyOption")
public String showcompanyoption(HttpServletRequest req)
{	String email=req.getParameter("email");
	req.setAttribute("email",email);
	return "showCompanyOption";
}
@RequestMapping(value="postderive")
public String postderive(HttpSession session,HttpServletRequest req)
{	SessionBean sb=(SessionBean)session.getAttribute("sessionbean");
String email=req.getParameter("cemail");
int x=hs.checkemailverified(email);
if(sb!=null )
{
	if(x==1)
	return "postDrive";
	else
	return "showCompanyOption";
}

else
	return "index";
}
@RequestMapping(value="post")
public String post(HttpServletRequest req,Recruiter rec)
{
 hs.addDrive(rec);	
return "showCompanyOption";
}
@RequestMapping(value="cmpProfile")
public String cmpprofile(HttpServletRequest req,HttpSession session)
{	SessionBean sb=(SessionBean)session.getAttribute("sessionbean");
if(sb!=null)
{
	String email=req.getParameter("email");
	Company c=hs.viewCompProfile(email);
	req.setAttribute("cname",c.getName());
	req.setAttribute("cemail",c.getEmail());
	req.setAttribute("clocation",c.getLocation());
	req.setAttribute("cpass", c.getPass());
	req.setAttribute("cwebsite", c.getWebsite());
	req.setAttribute("ccontact", c.getContact());
	return "cmpProfile";

}
else
	return "index";

	}
@RequestMapping(value="updateCompanyDetails")
public String updatecompanydetails(HttpServletRequest req,Company c1)
{
	hs.updateCompany(c1);
	return "showCompanyOption";
}
@RequestMapping(value="companycheck")
public String companycheck(HttpServletRequest req,HttpSession session)
{	
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		req.setAttribute("email",email);
		int i=hs.checkCompany(email,pass);
		System.out.println(i);
		if(i==0)
		{
			req.setAttribute("msg","email id not valid");
			return "companyLogin";
		}
		else if(i==2)
		{
			req.setAttribute("msg","password not valid");
			return "companyLogin";
		}
		else
		{ SessionBean s=new SessionBean();
		  s.setEmail(email);
		  session.setAttribute("sessionbean",s);		
			req.setAttribute("msg","password valid");
			req.setAttribute("email",email);
			return "showCompanyOption"; 
		}
}
@RequestMapping(value="deriveVerify")
public String deriveVerify(HttpServletRequest req)
{
	ArrayList<Recruiter> r=hs.deriveVerify();
	req.setAttribute("list", r);
	return "deriveVerify";	
}
@RequestMapping(value="deriveVerified")
public String deriveVerified(HttpServletRequest req)
{
	String email=req.getParameter("email");
	hs.deriveVerified(email);
	return "redirect:deriveVerify";
}
@RequestMapping(value="comingdrives")
public String comingdrives(HttpServletRequest req)
{
	String email=req.getParameter("semail");
	req.setAttribute("semail",email);
	ArrayList<Recruiter> r=hs.ComingDerivesInfo();
	
	req.setAttribute("list", r);
	return "comingDrives";
}
@RequestMapping(value="Apply")
public String apply(HttpServletRequest req)
{
	String semail=req.getParameter("semail");
	String cid=req.getParameter("cid");
	hs.addApplicant(semail,cid);
	return "comingDrives";
}
@RequestMapping(value="viewApplications")
public String viewapplications(HttpServletRequest req,HttpSession session)
{	SessionBean sb=(SessionBean)session.getAttribute("sessionbean");
String email=req.getParameter("cemail");   
int x=hs.checkemailverified(email);
if(sb!=null)
{	if(x==1)
	{
	ArrayList<Applicant> list=hs.viewApplications(email);
	System.out.println(list);
	req.setAttribute("list", list);
	return "applicants";
	}
	else
	return "showCompanyOption";
	
}
else
	return "index";
}
@RequestMapping(value="selected")
public String selected(HttpServletRequest req)
{
	String semail=req.getParameter("studentemail");
	String postid=req.getParameter("postid");
	hs.studentSelected(semail,postid);
	return "redirect:applicants";
}
@RequestMapping(value="viewDrives")
public String viewdrives(HttpServletRequest req)
{	
	ArrayList<Recruiter> driveslist=hs.ComingDerivesInfo();
	req.setAttribute("driveslist", driveslist);

	return "viewdrives";
}
@RequestMapping(value="about")
public String about()
{
	return "about";
}
@RequestMapping(value="logout")
public String logout(HttpSession session)
{
	session.invalidate();
	return "index";
}
@RequestMapping(value="forgotpass")
public String forgotpass(HttpServletRequest req)
{
  return "forgotpassapplicant";
}
@RequestMapping(value="otpverify")
public String otpverify(HttpServletRequest req)
{
  return "otpverify";
}
@RequestMapping(value="otpverified")
public String otpverified(HttpServletRequest req)
{ String email=req.getParameter("email");
  SendMail m=new SendMail();
  m.sendMail("hey",email,"regarding otp");
  //hs.forgotpass(email);
  return "";
}
@RequestMapping(value="companylogout")
public String companylogout(HttpSession session)
{
	session.invalidate();
	return "index";
}
@RequestMapping(value="forgotcompany")
public String forgotcompany()
{
  return "forgotpasscompany";	
}
@RequestMapping(value="compotpverify")
public String compotpverify()
{
	return "compotpverify";
}
@RequestMapping(value="compotpverified")
public String compotpverified()
{
return "";	
}

}