package com.gl.emp;

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        ProjectSerializer projectSerializer = new ProjectSerializer();
//
//        // Sample Data
//        Project project1 = new Project("P1", "Music Synthesizer", 23);
//        Project project2 = new Project("P2", "Vehicle Movement Tracker", 13);
//        Project project3 = new Project("P3", "Liquid Viscosity Finder", 15);
//
//        Employee e1 = new Employee("E001", "Harsha", "9383993933", "RTNagar", 1000);
//        Employee e2 = new Employee("E002", "Harish", "9354693933", "Jayanagar", 2000);
//        Employee e3 = new Employee("E003", "Meenal", "9383976833", "Malleswaram", 1500);
//
//        projectSerializer.getProjectMap().put(project1, new ArrayList<>(Arrays.asList(e1, e2, e3)));
//
//        Employee e4 = new Employee("E004", "Sundar", "9334593933", "Vijayanagar", 3000);
//        Employee e5 = new Employee("E005", "Suman", "9383678933", "Indiranagar", 2000);
//        Employee e6 = new Employee("E006", "Suma", "9385493933", "KRPuram", 1750);
//
//        projectSerializer.getProjectMap().put(project2, new ArrayList<>(Arrays.asList(e4, e5, e6)));
//
//        Employee e7 = new Employee("E007", "Chitra", "9383978933", "Koramangala", 4000);
//        Employee e8 = new Employee("E008", "Suraj", "9383992133", "Malleswaram", 3000);
//        Employee e9 = new Employee("E009", "Manu", "9345193933", "RTNagar", 2000);
//
//        projectSerializer.getProjectMap().put(project3, new ArrayList<>(Arrays.asList(e7, e8, e9)));
//
//        projectSerializer.serializeProjectDetails(projectSerializer.getProjectMap());
//        projectSerializer.deserializeProjectDetails();
//    }
//}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProjectSerializer projectSerializer = new ProjectSerializer();

        // Sample Data
        Project project1 = new Project("P1", "Music Synthesizer", 23);
        Project project2 = new Project("P2", "Vehicle Movement Tracker", 13);
        Project project3 = new Project("P3", "Liquid Viscosity Finder", 15);

        Employee e1 = new Employee("E001", "Harsha", "9383993933", "RTNagar", 1000);
        Employee e2 = new Employee("E002", "Harish", "9354693933", "Jayanagar", 2000);
        Employee e3 = new Employee("E003", "Meenal", "9383976833", "Malleswaram", 1500);

        projectSerializer.projectMap.put(project1, new ArrayList<>(Arrays.asList(e1, e2, e3)));

        Employee e4 = new Employee("E004", "Sundar", "9334593933", "Vijayanagar", 3000);
        Employee e5 = new Employee("E005", "Suman", "9383678933", "Indiranagar", 2000);
        Employee e6 = new Employee("E006", "Suma", "9385493933", "KRPuram", 1750);

        projectSerializer.projectMap.put(project2, new ArrayList<>(Arrays.asList(e4, e5, e6)));

        Employee e7 = new Employee("E007", "Chitra", "9383978933", "Koramangala", 4000);
        Employee e8 = new Employee("E008", "Suraj", "9383992133", "Malleswaram", 3000);
        Employee e9 = new Employee("E009", "Manu", "9345193933", "RTNagar", 2000);

        projectSerializer.projectMap.put(project3, new ArrayList<>(Arrays.asList(e7, e8, e9)));

        projectSerializer.serializeProjectDetails(projectSerializer.projectMap);

        // Delay the deserialization and printing
        try {
            Thread.sleep(1000); // Delay for 1 second
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        projectSerializer.deserializeProjectDetails();
    }
}

