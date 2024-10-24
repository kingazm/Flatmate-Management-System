package com.kingazm.com.flatmate.system;

//Task has all the variables that are needed to store task info in database (and to retrieve in later)
public class Task {

    private int id;
    private String description; //what is the task
    private String category; //for easier finding, what category does the task fall under, i.e. cleaning, shopping
    private String assignedUser; //who is responsible for performing the task
    private String deadline; //when the task is due
    private String priority; //how cruicial is to perform the task
    private String status; //status of being done - to do, in progress, done; done will be deleted from database (TODO:)
    private boolean taskAdditionResult; //is task added succesfully to database (when created is set to false, when added successfully is set to true)

    //constructors
    Task(){
        this.id = 0; //placeholder id for created task before it's added to database with auto_increment
        this.description = "";
        this.category = "";
        this.assignedUser = "";
        this.deadline = "";
        this.priority = "";
        this.status = "";
        this.taskAdditionResult = false;
    };

    Task(int id, String description, String category, String assignedUser, String deadline, String priority, String status) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.assignedUser = assignedUser;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.taskAdditionResult = false;
    }
    Task(String description, String category, String assignedUser, String deadline, String priority, String status) {
        this.id = 0; //placeholder id for created task before it's added to database with auto_increment
        this.description = description;
        this.category = category;
        this.assignedUser = assignedUser;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.taskAdditionResult = false;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTaskAdditionResult() {
        return taskAdditionResult;
    }

    public void setTaskAdditionResult(boolean taskAdditionResult) {
        this.taskAdditionResult = taskAdditionResult;
    }

    @Override
    public String toString() {

        return (description + " " + category + " " + assignedUser + " " + deadline + " " + priority + " " + status);
    }

    public String toStringWebsiteView(){
        return (description + " " + deadline + " " + priority);
    }
}
