package internship_projects;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            int mark = sc.nextInt();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
                i--; // Repeat this subject input
            } else {
                marks[i] = mark;
                totalMarks += mark;
            }
        }

        double average = (double) totalMarks / numSubjects;
        String grade = calculateGrade(average);

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }

    public static String calculateGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }
}
