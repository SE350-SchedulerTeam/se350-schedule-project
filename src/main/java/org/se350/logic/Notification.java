package org.se350.logic;

public class Notification implements Observer{
    private String description;
    @Override
    public void showNotification(String description) {
        System.out.println(description);
    }
    public String getDescription(){
        return description;
    }
    public Notification (String description){
        this.description = description;

    }
    public Notification(){}
}