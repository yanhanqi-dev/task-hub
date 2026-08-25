import java.util.ArrayList;
import java.util.List;

public class TaskDemo {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        Task task = new Task(1, "学习 Java 对象", true);
        Task task2 = new Task(2, "完成 Day 3", false);
        Task task3 = new Task(3, "使用 List 管理对象", false);

        task2.markCompleted();

        tasks.add(task);
        tasks.add(task2);
        tasks.add(task3);

        System.out.println("当前任务数量： " + tasks.size());

        System.out.println("任务列表：");

        for (Task currentTask : tasks) {
            System.out.println("编号： " + currentTask.getId());
            System.out.println("标题： " + currentTask.getTitle());
            System.out.println("已完成： " + currentTask.isCompleted());
        }
    }
}