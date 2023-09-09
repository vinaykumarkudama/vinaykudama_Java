package com.gl.emp;
import java.io.Serializable;

public class Project implements Serializable {
    private String projectCode;
    private String projectName;
    private int projectStrength;

    public Project(String projectCode, String projectName, int projectStrength) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.projectStrength = projectStrength;
    }

    @Override
    public String toString() {
        return "Project [projectCode=" + projectCode + ", projectName=" + projectName + ", projectStrength=" + projectStrength + "]";
    }
}
