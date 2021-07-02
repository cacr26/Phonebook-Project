package phonebookproject.real;

import java.util.Scanner;

public class ProjectIndex {

	public static void main(String[] args) {
		//intializing a string named action that will be used as the expression for the switch statement
		String action = "";
		
		//Creating an instance of the Directory class
		Directory dir1 = new Directory();

		//Do-While loop allowing for main menu to keep recurring until user requests to exit
		do {

			System.out.println("**********************************************************");
			System.out.println("Which of the following actions would you like to perform?");
			System.out.println("- 1. Add a new entry :");
			System.out.println(
					"- 2. Search for an existing entry: \n" + "      -by first name\n  " + "    -by last name\n"
							+ "      -by full name\n" + "      -by city or state\n" + "      -by telephone number");
			System.out.println("-3. Search for existing entry by telephone number:");
			System.out.println("-4. Delete a record of a given telephone number:");
			System.out.println("-5. Update a record of a given telephone number:");
			System.out.println("-6. Show all existing entries:");
			System.out.println("-7. Exit");
			System.out.println("**********************************************************");
			System.out.println("Choose action by inputting corresponding number:");

			//Receiving input from user for which line item they will like to select
			Scanner input = new Scanner(System.in);
			action = input.nextLine();
			
			//Terminates loop and gives user a friendly message
			if (action.equals("7")) {
				System.out.println("****** Thank you! And have a great day! ******");
				break;
			} else {
				//if user wants to continue this is switch statement to handle user selections
				switch (action) {
				//User can add new Entry to phoneBook
				case "1":
					Scanner a = new Scanner(System.in);
					System.out.println("What is your full name, address, and"
							+ " phone number? (e.g. John Doe, 114 Market St, St Louis," + " MO, 63403, 6366435698:");
					String userEntry = a.nextLine();
					
					//Input string is turned into an array
					String[] userEntryArray = userEntry.split(",");
					ContactInfo newPerson = new ContactInfo(userEntryArray[0], userEntryArray[1], userEntryArray[2],
							userEntryArray[3], userEntryArray[4], userEntryArray[5]);
					
					//Calling the add Entry method in directory
					dir1.addEntry(newPerson);
					break;
					
				case "2":
					//Allowing user to search by full name, first name, last name, city or state
					System.out.println("Enter full name, last name, first name, city, or state abbreviation: ");
					Scanner b = new Scanner(System.in);
					
					//Input is now searchTerm
					String searchTerm = b.nextLine();
					
					//Calling the searchByName method in Directory
					dir1.searchByName(searchTerm);
					break;
					
				case "3":
					//Allowing user to search for an existing entry by a phone number
					System.out.println("Enter phoneNumber (i.e. 6366435698:)");
					Scanner c = new Scanner(System.in);
					
					//User input will placed in the variable searchNumber
					String searchNumber = c.nextLine();
					
					//The searchNumber is converted to all for to be converted in the format (XXX)-XXX-XXXX
					searchTerm = "(" + searchNumber.charAt(0) + searchNumber.charAt(1) + searchNumber.charAt(2) + ")-"
							+ searchNumber.charAt(3) + searchNumber.charAt(4) + searchNumber.charAt(5) + "-"
							+ searchNumber.charAt(6) + searchNumber.charAt(7) + searchNumber.charAt(8)
							+ searchNumber.charAt(9);
					
					//Calling the searchEntryByPhoneNumber method in Directory
					dir1.searchEntryByPhoneNumber(searchTerm);
					break;
				case "4":
					//Allowing user to search for an existing entry by a phone number
					System.out.println("Enter phoneNumber (i.e. 6366435698):");
					Scanner d = new Scanner(System.in);
					
					//User input will placed in the variable searchNumber
					String searchNumber2 = d.nextLine();
					
					//The searchNumber is converted to all for to be converted in the format (XXX)-XXX-XXXX
					searchTerm = "(" + searchNumber2.charAt(0) + searchNumber2.charAt(1) + searchNumber2.charAt(2)
							+ ")-" + searchNumber2.charAt(3) + searchNumber2.charAt(4) + searchNumber2.charAt(5) + "-"
							+ searchNumber2.charAt(6) + searchNumber2.charAt(7) + searchNumber2.charAt(8)
							+ searchNumber2.charAt(9);
					
					
					//Calling the deleteEntryByPhoneNumber method in Directory
					dir1.deleteEntryByPhoneNumber(searchTerm);
					break;
				case "5":
					//Prompting user to input phone number
					System.out.println("Enter the phone number of the entry needing to be updated (i.e. 6366435698):");
					
					//Obtaining phone number from user
					Scanner e = new Scanner(System.in);
					String searchNumber3 = e.nextLine();
					
					//Changing the inputed number into to display as (XXX)XXX-XXXX and placing it in the variable searchTerm
					searchTerm = "(" + searchNumber3.charAt(0) + searchNumber3.charAt(1) + searchNumber3.charAt(2)
							+ ")-" + searchNumber3.charAt(3) + searchNumber3.charAt(4) + searchNumber3.charAt(5) + "-"
							+ searchNumber3.charAt(6) + searchNumber3.charAt(7) + searchNumber3.charAt(8)
							+ searchNumber3.charAt(9);
					
					//Calling the Update method with the parameter of searchTerm
					dir1.updateEntryByPhoneNumber(searchTerm);
					break;
					
				case "6":
					//Calling a method to display all entries in ascending order
					dir1.displayAll();
					break;
					
				default:
					//User selected an invalid entry
					System.out.println("You selected an invalid entry. Try again!");
					break;
				}
			}

		} while (action != "7");
	}
}
