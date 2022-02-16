package p4;

import java.util.Scanner;

public class FacebookDriver {
	// Declare Facebook instance
	static Facebook userArray = new Facebook();
	static FacebookUser user = new FacebookUser();
	static FacebookUser friend = new FacebookUser();

	public static void main(String[] args) {

		// Declare variables for the driver
		int choice = 0;
		String userName;
		String password;
		String passwordHint;
		String deleteUser;
		String addFriend;
		String deleteFriend;

		// Create Scanner Object
		Scanner input = new Scanner(System.in);

		// Method to retrieve file with user objects
		userArray.retrieveFile();

		// Do while loop for the menu
		do {
			System.out.println("Main Menu");
			System.out.println("1. List Users");
			System.out.println("2. Add User");
			System.out.println("3. Delete User");
			System.out.println("4. Get Password Hint");
			System.out.println("5. Friend Someone");
			System.out.println("6. De-Friend Someone");
			System.out.println("7. List Friends");
			System.out.println("8. Recommend New Friends");
			System.out.println("9. Quit");
			System.out.println("Please enter your selection: ");

			// Get user input
			choice = input.nextInt();

			// While loop to check choice in range
			while (choice < 1 || choice > 9) {
				System.out.println("Please enter a valid menu option: ");
				choice = input.nextInt();
			} // end nested while loop

			// Clear scanner
			input.nextLine();

			// Switch statement for menu items
			switch (choice) {
			// List users
			case 1: {
				System.out.println("Users List" + userArray.getUsers());
				break;
			}
			// Add a user
			case 2: {
				System.out.println("Enter User Name: ");
				userName = input.nextLine();
				user = findUser(userName);
				// Check user in user array list
				if (userArray.users.contains(user)) {
					System.out.println("User already in user list");
					break;
				} // end if statement
				System.out.println("Enter a Password: ");
				password = input.nextLine();
				System.out.println("Enter a password hint: ");
				passwordHint = input.nextLine();
				user = new FacebookUser(userName, password, passwordHint);
				userArray.addUser(user);
				break;
			}
			// Delete a user
			case 3: {
				System.out.println("Enter the username you want to delete: ");
				deleteUser = input.nextLine();
				user = findUser(deleteUser);
				// Check user in user array list
				if (userArray.users.contains(user)) {
					System.out.println("Please enter users password: ");
					password = input.nextLine();
					if (user.checkPassword(password)) {
						userArray.removeUser(user);
					} else {
						System.out.println("Invalid password");
					} // end nested if/else statement
				} else {
					System.out.println("User not in user list");
				} // end if/else statement
				break;
			}
			// Get password help
			case 4: {
				System.out.println("Enter the username for password help: ");
				userName = input.nextLine();
				user = findUser(userName);
				if (userArray.users.contains(user)) {
					user.getPasswordHelp();
				} else {
					System.out.println("User not in user list");
				}
				break;
			}
			case 5: {
				System.out.println("Enter User Name: ");
				userName = input.nextLine();
				user = findUser(userName);
				// Check user in user array list
				if (userArray.users.contains(user)) {
					System.out.println("Please enter users password: ");
					password = input.nextLine();
					if (user.checkPassword(password)) {
						System.out.println("Enter the name of the friend you want to add: ");
						addFriend = input.nextLine();
						FacebookUser friendAdd = findUser(addFriend);
						if (user.friends.contains(friendAdd)) {
							System.out.println("Friend already in friend list");
						} else {
							user.friend(friendAdd);
							// System.out.println("Invalid password");
						} // end second nested if/else statement
					} else {
						System.out.println("Invalid pasword");
					} // end first nested if/else statement

				} else {
					System.out.println("Name entered is not a Facebook User");
				} // end if/else statement
				break;
			}
			case 6: {
				System.out.println("Enter User Name: ");
				userName = input.nextLine();
				user = findUser(userName);
				// Check user in user array list
				if (userArray.users.contains(user)) {
					System.out.println("Please enter users password: ");
					password = input.nextLine();
					if (user.checkPassword(password)) {
						System.out.println("Enter the name of the friend you want to defriend: ");
						deleteFriend = input.nextLine();
						FacebookUser friendDelete = findUser(deleteFriend);
						if (user.friends.contains(friendDelete)) {
							user.defriend(friendDelete);
						} else {
							System.out.println("Friend not in friend list");
							// System.out.println("Invalid password");
						} // end second nested if/else statement
					} else {
						System.out.println("Invalid pasword");
					} // end first nested if/else statement

				} else {
					System.out.println("Name entered is not a Facebook User");
				} // end if/else statement
				break;
			}
			case 7: {
				System.out.println("Enter User Name: ");
				userName = input.nextLine();
				user = findUser(userName);
				// Check user in user array list
				if (userArray.users.contains(user)) {
					System.out.println("Please enter users password: ");
					password = input.nextLine();
					if (user.checkPassword(password)) {
						System.out.println("Friends are " + user.getFriends()); 
					} else {
						System.out.println("Invalid pasword");
					} // end first nested if/else statement
				} else {
					System.out.println("Name entered is not a Facebook User");
				} // end if/else statement
				break;
			}

			}// End switch statement

			// Add space between executions
			System.out.println();

		} while (choice != 9);// end do/while loop

		// Method to save users to file at end of the program
		userArray.saveFile();

		// If statement to end the program if choose to quit
		if (choice == 9) {
			System.out.println("Goodbye!");
		}

		// Close scanner object
		input.close();

	}// End main

	// Method to return object for user in methods for the driver
	public static FacebookUser findUser(String name) {

		FacebookUser found = null;

		for (FacebookUser checkName : userArray.getUsers()) {

			if (checkName.getObjName(name)) {
				found = checkName;
				break;
			}

		}
		return found;
	}// end method to check username

}// end class body
