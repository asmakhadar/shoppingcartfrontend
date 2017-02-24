package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

	
	@Entity
	@Table
	@Component

	public class Billing {

		@Id
		private String email_id;
		private String debit_card_number;
		private String card_cvv;
		private String expiration_month;
		private String expiration_year;
		private String name;
		
		public String getEmail_id() {
			return email_id;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		public String getDebit_card_number() {
			return debit_card_number;
		}
		public void setDebit_card_number(String debit_card_number) {
			this.debit_card_number = debit_card_number;
		}
		public String getCard_cvv() {
			return card_cvv;
		}
		public void setCard_cvv(String card_cvv) {
			this.card_cvv = card_cvv;
		}

		public String getExpiration_month() {
			return expiration_month;
		}

		public void setExpiration_month(String expiration_month) {
			this.expiration_month = expiration_month;
		}

		public String getExpiration_year() {
			return expiration_year;
		}

		public void setExpiration_year(String expiration_year) {
			this.expiration_year = expiration_year;
		}
	
	
	
}
