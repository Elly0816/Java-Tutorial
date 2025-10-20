package dev.ele.model;

import java.util.Objects;

public class Task implements Comparable<Task> {

    private String assignee;
    private String projectName;
    private String description;
    private Status status;
    private Priority priority;

    // Enums for status employees and priority
    public enum Status {
        ASSIGNED, IN_PROGRESS, NOT_YET_ASSIGNED;

        @Override
        public String toString() {
            return name().replace("_", " ");
        }
    }

    public enum Employees {
        ANN, BOB, CAROL;

        @Override
        public String toString() {
            return this.name().charAt(0) + this.name().substring(1).toLowerCase();
        }
    }

    public enum Priority {
        HIGH, MEDIUM, LOW;
    }

    // Constructors
    public Task(String assignee, String projectName, String description, Priority priority, Status status) {
        this.assignee = assignee;
        this.projectName = projectName;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Task(String assignee, String projectName, String description, Priority priority) {
        this(assignee, projectName, description, priority, null);
    }

    public Task(String projectName, String description, Priority priority, Status status) {
        this(null, projectName, description, priority, status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean isAssigned() {
        return status != Status.NOT_YET_ASSIGNED;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task task) {
        int result = projectName.compareTo(task.projectName);
        if (result == 0) {
            result = description.compareTo(task.description);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Task other = (Task) o;

        return projectName.equals(other.projectName) && description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, description);
    }

    @Override
    public String toString() {
        if (assignee == null) {
            return "PROJECT NAME: %-25s DESCRIPTION: %-25s PRIORITY: %-10s STATUS: %s".formatted(projectName,
                    description,
                    priority, status);
        }
        return "PROJECT NAME: %-25s DESCRIPTION: %-25s PRIORITY: %-10s STATUS: %-20s ASSIGNED TO: %s ".formatted(
                projectName, description, priority, status, assignee);
    }

}