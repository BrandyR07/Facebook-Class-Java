package p4;

import java.io.Serializable;
import java.util.Objects;

public abstract class UserAccount implements Comparable<UserAccount>, Serializable {

	// Define variables for class
	private String username;
	private String password;
	private boolean active;

	// Initializing constructor for class
	public UserAccount() {

		username = " ";
		password = " ";
		active = false;
	}

	// Override constructor with parameters
	public UserAccount(String username1, String password1) {

		this.username = username1;
		this.password = password1;
		this.active = true;

	}

	// Compareto for camparable interface in Facebook class
	@Override
	public int compareTo(UserAccount user) {
		return this.username.compareToIgnoreCase(user.username);
	}

	// Get username for account
	protected String getUsername() {
		return username;
	}

	// Set username for user account
	public void setUsername(String username) {
		this.username = username;
	}

	// Get the password for the userAccount
	public String getPassword() {
		return password;
	}

	// Set the password for account
	public void setPassword(String password) {
		this.password = password;
	}

	// Method to check if password is correct
	public boolean checkPassword(String password1) {

		if (password.equals(password1)) {
			return true;
		} else
			return false;
	}

	// Method to deactivate an account
	public void deactivateAccount() {

		if (active) {
			active = false;
		} else {
			System.out.println("Account for " + username + " is already inactive");
		}
	}

	// Abstract class for password help
	public abstract void getPasswordHelp();

	// To string method to print string of username
	@Override
	public String toString() {
		return "User account username is " + username;
	}

	// Hash code and equals methods to determine if accounts have the same username
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	// Equals method to determine if username is the same as another
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		return Objects.equals(username, other.username);
	}

}
