package dev.ele.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Task implements Comparable<Task> {

    private String assignee;
    private String projectName;
    private String description;
    private Status status;
    private Priority priority;
    private static final String filePath = "dev/ele/data/SetsOperationsData.csv";

    // Enums for status, employees, and priority
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

    @Override
    public int compareTo(Task task) {
        return projectName.compareTo(task.projectName) + description.compareTo(task.description);
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
            return "Project name: %s, description: %s, priority: %s, status:%s".formatted(projectName, description,
                    priority, status);
        }
        return "Assigned to: %s, Project name: %s, description: %s priority: %s, status:%s".formatted(assignee,
                projectName, description, priority, status);
    }

    public static Set<Task> getTasks(Employees name) {
        String employeeName = name.toString();
        return readLinesAndReturnTasks(employeeName);
    }

    public static Set<Task> getTasks() {
        return readLinesAndReturnTasks("all");
    }

    private static Set<Task> readLinesAndReturnTasks(String nameOrAll) {
        Set<Task> tasks = new HashSet<>();
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.toUpperCase().contains(nameOrAll.toUpperCase())) {
                    while (sc.hasNextLine()) {
                        String taskString = sc.nextLine();
                        // System.out.println("This is the current task string: " + taskString);
                        if (taskString.isBlank()) {
                            break;
                        }
                        String[] taskItems = taskString.split(",");
                        String projectName = taskItems[0].trim();
                        String description = taskItems[1].trim();
                        String priority = taskItems[2].trim();
                        String status = null;
                        if (taskItems.length == 4) {
                            status = taskItems[3].trim();
                        }

                        Task currTask = nameOrAll.toLowerCase().equals("all")
                                ? new Task(projectName, description, getPriority(priority), Status.NOT_YET_ASSIGNED)
                                : new Task(nameOrAll, projectName, description, getPriority(priority),
                                        status == null ? Status.ASSIGNED : Status.IN_PROGRESS);
                        tasks.add(currTask);
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return tasks;
    }

    private static Priority getPriority(String priorityString) {
        String priority = priorityString.toLowerCase();

        return switch (priority) {
            case "low" -> Priority.LOW;
            case "high" -> Priority.HIGH;
            case "medium" -> Priority.MEDIUM;
            default -> null;
        };
    }
}