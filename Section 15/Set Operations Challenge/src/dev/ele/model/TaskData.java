package dev.ele.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dev.ele.model.Task.Employees;
import dev.ele.model.Task.Priority;
import dev.ele.model.Task.Status;

public class TaskData {

    // private static String allTasks;
    // private static String annsTasks;
    // private static String bobsTasks;
    // private static String carolsTasks;
    private static final String FILE_PATH = "dev/ele/data/SetsOperationsData.csv";

    public static Set<Task> getTasks(Employees name) {
        String employeeName = name.toString();
        return readLinesAndReturnTasks(employeeName);
    }

    public static Set<Task> getTasks() {
        return readLinesAndReturnTasks("all");
    }

    private static Set<Task> readLinesAndReturnTasks(String nameOrAll) {
        long startTime = System.nanoTime();
        Set<Task> tasks = new HashSet<>();
        try {
            File file = new File(FILE_PATH);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                boolean hasReadAllEntries = false;
                // while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.toUpperCase().contains(nameOrAll.toUpperCase())) {
                    while (sc.hasNextLine()) {
                        String taskString = sc.nextLine();
                        // System.out.println("This is the current task string: " + taskString);
                        if (taskString.isBlank()) {
                            hasReadAllEntries = true;
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
                    if (hasReadAllEntries) {
                        break;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        // switch (nameOrAll.toUpperCase()) {
        // case "ALL" -> allTasks = tasks.toString();
        // case "ANN" -> annsTasks = tasks.toString();
        // case "BOB" -> bobsTasks = tasks.toString();
        // case "CAROL" -> carolsTasks = tasks.toString();
        // default -> System.out.println("default case");
        // }
        long finishTime = System.nanoTime();
        System.out.println("It took " + (finishTime - startTime) + " nano seconds to read data");
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