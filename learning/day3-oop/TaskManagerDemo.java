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
            System.out.println("0. 退出");
            System.out.print("请选择功能：");

            String choice = scanner.nextLine();
            System.out.println("你选择了" + choice);

            if (choice.equals("1")) {
                System.out.print("请输入任务名称：");
                String title = scanner.nextLine();

                int id = tasks.size() + 1;
                Task NewTask = new Task(id, title, false);
                tasks.add(NewTask);

                System.out.println("已添加任务：" + NewTask.getTitle());
            } else if (choice.equals("2")) {
                if(tasks.isEmpty()) {
                    System.out.println("当前没有任务。");
                } else {
                    System.out.println("=== 任务列表 ===");
                    for(Task currentTask : tasks) {
                        System.out.println(currentTask.getId() + ". " + currentTask.getTitle());
                    }
                }
            } else if (choice.equals("0")) {
                System.out.println("已退出 Task Hub，再见！");
                break;
            } else {
                System.out.println("输入无效，请输入 1、 2 或 0。");
            }
        }
        scanner.close();
    }
}
