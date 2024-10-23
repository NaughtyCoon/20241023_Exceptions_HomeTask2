import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Student[] student = new Student[5];

        for (int i = 0; i < student.length; i++){
            String name = "";
            int grade = 0;
            while (name.equals("")){
                System.out.print("Enter the student name: ");
                try {
                    name = scanner.nextLine();
                    if (name.equals("")) throw new NullPointerException("Name can't be empty! Reenter!");
                }
                catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
                finally {
                    if (name.equals("")){
                        System.out.println("Incorrect name parameter!");
                    } else {
                        System.out.println("Name accepted. Proceed further.");
                    }
                }
            }
            while (grade == 0){
                System.out.print("Enter the student grade: ");
                try {
                    grade = Integer.parseInt(scanner.nextLine());
                }
                catch (NumberFormatException e) {
                    System.out.println("Grade must be within 1 to 11 range!");
                }
                finally {
                    if (grade > 0 && grade < 12) {
                        System.out.println("Grade accepted. Student " + name + " enrolled into grade " + grade + "\n");
                    } else {
                        System.out.println("Incorrect grade parameter!");
                        grade = 0;
                    }
                }
            }
            student[i] = new Student(name, grade);
        }
        System.out.println(">>>>> Meet the new team <<<<<");
        for (int i=0; i < 5; i++){
            System.out.println("Student No." + (i+1) + ":   " + student[i].getName() + " is in the " + student[i].getGrade() + " grade.");
        }
        scanner.close();
    }
}