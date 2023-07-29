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

public class GradeStatistics {

    private ArrayList<Integer> pointsList;
    private int participants;
    private int passCounter;
    private ArrayList<Integer> grades;    
    
    public GradeStatistics() {   
        
        this.pointsList = new ArrayList<>(); 
        this.participants = 0;
        this.passCounter = 0;
        this.grades = new ArrayList<>(); 
    }
    
    public void addPoints(int points) {
        this.pointsList.add(points);
        if (points >= 50) {   //Count passing grades                  
            this.passCounter = this.passCounter + 1; 
        }
        //Count participants for Pass Percentage calc
        this.participants = this.participants + 1;    
    }

        public void addGradeBasedOnPoints(int points) {
//add entered points to points list & convert points to grade            
            int grade = pointsToGrade(points);  
            this.grades.add(grade);    
  
    }
        
    public int pointsToGrade(int points) {   

        this.addPoints(points);   
        
        int grade = 0;
        if (points < 50) {
            grade = 0;
        } else if (points < 60) {
            grade = 1;
        } else if (points < 70) {
            grade = 2;
        } else if (points < 80) {
            grade = 3;
        } else if (points < 90) {
            grade = 4;
        } else {
            grade = 5;
        }

        return grade;
}
     
    public int numberOfGrades(int grade) {
        int count = 0;
        
        for (int received : this.grades) {
            if (received == grade) {
                count++;
            }
        }

        return count;
    }
    
    public double averageOfPoints() {
        
        if (!this.pointsList.isEmpty()) {
            double sum = 0;
            int ctr = 0;
            for (Integer point : this.pointsList) {
                sum = sum + Double.valueOf(point);
                ctr++;
            }
            double returnAvg = 0;
            if (ctr > 0) {     
                returnAvg = sum / ctr;
            }
            return returnAvg;
        }
        return -1;
    }        

    public double averageOfPassingPoints() {
//A passing grade is achieved by getting a minimum of 50 course points. 
        if (!this.pointsList.isEmpty()) {
            double sum = 0;
            int ctr = 0;
            for (Integer points : this.pointsList) {
                if (points >= 50)    {
                    sum = sum + Double.valueOf(points);
                    ctr++;                    
                }
            }
            double returnAvgOfPass = 0;
            if (ctr > 0) {     
                returnAvgOfPass = sum / ctr;
            }
            return returnAvgOfPass;
        }
        return -1;     
    }
   
  
    public double passPercentage()  {
//The pass percentage is calculated using the formula 100 * passing / participants. 
    double returnPassPercentage = 0;
    if (this.passCounter > 0 && this.participants > 0)   {    
        returnPassPercentage = (100 * Double.valueOf(this.passCounter)) / Double.valueOf(this.participants); 
        return returnPassPercentage;   
    }
    return returnPassPercentage;        
    }

    
}
