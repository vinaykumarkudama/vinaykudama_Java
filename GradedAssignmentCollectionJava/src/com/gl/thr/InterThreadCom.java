package com.gl.thr;
import java.util.*;

import com.gl.emp.Employee;
import com.gl.emp.Project;




class InterThreadCom {
    public static void main(String[] args) {
        // Create separate HashMaps for serialization and deserialization
        HashMap<Project, ArrayList<Employee>> hMap1 = new HashMap<>();
        HashMap<Project, ArrayList<Employee>> hMap2 = new HashMap<>();
        HashMap<Project, ArrayList<Employee>> hMap3 = new HashMap<>();

        // Create ArrayLists and populate them with Employee objects
        ArrayList<Employee> eList1 = new ArrayList<>();
        ArrayList<Employee> eList2 = new ArrayList<>();
        ArrayList<Employee> eList3 = new ArrayList<>();
        ArrayList<Employee> eList4 = new ArrayList<>();
        ArrayList<Employee> eList5 = new ArrayList<>();
        ArrayList<Employee> eList6 = new ArrayList<>();

        Employee e1 = new Employee("E001","Harsha","9383993933","RTNagar",1000);
        Employee e2 = new Employee("E002","Harish","9354693933","Jayanagar",2000);
        Employee e3 = new Employee("E003","Meenal","9383976833","Malleswaram",1500);
        Employee e4 = new Employee("E004","Sundar","9334593933","Vijayanagar",3000);
        Employee e5 = new Employee("E005","Suman","9383678933","Indiranagar",2000);
        Employee e6 = new Employee("E006","Suma","9385493933","KRPuram",1750);
        Employee e7 = new Employee("E007","Chitra","9383978933","Koramangala",4000);
        Employee e8 =  new Employee("E008","Suraj","9383992133","Malleswaram",3000);
        Employee e9 = new Employee("E009","Manu","9345193933","RTNagar",2000);
        Employee e10 = new Employee("E010","Kiran","9383975673","Koramangala",4000);
        Employee e11 = new Employee("E011","Mrinal","9383992789","Malleswaram",3000);
        Employee e12 = new Employee("E012","Mahesh","9345193763","RTNagar",2000);

        eList1.add(e1);
        eList1.add(e2);
        eList2.add(e3);
        eList2.add(e4);
        eList3.add(e5);
        eList3.add(e6);
        eList4.add(e7);
        eList4.add(e8);
        eList5.add(e9);
        eList5.add(e10);
        eList6.add(e11);
        eList6.add(e12);

        Project project1 = new Project("P1","Music Synthesizer",23);
        Project project2 = new Project("P2","Vehicle Movement Tracker",13);
        Project project3 = new Project("P3","Liquid Viscosity Finder",15);
        Project project4 = new Project("P4","InsuranceTool",23);
        Project project5 = new Project("P5","BankingTool",13);
        Project project6 = new Project("P6","PayrollTool",15);

        hMap1.put(project1, eList1);
        hMap1.put(project2, eList2);
        hMap2.put(project3, eList3);
        hMap2.put(project4, eList4);
        hMap3.put(project5, eList5);
        hMap3.put(project6, eList6);

        // Create and start threads for serialization and deserialization
        Thread1 obj1 = new Thread1(hMap1);
        producer p1 = new producer(obj1);
        consumer c1 = new consumer(obj1);

        Thread1 obj2 = new Thread1(hMap2);
        producer p2 = new producer(obj2);
        consumer c2 = new consumer(obj2);

        Thread1 obj3 = new Thread1(hMap3);
        producer p3 = new producer(obj3);
        consumer c3 = new consumer(obj3);
        
    }
}

class producer implements Runnable {
    Thread1 obj;
    producer(Thread1 obj) {
        this.obj = obj;
        new Thread(this, "Producer").start();
    }
    public void run() {
        obj.serialize();
    }
}

class consumer implements Runnable {
    Thread1 obj;
    consumer(Thread1 obj) {
        this.obj = obj;
        new Thread(this, "Consumer").start();
    }
    public void run() {
        obj.deserialize();
    }
}
class Thread1 {
    HashMap<Project, ArrayList<Employee>> hMap;
    boolean isSerialized = false; // Flag to track whether serialization is done

    Thread1(HashMap<Project, ArrayList<Employee>> hMap) {
        this.hMap = hMap;
    }

    public synchronized void serialize() {
        try {
            while (isSerialized) {
                wait(); // Wait for deserialization to complete
            }
            System.out.println(Thread.currentThread().getName() + " called by Producer");
            System.out.println("Serialized Data : " + hMap);
            isSerialized = true;
            notify(); // Notify the waiting consumer thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deserialize() {
        try {
            while (!isSerialized) {
                wait(); // Wait for serialization to complete
            }
            System.out.println(Thread.currentThread().getName() + " Called by Consumer");
            System.out.println("DeSerialized Data" + hMap);
            isSerialized = false;
            notify(); // Notify the waiting producer thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
