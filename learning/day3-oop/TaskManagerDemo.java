import java.util.Scanner;

public class TaskManagerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Task Hub ===");
            System.out.println("1. 添加任务");
            System.out.println("2. 查看任务");
            System.out.println("0. 退出");
            System.out.print("请选择功能：");

            String choice = scanner.nextLine();



            System.out.println("你选择了" + choice);

            if (choice.equals("1")) {
                System.out.println("添加任务功能准备中");
            } else if (choice.equals("2")) {
                System.out.println("查看任务功能准备中");
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
