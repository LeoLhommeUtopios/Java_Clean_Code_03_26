package org.example.Kata3;

public enum EmployeeRole {
    DEVELOPER("Développeur"),
    MANAGER("Manager"),
    INTERN("Stagiaire");

    private final String displayName;
    EmployeeRole(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
