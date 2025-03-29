package com.tps.web.staroffice.dto;

public class ContactsDto {

    private String contactsFollower;
    private String contactsFollowee;

    private Boolean userContact;

	public String getContactsFollower() {
		return contactsFollower;
	}
	public void setContactsFollower(String contactsFollower) {
		this.contactsFollower = contactsFollower;
	}
	public String getContactsFollowee() {
		return contactsFollowee;
	}
	public void setContactsFollowee(String contactsFollowee) {
		this.contactsFollowee = contactsFollowee;
	}
	public Boolean isUserContact() {
		return userContact;
	}
	public void setUserContact(Boolean userContact) {
		this.userContact = userContact;
	}
	@Override
	public String toString() {
		return "ContactsDto [contactsFollower=" + contactsFollower
				+ ", contactsFollowee=" + contactsFollowee + ", userContact="
				+ userContact + "]";
	}
}