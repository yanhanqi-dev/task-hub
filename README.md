# Task Hub

一个用于学习 Java 后端开发的任务管理 REST API 项目。

## 当前进度

目前已完成基于内存数据的任务管理 API：

- 查询任务列表
- 创建任务，并校验标题不能为空
- 标记任务为已完成
- 删除任务
- 为查询与创建接口编写自动化测试

> 当前数据保存在内存 `List` 中，应用重启后会恢复初始数据。MySQL 持久化将在后续阶段接入。

## 技术栈

- Java 21
- Spring Boot 4.1.1
- Spring MVC
- Maven
- JUnit 5 + MockMvc
- Git + GitHub

## API 一览

| 方法   | 路径                       | 成功状态码       | 说明         |
| ------ | -------------------------- | ---------------- | ------------ |
| GET    | `/api/tasks`               | `200 OK`         | 获取全部任务 |
| POST   | `/api/tasks`               | `201 Created`    | 创建任务     |
| PATCH  | `/api/tasks/{id}/complete` | `200 OK`         | 标记任务完成 |
| DELETE | `/api/tasks/{id}`          | `204 No Content` | 删除任务     |

创建任务请求示例：

```json
{
  "title": "学习 Spring Boot"
}
```

错误处理：

- 创建时标题为空：`400 Bad Request`
- 操作不存在的任务：`404 Not Found`

## 本地运行

进入后端目录后启动：

```
cd backend
mvn spring-boot:run
```

服务启动后访问：

```
http://localhost:8080/api/tasks
```

## 运行测试

```
cd backend
mvn test
```

当前已有 4 个自动化测试，最近一次执行结果为：`Tests run: 4, Failures: 0, Errors: 0`。

## 项目结构

```
task-hub/
├── README.md
└── backend/
    ├── src/main/java/com/yanhanqi/taskhub/
    │   ├── controller/
    │   ├── model/
    │   └── TaskHubApiApplication.java
    └── src/test/java/com/yanhanqi/taskhub/
        └── TaskHubApiApplicationTests.java
```

## 学习里程碑

- Day 1–10：Java、Git、Spring Boot 基础与项目初始化
- Day 11–16：完成任务查询、创建、完成与删除 API
- Day 17–18：为任务查询、创建和异常输入补充自动化测试
- 下一阶段：为“完成任务”和“删除任务”补充测试，并接入数据库持久化

## Git 提交约定

- `feat:` 新功能
- `test:` 测试
- `docs:` 文档
- `fix:` 缺陷修复
