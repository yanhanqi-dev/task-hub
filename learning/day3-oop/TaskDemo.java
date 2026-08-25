public class TaskDemo {
    public static void main(String[] args) {

        Task task = new Task();
        task.id = 1;
        task.title = "学习Java对象";
        task.completed = true;

        Task task2 = new Task();
        task2.id = 2;
        task2.title = "完成 Day 3";
        task2.completed = false;

        System.out.println("编号： " + task.id);
        System.out.println("标题： " + task.title);
        System.out.println("已完成： " + task.completed);

        System.out.println("第二条任务：");
        System.out.println("编号： " + task2.id);
        System.out.println("标题： " + task2.title);
        System.out.println("已完成： " + task2.completed);
    }
}