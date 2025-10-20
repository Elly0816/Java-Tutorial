package dev.ele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dev.ele.model.Task;
import dev.ele.model.TaskData;
import dev.ele.model.Task.Employees;

public class Main {
    public static void main(String[] args) {
        Set<Task> allTasks = TaskData.getTasks();
        sortAndPrint("All Tasks", allTasks);

        Comparator<Task> byPriority = Comparator.comparing(Task::getPriority);

        Set<Task> annTasks = TaskData.getTasks(Employees.ANN);
        sortAndPrint("Ann's Tasks", annTasks, byPriority);

        Set<Task> bobTasks = TaskData.getTasks(Employees.BOB);
        sortAndPrint("Bob's Tasks", bobTasks, byPriority);

        Set<Task> carolTasks = TaskData.getTasks(Employees.CAROL);
        sortAndPrint("Carol's Tasks", carolTasks, byPriority);

        // List of all tasks described by the manager
        Set<Task> tasksDescribedByManager = getUnion(List.of(allTasks, annTasks, bobTasks, carolTasks));
        sortAndPrint("Tasks described by Manager", tasksDescribedByManager, byPriority);

        // Which tasks are assigned to at least one of your 3 team members
        Set<Task> tasksAssignedToAtLeastOneTeamMember = getUnion(List.of(annTasks, bobTasks, carolTasks));
        sortAndPrint("Tasks assigned to at least one team member", tasksAssignedToAtLeastOneTeamMember, byPriority);

        // Which tasks still need to be assigned
        Set<Task> tasksThatStillNeedToBeAssigned = getDifference(tasksDescribedByManager,
                tasksAssignedToAtLeastOneTeamMember);
        sortAndPrint("Tasks that still need to be assigned", tasksThatStillNeedToBeAssigned, byPriority);

        // Which tasks are assigned to multiple employees
        Set<Task> tasksAssignedToMultipleEmployees = getUnion(List.of(getIntersect(annTasks, bobTasks),
                getIntersect(bobTasks, carolTasks), getIntersect(carolTasks, annTasks)));
        sortAndPrint("Tasks that are assigned to multiple employees", tasksAssignedToMultipleEmployees, byPriority);

    }

    private static Set<Task> getUnion(List<Set<Task>> tasks) {
        Set<Task> tasksUnion = new HashSet<>();
        tasks.forEach(tasksUnion::addAll);
        return tasksUnion;
    }

    private static Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> taskDifference = new HashSet<>(set1);
        taskDifference.removeAll(set2);
        return taskDifference;
    }

    public static void sortAndPrint(String label, Collection<Task> items) {
        sortAndPrint(label, items, null);
    }

    public static void sortAndPrint(String label, Collection<Task> items, Comparator<Task> sorter) {
        String lineSeparator = "_".repeat(120);
        System.out.println(lineSeparator);
        System.out.println(label);
        System.out.println(lineSeparator);
        List<Task> list = new ArrayList<>(items);
        list.sort(sorter);
        list.forEach(System.out::println);
        System.out.println();
    }

}