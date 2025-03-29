package com.tps.web.staroffice.entity;


public class ContactsEntity {

    private String contactsFollower;
    private String contactsFollowee;

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
	@Override
	public String toString() {
		return "ContactsEntity [contactsFollower=" + contactsFollower
				+ ", contactsFollowee=" + contactsFollowee + "]";
	}

}
