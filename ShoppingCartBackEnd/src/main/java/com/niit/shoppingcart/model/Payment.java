package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

	@Entity
	@Table
	@Component

	public class Payment {

		@Id
		private String email_id;
		private String first_name;
		private String last_name;
		private String address;
		private String city;
		private String state;
		private String postal_code;
		private String mobile_number;
		
		public String getEmail_id() {
			return email_id;
		}
		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPostal_code() {
			return postal_code;
		}
		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
		}
		public String getMobile_number() {
			return mobile_number;
		}
		public void setMobile_number(String mobile_number) {
			this.mobile_number = mobile_number;
		}
				
}
