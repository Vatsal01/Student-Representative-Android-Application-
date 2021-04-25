package com.example.studentrepresentative;

public class Model {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getYearSem() {
        return yearSem;
    }

    public void setYearSem(String yearSem) {
        this.yearSem = yearSem;
    }

    public String name ;
    public String facultyName ;
    public String yearSem ;

    public Model(String name, String facultyName, String yearSem) {
        this.name = name;
        this.facultyName = facultyName;
        this.yearSem = yearSem;
    }
}
