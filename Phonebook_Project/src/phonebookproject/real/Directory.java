package phonebookproject.real;

import java.util.Arrays;
import java.util.Scanner;

public class Directory {

	ContactInfo[] phoneBook = new ContactInfo[0];

	// Method to add entries
	public void addEntry(ContactInfo newPerson) {

		// Creates temporary array
		ContactInfo[] tempArray = new ContactInfo[phoneBook.length + 1];

		for (int i = 0; i < phoneBook.length; i++) {
			// if(book.length > 0)
			tempArray[i] = phoneBook[i];
		}
		// adds the person to the end of the tempArray
		tempArray[tempArray.length - 1] = newPerson;
		// resets the original array to the new one
		phoneBook = tempArray;
	}

	// Method to search through entries name(full/first/last)/city/state
	public void searchByName(String searchTerm) {

		// Create new array to store first names
		String[] orderedArray = new String[phoneBook.length];

		for (int i = 0; i < phoneBook.length; i++) {
			orderedArray[i] = phoneBook[i].getFullName();
		}

		// Sort array of first names
		Arrays.sort(orderedArray);

		// Search through and return entries that match search in asc order
		for (int j = 0; j < orderedArray.length; j++) {
			for (int k = 0; k < phoneBook.length; k++) {
				if (orderedArray[j] == phoneBook[k].getFullName()) {
					if (phoneBook[k].toString().contains(searchTerm)) {
						System.out.println(phoneBook[k]);
					} else {
						System.out.println("No Matches Found!");
					}
				}
			}
		}
		// Prompting user to allow for a chance for user to see requested data
		// Enter will allow for main menu to return
		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();

	}

	// Method to allow all entries to be displayed
	public void displayAll() {
		if (phoneBook.length != 0) {
		// Create new array to store first names
		String[] orderedArray = new String[phoneBook.length];

		for (int i = 0; i < phoneBook.length; i++) {
			orderedArray[i] = phoneBook[i].getFullName();
		}

		// Sort array of first names
		Arrays.sort(orderedArray);

		// Print name of newly ordered array
		for (int j = 0; j < orderedArray.length; j++) {
			for (int k = 0; k < phoneBook.length; k++) {
				if (orderedArray[j] == phoneBook[k].getFullName()) {
					System.out.println(phoneBook[k]);
				}
			}
		}
		}else {
			System.out.println("No Entries found!");
		}
		// Prompting user to allow for a chance for user to see requested data
		// Enter will allow for main menu to return
		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();

	}

	// Method to allow entry to be found by phone number
	public void searchEntryByPhoneNumber(String searchTerm) {
		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i].toString().contains(searchTerm)) {
				System.out.println(phoneBook[i]);
			} else {
				System.out.println("No Matches Found!");
			}
		}
		// Prompting user to allow for a chance for user to see requested data
		// Enter will allow for main menu to return
		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();
	}

	// Method to allow user to delete entry by phone number
	public void deleteEntryByPhoneNumber(String searchTerm) {
		// Creates temporary array
		ContactInfo[] tempArray = new ContactInfo[phoneBook.length - 1];

		// set counter integer for temporary array
		int x = 0;

		for (int y = 0; y < phoneBook.length; y++) {
			if (phoneBook[y].toString().contains(searchTerm)) {

				for (int i = 0; i < phoneBook.length; i++) {
					if (!phoneBook[i].toString().contains(searchTerm)) {
						tempArray[x] = phoneBook[i];
						x++;
					}
				} // set current array to equal the temporary array
				phoneBook = tempArray;
			} else {
				System.out.println("No Matches Found!");
			}

		}

	}

	// Method to allow user to update entry by phone number
	public void updateEntryByPhoneNumber(String searchTerm) {

		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i].toString().contains(searchTerm)) {

				System.out.println("***********************************\n" + "What do you want to update? \n"
						+ "-1. Full name\n" + "-2. Street address\n" + "-3. City\n" + "-4. State\n" + "-5. Zip code\n"
						+ "-6. Phone number\n" + "-7. Finished updating\n" + "***********************************");
				Scanner newInput = new Scanner(System.in);
				String updateNeeded = newInput.nextLine();

				switch (updateNeeded) {
				case "1":
					System.out.println("Enter full name:");
					String a = newInput.nextLine();
					phoneBook[i].setFullName(a);
					break;
				case "2":
					System.out.println("Enter street address:");
					String b = newInput.nextLine();
					phoneBook[i].setStreetAddress(b);
					break;
				case "3":
					System.out.println("Enter city:");
					String c = newInput.nextLine();
					phoneBook[i].setCityName(c);
					break;
				case "4":
					System.out.println("Enter state (i.e. MO):");
					String d = newInput.nextLine();
					phoneBook[i].setStateName(d);
					break;
				case "5":
					System.out.println("Enter zip code:");
					String e = newInput.nextLine();
					phoneBook[i].setZipCode(e);
					break;
				case "6":
					System.out.println("Enter phone number:");
					String f = newInput.nextLine();
					phoneBook[i].setPhoneNumber(f);
					break;
				default:
					System.out.println("Invalid entry. Please select again");
					break;
				}

			} else {
				System.out.println("Phone number not found");
			}
		}
		// Prompting user to allow for a chance for user to see requested data
		// Enter will allow for main menu to return
		System.out.println("Press enter to return main menu:");
		Scanner input = new Scanner(System.in);
		String returnMainMenu = input.nextLine();
	}
}