import java.nio.file.*;
import java.io.*;
import static java.nio.file.AccessMode.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.*;
import java.lang.Thread;

public class cs {
	public static void main(String[] args) {
		Scanner strInput = new Scanner(System.in);
		String options, choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			clearscreen();
			System.out.println("\n\t                                Students Information System ");
			System.out.print(
					"\t_____________________________________________________________________________________________\n");
			System.out.println(
					"\t|\t\t\t\t\t\t\t\t\t\t\t    |\n\t|\t\t\tOPTIONS: \t\t\t\t\t\t\t    | \n \t|\t\t\t\t\t\t\t\t\t\t\t    |");
			System.out.println("\t|\t\t\t1. Add new Student\t\t\t\t\t\t    |");
			System.out.println("\t|\t\t\t2. Display Student's Record\t\t\t\t\t    |");
			System.out.println("\t|\t\t\t3. Search Record\t\t\t\t\t\t    |");
			System.out.println("\t|\t\t\t4. Update Student's Record\t\t\t\t\t    |");
			System.out.println("\t|\t\t\t5. Delete Student's Record\t\t\t\t\t    |");
			System.out.println("\t|\t\t\t6. Exit \t\t\t\t\t\t\t    |");
			System.out.println("\t|\t\t\t        \t\t\t\t\t\t\t    |");
			System.out.print(
					"\t|___________________________________________________________________________________________|\n\n");
			System.out.print("\t\t\t\tEnter your choice: ");
			options = strInput.nextLine();

			switch (options) {
				case "1":
					try {
						AddRecord();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "2":
					try {
						ViewAllRecord();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "3":
					try {
						SearchRecordbyNoOrName();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "4":
					try {
						updateRecordbyNO();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "5":
					try {
						DeleteRecordByNO();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "6":
					clearscreen();
					System.out.print("\n\t\t\t\t--------------Goodbye, Thankyou! :) --------------\n");
					System.exit(0);
					break;
				default:
					System.out.println("\n\t\tINVALID CHOICE");
			}
			System.out.print("\n\t\tBack to Home Screen?[Y/N] ");
			choice = strInput.nextLine();
		}
	}

	public static String PadString(String str, int num) {
		int str_size = str.length();
		for (int i = str_size; i <= num; i++) {
			str = str + " ";
		}
		return str;
	}

	public static void header() {
		System.out.println(
				"  ___________________________________________________________________________________________________________________");
		System.out.print("  |" + PadString(" Student #", 10));
		System.out.print("|" + PadString("  First Name", 20));
		System.out.print("|" + PadString(" M. I.", 6));
		System.out.print("|" + PadString("  Last Name", 20));
		System.out.print("|" + PadString(" Age", 4));
		System.out.print("|" + PadString(" Sex", 7));
		System.out.print("|" + PadString(" Year", 6));
		System.out.print("|" + PadString(" Course", 8));
		System.out.print("|" + PadString("     Campus", 15));
		System.out.println("|");
		System.out.println(
				"  |-----------|---------------------|-------|---------------------|-----|--------|-------|---------|----------------|");
	}

	public static void showRecord(String[] data) {
		System.out.print("  |" + PadString(data[0].toString(), 10));
		System.out.print("|  " + PadString(data[1].toString(), 18));
		System.out.print("|  " + PadString(data[2].toString(), 4));
		System.out.print("|  " + PadString(data[3].toString(), 18));
		System.out.print("| " + PadString(data[4].toString(), 3));
		System.out.print("| " + PadString(data[5].toString(), 6));
		System.out.print("| " + PadString(data[6].toString(), 5));
		System.out.print("|  " + PadString(data[7].toString(), 6));
		System.out.print("|   " + PadString(data[8].toString(), 12));
		System.out.println("|");
		System.out.println(
				"  |-----------|---------------------|-------|---------------------|-----|--------|-------|---------|----------------|");
	}

	public static void footer() {
		System.out.println(
				"  |____________________________________________*Nothing Follows*____________________________________________________|");
	}

	public static void AddRecord() throws IOException {
		clearscreen();
		System.out.print("\n\t\tAdd Student's Record\n");
		Scanner strInput = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y"))
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt", true));
				String student_no, first_name, middle_initial, last_name, age, gender,
						year, course, campus, confirm = "n";

				System.out.print("\n\t\tEnter the Student Number: ");
				student_no = strInput.nextLine();
				System.out.print("\t\tEnter First Name: ");
				first_name = strInput.nextLine();
				System.out.print("\t\tEnter Middle Initial: ");
				middle_initial = strInput.nextLine();
				System.out.print("\t\tEnter Last Name: ");
				last_name = strInput.nextLine();
				System.out.print("\t\tEnter Age: ");
				age = strInput.nextLine();
				System.out.print("\t\tEnter Sex(Male/Female): ");
				gender = strInput.nextLine();
				System.out.print("\t\tEnter Year Lever(Ex. 1st): ");
				year = strInput.nextLine();
				System.out.print("\t\tEnter Course(Ex. BSIT): ");
				course = strInput.nextLine();
				System.out.print("\t\tEnter Campus: ");
				campus = strInput.nextLine();

				System.out.print("\n\t\tAre you sure the above data is correct?[y/n] ");
				confirm = strInput.nextLine();
				if (confirm.equalsIgnoreCase("y")) {
					bw.write(student_no + ":::" + first_name + ":::" + middle_initial + ":::" + last_name + ":::"
							+ age + ":::" + gender + ":::" + year + ":::" + course + ":::" + campus);
					bw.flush();
					bw.newLine();
					bw.close();

					System.out.print("\n\t\tAdding Record ");
					System.out.print(".");
					wait(500);
					System.out.print(".");
					wait(500);
					System.out.print(".");
					wait(500);
					System.out.print(".");
					wait(500);
					System.out.print(".\n");
					wait(500);
					System.out.print("\n\t\tStudent Record Successfully Added!\n");
					System.out.print("\n\t\tDo you want to add another?[Y/N] ");
					choice = strInput.nextLine();
				} else {
					AddRecord();
				}

			} catch (IOException ex) {
				System.out.println(ex.toString());
			}
	}

	public static void ViewAllRecord() throws IOException {
		try {
			clearscreen();
			BufferedReader br = new BufferedReader(new FileReader("students.txt"));
			String record;
			System.out.println("\n\t\tFULL DATABASE:");
			header();
			while ((record = br.readLine()) != null) {
				String[] data = record.split(":::");
				showRecord(data);
			}
			footer();
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}

	public static void SearchRecordbyNoOrName() throws IOException {
		Scanner strInput = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y"))
			try {
				clearscreen();
				String search, record;
				BufferedReader br = new BufferedReader(new FileReader("students.txt"));

				System.out.println("\n\t\tSearch Student's Record\n");

				System.out.print("\t\tEnter the Student Number, Name or other: ");
				search = strInput.nextLine();

				System.out.print("\n\t\tSearching Please Wait ");
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".\n");
				wait(500);

				int i = 0;
				while ((record = br.readLine()) != null) {
					String[] data = record.split(":::");
					if (data[0].toString().equals(search) || data[1].toString().contains(search)
							|| data[2].toString().contains(search) || data[3].toString().contains(search)
							|| data[4].toString().contains(search) || data[5].toString().contains(search)
							|| data[6].toString().contains(search) || data[7].toString().contains(search)
							|| data[8].toString().contains(search)) {
						System.out.println("\n\t\tRECORD FOUND");
						header();
						showRecord(data);
						i++;
					}
				}
				if (i == 0) {
					System.out.println("\n\t\tNo Record found on the Database!!");
				}

				System.out.print("\n\t\tDo you want to search again?[Y/N] ");
				choice = strInput.nextLine();

				br.close();

			} catch (IOException ex) {
				System.out.println(ex.toString());
			}
	}

	public static void updateRecordbyNO() throws IOException {
		try {
			clearscreen();
			ViewAllRecord();
			String newStudentNo = "", newFname = "", newMInitial = "", newLname = "", newAge = "", newGender = "",
					newYear = "", newCourse = "", newCampus = "";
			String record, student_info, record2;

			File db = new File("students.txt");
			File tempDB = new File("students_temp.txt");

			BufferedReader br = new BufferedReader(new FileReader(db));
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

			Scanner strInput = new Scanner(System.in);

			System.out.print("\n\t\t Update Student's Record\n\n");
			System.out.print("\t\tEnter the Student #, First Name or Last Name to update: ");
			student_info = strInput.nextLine();
			clearscreen();
			header();
			int i = 1;
			int found = 0;
			while ((record = br.readLine()) != null) {
				String[] data = record.split(":::");
				if (data[0].toString().equals(student_info) || data[1].toString().contains(student_info)
						|| data[3].toString().contains(student_info)) {
					showRecord(data);
					found = 1;
				} else if (found == 0) {
					i++;
				}
			}
			br.close();

			String c;
			File aa = new File("students.txt");
			BufferedReader bb = new BufferedReader(new FileReader(aa));
			int a = 1;
			String[] data = {};
			while (a <= i) {
				c = bb.readLine();
				data = c.split(":::");
				newStudentNo = data[0];
				newFname = data[1];
				newMInitial = data[2];
				newLname = data[3];
				newAge = data[4];
				newGender = data[5];
				newYear = data[6];
				newCourse = data[7];
				newCampus = data[8];
				a++;
			}
			bb.close();

			if (i != 0) {
				Scanner ss = new Scanner(System.in);
				int ch;
				System.out.println("\n\t\tEnter Data Element to update example");
				System.out.println("\n\t\t1. Multiple Data");
				System.out.println("\t\t2. First Name");
				System.out.println("\t\t3. Middle Initial");
				System.out.println("\t\t4. Last Name");
				System.out.println("\t\t5. Age");
				System.out.println("\t\t6. Sex");
				System.out.println("\t\t7. Year Level");
				System.out.println("\t\t8. Course");
				System.out.println("\t\t9. Campus");
				System.out.println("\t\t10. Student No\n");
				System.out.print("\t\tEnter number: ");
				ch = ss.nextInt();

				switch (ch) {
					case 1:
						System.out.print("\n\t\tLeave Blank for data that you wont edit!");
						System.out.print("\n\t\tEnter new student no.: ");
						newStudentNo = strInput.nextLine();
						if (newStudentNo.isBlank()) {
							newStudentNo = data[0];
						}
						System.out.print("\t\tEnter new first name: ");
						newFname = strInput.nextLine();
						if (newFname.isBlank()) {
							newFname = data[1];
						}
						System.out.print("\t\tEnter new middle initial: ");
						newMInitial = strInput.nextLine();
						if (newMInitial.isBlank()) {
							newMInitial = data[2];
						}
						System.out.print("\t\tEnter new last name: ");
						newLname = strInput.nextLine();
						if (newLname.isBlank()) {
							newLname = data[3];
						}
						System.out.print("\t\tEnter new age: ");
						newAge = strInput.nextLine();
						if (newAge.isBlank()) {
							newAge = data[4];
						}
						System.out.print("\t\tEnter new sex: ");
						newGender = strInput.nextLine();
						if (newGender.isBlank()) {
							newGender = data[5];
						}
						System.out.print("\t\tEnter new year level: ");
						newYear = strInput.nextLine();
						if (newYear.isBlank()) {
							newYear = data[6];
						}
						System.out.print("\t\tEnter new course: ");
						newCourse = strInput.nextLine();
						if (newCourse.isBlank()) {
							newCourse = data[7];
						}
						System.out.print("\t\tEnter new campus: ");
						newCampus = strInput.nextLine();
						if (newCampus.isBlank()) {
							newCampus = data[8];
						}
						break;
					case 2:
						System.out.print("\n\t\tEnter new first name: ");
						newFname = strInput.nextLine();
						break;
					case 3:
						System.out.print("\t\tEnter new middle initial: ");
						newMInitial = strInput.nextLine();
						break;
					case 4:
						System.out.print("\t\tEnter new last name: ");
						newLname = strInput.nextLine();
						break;
					case 5:
						System.out.print("\t\tEnter new age: ");
						newAge = strInput.nextLine();
						break;
					case 6:
						System.out.print("\t\tEnter new sex: ");
						newGender = strInput.nextLine();
						break;
					case 7:
						System.out.print("\t\tEnter new year level: ");
						newYear = strInput.nextLine();
						break;
					case 8:
						System.out.print("\t\tEnter new course: ");
						newCourse = strInput.nextLine();
						break;
					case 9:
						System.out.print("\t\tEnter new campus: ");
						newCampus = strInput.nextLine();
						break;
					case 10:
						System.out.print("\n\t\tEnter new student no.: ");
						newStudentNo = strInput.nextLine();
						break;
				}

				BufferedReader br2 = new BufferedReader(new FileReader(db));
				while ((record2 = br2.readLine()) != null) {
					data = record2.split(":::");
					if (data[0].toString().equals(student_info) || data[1].toString().equals(student_info)
							|| data[3].toString().equals(student_info)) {
						bw.write(newStudentNo + ":::" + newFname + ":::" + newMInitial + ":::" + newLname
								+ ":::" + newAge + ":::" + newGender + ":::" + newYear + ":::" + newCourse + ":::"
								+ newCampus);
					} else {
						bw.write(record2);
					}
					bw.flush();
					bw.newLine();
				}

				System.out.print("\n\t\tRecord Updating ");
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".\n");
				wait(500);

				System.out.println("\n\t\tRecord Updated Successfully");

				bw.close();
				br2.close();
				db.delete();
				boolean success = tempDB.renameTo(db);
			}
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}

	public static void DeleteRecordByNO() throws IOException {
		Scanner ch = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y"))
			try {
				ViewAllRecord();
				Scanner strInput = new Scanner(System.in);
				String student_info, record;

				File tempDB = new File("students_temp.txt");
				File db = new File("students.txt");

				BufferedReader br = new BufferedReader(new FileReader(db));
				BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

				System.out.println("\n\t\tDelete Student's Record\n");
				System.out.print("\t\tEnter the Student Number, Name or Last Name to delete: ");
				student_info = strInput.nextLine();

				while ((record = br.readLine()) != null) {
					String[] data = record.split(":::");
					if (data[0].toString().equals(student_info) || data[1].toString().equals(student_info)
							|| data[2].toString().equals(student_info) || data[3].toString().equals(student_info))
						continue;
					bw.write(record);
					bw.flush();
					bw.newLine();
				}
				System.out.print("\n\t\tRecord Deleting ");
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".");
				wait(500);
				System.out.print(".\n");
				wait(500);
				System.out.println("\n\t\tRecord Deleted!");
				System.out.print("\n\t\tDo you want to delete another?[Y/N] ");
				choice = ch.nextLine();
				br.close();
				bw.close();
				db.delete();
				tempDB.renameTo(db);
			} catch (IOException ex) {
				System.out.println(ex.toString());
			}
	}

	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public static void clearscreen() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				// Runtime.getRuntime().exec("clear");
				new ProcessBuilder("clear").inheritIO().start().waitFor();
		} catch (IOException | InterruptedException ex) {
		}
	}
}
