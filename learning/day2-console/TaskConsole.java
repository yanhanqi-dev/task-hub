import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Task Hub 控制台 ===");

        while (true) {
            printMenu();
            System.out.print("请选择功能：");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addTask();
                case "2" -> showTasks();
                case "0" -> {
                    System.out.println("已退出 Task Hub，再见！");
                    scanner.close();
                    return;
                }
                default -> System.out.println("输入无效，请输入 1、2 或 0。");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. 添加任务");
        System.out.println("2. 查看任务");
        System.out.println("0. 退出程序");
    }

    private static void addTask() {
        System.out.print("请输入任务内容：");
        String title = scanner.nextLine();

        if (title.isBlank()) {
            System.out.println("任务内容不能为空，未添加。");
            return;
        }

        tasks.add(title);
        System.out.println("添加成功。当前共有 " + tasks.size() + " 个任务。");
    }

    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("暂无任务。");
            return;
        }

        System.out.println("当前任务：");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}