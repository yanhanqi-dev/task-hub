public class TaskDemo {
    public static void main(String[] args) {

        Task task = new Task(1, "学习 Java 对象", true);
        Task task2 = new Task(2, "完成 Day 3", false);

        System.out.println("编号： " + task.getId());
        System.out.println("标题： " + task.getTitle());
        System.out.println("已完成： " + task.isCompleted());

        System.out.println("第二条任务：");
        System.out.println("编号： " + task2.getId());
        System.out.println("标题： " + task2.getTitle());
        System.out.println("已完成： " + task2.isCompleted());
    }
}