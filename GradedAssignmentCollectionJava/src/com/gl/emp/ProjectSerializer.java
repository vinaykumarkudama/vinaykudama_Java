package com.gl.emp;
import java.io.*;
import java.util.*;

public class ProjectSerializer {
    Map<Project, ArrayList<Employee>> projectMap = new HashMap<>();

    public void serializeProjectDetails(Map<Project, ArrayList<Employee>> projectMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("project_data.ser"))) {
            oos.writeObject(projectMap);
            System.out.println("Serialized map of project successfully...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeProjectDetails() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("project_data.ser"))) {
            Map<Project, ArrayList<Employee>> deserializedMap = (Map<Project, ArrayList<Employee>>) ois.readObject();

            for (Map.Entry<Project, ArrayList<Employee>> entry : deserializedMap.entrySet()) {
                Project project = entry.getKey();
                ArrayList<Employee> employees = entry.getValue();

                System.out.println("DeSerialized Data:");
                System.out.println("The Project " + project + " Has the following Employees");
                System.out.println("Employees .............");
                System.out.print("[");
                for (int i = 0; i < employees.size(); i++) {
                    System.out.print(employees.get(i));
                    if (i < employees.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


	public Map<Project, ArrayList<Employee>> getProjectMap() {
		return projectMap;
	}

	public void setProjectMap(Map<Project, ArrayList<Employee>> projectMap) {
		this.projectMap = projectMap;
	}
}

