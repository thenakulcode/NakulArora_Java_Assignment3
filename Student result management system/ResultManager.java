import java.util.Scanner;

// custom exception for invalid marks
class InvalidMarksException extends Exception {
    public InvalidMarksException(String msg){
        super(msg);
    }
}

// Student class
class Student {

    private int rollNo;
    private String name;
    private int[] marks;

    public Student(int r, String n, int[] m){
        rollNo = r;
        name = n;
        marks = m;
    }

    // check marks range
    public void validateMarks() throws InvalidMarksException {
        for(int i = 0; i < marks.length; i++){
            if(marks[i] < 0 || marks[i] > 100){
                throw new InvalidMarksException("Invalid marks for subject " + (i+1) + ": " + marks[i]);
            }
        }
    }

    public double getAverage(){
        int sum = 0;
        for(int x : marks){
            sum += x;
        }
        return sum / 3.0;
    }

    public int getRoll(){
        return rollNo;
    }

    public void printDetails(){
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Student Name : " + name);

        System.out.print("Marks : ");
        for(int m : marks){
            System.out.print(m + " ");
        }
        System.out.println();

        double avg = getAverage();
        System.out.println("Average : " + avg);

        if(avg >= 40){
            System.out.println("Result : Pass");
        } else {
            System.out.println("Result : Fail");
        }
    }
}


// Main class for managing students
public class ResultManager {

    private Student[] list;
    private int index;
    private Scanner sc;

    public ResultManager(){
        list = new Student[50];
        index = 0;
        sc = new Scanner(System.in);
    }

    public void addStudent(){
        try {
            System.out.print("Enter Roll Number: ");
            int r = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String n = sc.nextLine();

            int[] m = new int[3];
            for(int i = 0; i < 3; i++){
                System.out.print("Enter marks for subject " + (i+1) + ": ");
                m[i] = sc.nextInt();
            }

            Student s = new Student(r, n, m);
            s.validateMarks();

            list[index] = s;
            index++;

            System.out.println("Student added successfully.");

        } catch (InvalidMarksException ime){
            System.out.println("Error : " + ime.getMessage());
        } catch (Exception e){
            System.out.println("Invalid input.");
            sc.nextLine();
        }
    }

    public void showStudent(){
        try {
            System.out.print("Enter Roll Number to search: ");
            int r = sc.nextInt();

            boolean found = false;
            for(int i = 0; i < index; i++){
                if(list[i].getRoll() == r){
                    list[i].printDetails();
                    found = true;
                    break;
                }
            }

            if(!found){
                System.out.println("No student found with roll number " + r);
            }

        } catch(Exception e){
            System.out.println("Error reading input.");
        }
    }

    public void menu(){
        try {
            while(true){
                System.out.println("\n===== Student Result Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch(choice){
                    case 1: addStudent(); break;
                    case 2: showStudent(); break;
                    case 3:
                        System.out.println("Exiting program. Thank you!");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
        finally {
            sc.close();
            System.out.println("Scanner closed.");
        }
    }

    public static void main(String[] args){
        ResultManager rm = new ResultManager();
        rm.menu();
    }
}
