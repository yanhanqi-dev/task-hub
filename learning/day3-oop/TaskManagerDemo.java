import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Task Hub ===");
            System.out.println("1. 添加任务");
            System.out.println("2. 查看任务");
            System.out.println("3. 完成任务");
            System.out.println("0. 退出");
            System.out.print("请选择功能：");

            String choice = scanner.nextLine();
            System.out.println("你选择了 " + choice);

            if (choice.equals("1")) {
                addTask(scanner, tasks);
            } else if (choice.equals("2")) {
                printTasks(tasks);
            } else if (choice.equals("3")) {
                completeTask(scanner, tasks);
            } else if (choice.equals("0")) {
                System.out.println("已退出 Task Hub，再见！");
                break;
            } else {
                System.out.println("输入无效，请输入 1、 2 、3 或 0。");
            }
        }
        scanner.close();
    }

    private static void addTask(Scanner scanner, List<Task> tasks) {
        System.out.print("请输入任务名称：");
        String title = scanner.nextLine();

        int id = tasks.size() + 1;
        Task newTask = new Task(id, title, false);
        tasks.add(newTask);

        System.out.println("已添加任务：" + newTask.getTitle());
    }

    private static void printTasks(List<Task> tasks) {
        if(tasks.isEmpty()) {
            System.out.println("当前没有任务。");
        } else {
            System.out.println("=== 任务列表 ===");
            for(Task currentTask : tasks) {
                String status;
                if (currentTask.isCompleted()) {
                    status = "已完成";
                } else {
                    status = "未完成";
                }
                System.out.println(currentTask.getId() + ". [" + status + "] " + currentTask.getTitle());
            }
        }
    }

    private static void completeTask(Scanner scanner, List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("当前没有任务可完成。");
        } else {
            printTasks(tasks);

            System.out.print("请输入要完成的任务编号：");
            String input = scanner.nextLine();
            int taskId;

            try {
                taskId = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("任务编号必须是正整数。");
                return;
            }

            if(taskId < 1 || taskId > tasks.size()) {
                System.out.println("任务编号不存在，请重新输入。");
                return;
            }

            Task task = tasks.get(taskId - 1);
            task.markCompleted();

            System.out.println("已完成任务：" + task.getId() + ". " + task.getTitle());
        }
    }
}
