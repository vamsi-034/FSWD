package com.example.Miniproject.profile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		int id;
		
		@Column(columnDefinition = "Text")
		String about;
		
		String personal;
		
		String Fname;
		String Lname;
		long Phone;
		String email;
		
		@Column(columnDefinition = "Text")
		String Education;
		
		String certificatename;
		
		String certificateimage;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAbout() {
			return about;
		}

		public void setAbout(String about) {
			this.about = about;
		}

		public String getPersonal() {
			return personal;
		}

		public void setPersonal(String personal) {
			this.personal = personal;
		}

		public String getFname() {
			return Fname;
		}

		public void setFname(String fname) {
			Fname = fname;
		}

		public String getLname() {
			return Lname;
		}

		public void setLname(String lname) {
			Lname = lname;
		}

		public long getPhone() {
			return Phone;
		}

		public void setPhone(long phone) {
			Phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEducation() {
			return Education;
		}

		public void setEducation(String education) {
			Education = education;
		}

		public String getCertificatename() {
			return certificatename;
		}

		public void setCertificatename(String certificatename) {
			this.certificatename = certificatename;
		}

		public String getCertificateimage() {
			return certificateimage;
		}

		public void setCertificateimage(String certificateimage) {
			this.certificateimage = certificateimage;
		}

		public Profile(int id, String about, String personal, String fname, String lname, long phone, String email,
				String education, String certificatename, String certificateimage) {
			super();
			this.id = id;
			this.about = about;
			this.personal = personal;
			Fname = fname;
			Lname = lname;
			Phone = phone;
			email = email;
			Education = education;
			this.certificatename = certificatename;
			this.certificateimage = certificateimage;
		}

		public Profile() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
