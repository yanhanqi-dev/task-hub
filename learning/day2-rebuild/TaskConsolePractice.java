import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TaskConsolePractice {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int taskCount = readTaskCount(scanner);
		List<String> tasks = readTasks(scanner, taskCount);
		printTasks(tasks);

		scanner.close();
	}

	private static int readTaskCount(Scanner scanner) {
		while (true) {
			System.out.print("请输入今天要完成几条任务： ");
			String countText = scanner.nextLine();

			try {
				int taskCount = Integer.parseInt(countText);

				if (taskCount > 0) {
					return taskCount;
				}

				System.out.println("任务数量必须大于 0。");
			} catch (NumberFormatException e) {
				System.out.println("任务数量必须为整数。");
			}
		}
	}

	private static List<String> readTasks(Scanner scanner, int taskCount) {
		List<String> tasks = new ArrayList<>();

		for (int i = 0; i < taskCount; i++) {
			System.out.print("请输入第 " + (i + 1) + " 条任务： ");
			tasks.add(scanner.nextLine());
		}

		return tasks;
	}

	private static void printTasks(List<String> tasks) {
		System.out.println("今日任务： ");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println((i + 1) + ". " + tasks.get(i));
		}
	}
}