import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TaskConsolePractice {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		List<String> tasks = new ArrayList<>();

		System.out.print("请输入今天要添加几条任务： ");
		String countText = scanner.nextLine();
		int taskCount;

		try {
			taskCount = Integer.parseInt(countText);
		} catch (NumberFormatException e) {
			System.out.println("任务数量必须是整数。");
			scanner.close();
			return;
		}

		if (taskCount <= 0) {
			System.out.println("任务数量必须大于0。");
			scanner.close();
			return;
		}

		for (int i = 0; i < taskCount; i++) {
			System.out.print("请输入第 " + (i + 1) + " 条任务： ");
			tasks.add(scanner.nextLine());
		}

		System.out.println("今日任务： ");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println((i + 1) + ". " + tasks.get(i));
		}

		scanner.close();
	}
}