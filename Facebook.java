package p4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Facebook implements java.io.Serializable {

	// Fields for the Facebook Class
	ArrayList<FacebookUser> users = new ArrayList<>();

	// Empty parameter constructor
	public Facebook() {

	}

	// Add new user to the array list
	void addUser(FacebookUser newUser) {
		users.add(newUser);
		System.out.println("User added");
	}

	// Remove user from the array list and print message if user is not found
	void removeUser(FacebookUser formerUser) {
		if (users.contains(formerUser)) {
			users.remove(formerUser);
			System.out.println("User removed");
		} else {
			System.out.println("User not found");
		} // end if/else statement
	}

	// Method to copy and return a list of users
	public ArrayList<FacebookUser> getUsers() {
		ArrayList<FacebookUser> getUsers = new ArrayList<>();
		getUsers.addAll(users);
		return getUsers;
	}

	// Method to set facebook user
	public void setusers(ArrayList<FacebookUser> users) {
		this.users = users;
	}

	// Method to save user objects to a file
	public void saveFile() {
		try {
			FileOutputStream writeData = new FileOutputStream("userList.dat");
			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

			writeStream.writeObject(users);
			writeStream.flush();
			writeStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		} // end try/catch statement
	}

	// Method to retrieve the user object file
	@SuppressWarnings("unchecked")
	public void retrieveFile() {
		try {
			FileInputStream readData = new FileInputStream("userList.dat");
			ObjectInputStream readStream = new ObjectInputStream(readData);

			// @SuppressWarnings("unchecked")
			ArrayList<FacebookUser> users1 = (ArrayList<FacebookUser>) readStream.readObject();
			users = users1;
			readStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // end try/catch statement
	}

}// End class
