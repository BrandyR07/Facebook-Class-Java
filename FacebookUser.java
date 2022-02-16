package p4;

import java.util.ArrayList;

public class FacebookUser extends UserAccount {

	//Fields for the FacebookUser Class
	private String passwordHint;
	ArrayList<FacebookUser> friends;

	//Empty parameter constructor
	public FacebookUser() {
		super();
		passwordHint = " ";
		friends = new ArrayList<>();
	}

	//Constructor with parameters
	public FacebookUser(String userName, String password, String passwordHint) {

		super(userName, password); 
		this.passwordHint = passwordHint;
		friends = new ArrayList<>();
	}

	@Override
	// Print username
	public String toString() {
		return getUsername();
	}

	//Method to get the username from user input
	public boolean getObjName(String enteredName) {

		return enteredName.equals(getUsername());
	}

	//Method to set password hint
	void setPasswordHint(String hint) {

		this.passwordHint = hint;
	}

	//To display message for get password help message
	@Override
	public void getPasswordHelp() {

		System.out.println("Your password hint is " + passwordHint);

	}

	// Add new friend to the array list and messages if friend already in list or is not a user
	void friend(FacebookUser newFriend) {

		if (friends.contains(newFriend)) {

			System.out.println("Friend already in friends list");

		} else if (newFriend == null) {

			System.out.println("Friend not found in user list");
		}

		else {

			friends.add(newFriend);
			System.out.println("Friend added");
		}
	}

	// Remove friend from the array list and print message if friend is not found
	void defriend(FacebookUser formerFriend) {

		if (friends.contains(formerFriend)) {
			friends.remove(formerFriend);
			System.out.println("Friend removed");
		} else {
			System.out.println("Friend not found");
		}

	}

	// Method to copy and return a list of friends for a facebook user
	ArrayList<FacebookUser> getFriends() {

		ArrayList<FacebookUser> getFriends = new ArrayList<>();
		getFriends.addAll(friends);

		return getFriends;

	}

	// Method to set facebook user friends
	public void setFriends(ArrayList<FacebookUser> friends) {
		this.friends = friends;
	}

}
