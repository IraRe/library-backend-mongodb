package com.prodyna.ted.library.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public class LibraryUser implements Serializable {

	private static final long serialVersionUID = -740327000132986294L;
	
	private UUID libraryUserID;
	private String username;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String telephoneNumber;
	private List<Book> lentBooks;
	
	public LibraryUser(String firstName, String secondName) {
		this.firstName = firstName;
		this.lastName = secondName;
		this.libraryUserID = UUID.randomUUID();
		this.username = firstName;
		this.dateOfBirth = new Date();
		this.telephoneNumber = "";
		this.lentBooks = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String secondName) {
		this.lastName = secondName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public UUID getLibraryUserID() {
		return libraryUserID;
	}

	public List<Book> getLentBooks() {
		return lentBooks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lentBooks == null) ? 0 : lentBooks.hashCode());
		result = prime * result
				+ ((libraryUserID == null) ? 0 : libraryUserID.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LibraryUser)) {
			return false;
		}
		LibraryUser other = (LibraryUser) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null) {
				return false;
			}
		} else if (!dateOfBirth.equals(other.dateOfBirth)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lentBooks == null) {
			if (other.lentBooks != null) {
				return false;
			}
		} else if (!lentBooks.equals(other.lentBooks)) {
			return false;
		}
		if (libraryUserID == null) {
			if (other.libraryUserID != null) {
				return false;
			}
		} else if (!libraryUserID.equals(other.libraryUserID)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null) {
				return false;
			}
		} else if (!telephoneNumber.equals(other.telephoneNumber)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LibraryUser [");
		if (libraryUserID != null) {
			builder.append("libraryUserID=");
			builder.append(libraryUserID);
			builder.append(", ");
		}
		if (username != null) {
			builder.append("username=");
			builder.append(username);
			builder.append(", ");
		}
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (lastName != null) {
			builder.append("secondName=");
			builder.append(lastName);
			builder.append(", ");
		}
		if (dateOfBirth != null) {
			builder.append("dateOfBirth=");
			builder.append(dateOfBirth);
			builder.append(", ");
		}
		if (telephoneNumber != null) {
			builder.append("telephoneNumber=");
			builder.append(telephoneNumber);
			builder.append(", ");
		}
		if (lentBooks != null) {
			builder.append("lentBooks=");
			builder.append(lentBooks);
		}
		builder.append("]");
		return builder.toString();
	}

}
