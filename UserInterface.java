/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author webb2
 */

import java.util.ArrayList; 
import java.util.Scanner;

public class UserInterface {

    private GradeStatistics gradeStats;
    private Scanner scanner;
    
    public UserInterface(GradeStatistics gradeStats, Scanner scanner) {
        this.scanner = scanner;
        this.gradeStats = gradeStats;
    }

    public void start() {
        
        this.readPoints();   
        
        //PART 1 print the average of the point totals that were input.
        System.out.println("Point average (all): " + gradeStats.averageOfPoints());
        //PART 2
        printAverageOfPassingGrades();
        //PART 3
       System.out.println("Pass percentage: " + this.gradeStats.passPercentage());
       //PART 4 
       printGradeDistribution();

    }
    
    public void readPoints()    {

        System.out.println("Enter point totals, -1 stops: ");
        while (true) {
            int points = Integer.valueOf(scanner.nextLine());
            if (points == -1)  {
                break;
            }
//            if (points >= 0 && points <= 100) {                
//               this.gradeStats.addPoints(points); 
//            }
//            if (points < 0 || points > 100) {
//                continue;
//            }            
//PART 1 - 4)   
            if (points >= 0 && points <= 100) {       
                this.gradeStats.addGradeBasedOnPoints(points);  
            }
            if (points < 0 || points > 100) {
                continue;
            } 
        }        
    }
    
    
    public void printAverageOfPassingGrades() {
//If there are no numbers giving a passing grade, the program should print a line "-" where the average would be.        
        if (this.gradeStats.averageOfPassingPoints() > 0) {
            System.out.println("Point average (passing): " + this.gradeStats.averageOfPassingPoints());
        } else  {
            System.out.println("Point average (passing): -"); 
        }
    } 
    
    public void printGradeDistribution() {
        System.out.println("Grade Distribution: ");
        int grade = 5;
//get number of grades in each grade span (ex. 3 in "Grade 0 span", 7 in "Grade 3 span"       
        while (grade >= 0) {
            int stars = this.gradeStats.numberOfGrades(grade);
            System.out.print(grade + ": ");
            printsStars(stars);
            System.out.println("");

            grade = grade - 1;
        }
        
    }

    public static void printsStars(int stars) {
        while (stars > 0) {
            System.out.print("*");
            stars--;
        }
    }    
    
}
