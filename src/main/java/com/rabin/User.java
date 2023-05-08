package com.rabin;

public class User {
	String username;
	String birthday;
	String gender;
	String occupation;
	String address;
	
	User(String name, String bd, String gen, String occ, String add) {
		this.username = name;
		this.birthday = bd;
		this.gender = gen;
		this.occupation = occ;
		this.address = add;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", birthday=" + birthday + ", gender=" + gender + ", occupation="
				+ occupation + ", address=" + address + "]";
	}
	
}
