package com.yanhanqi.taskhub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
class TaskHubApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void getTasksReturnsInitialTasks() throws Exception {
		mockMvc.perform(get("/api/tasks"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[1].title").value("学习 REST API"));
	}

	@Test
	void createTaskReturnsCreatedTask() throws Exception {
		mockMvc.perform(post("/api/tasks")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"title\": \"完成 Day 18\"}"))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.title").value("完成 Day 18"))
				.andExpect(jsonPath("$.completed").value(false));
	}

	@Test
	void createTaskWithBlankTitleReturnsBadRequest() throws Exception {
		mockMvc.perform(post("/api/tasks")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"title\":\"   \"}"))
				.andExpect(status().isBadRequest());
	}

	@Test
	void completeTaskMarksTaskCompleted() throws Exception {
		mockMvc.perform(patch("/api/tasks/1/complete"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.completed").value(true));
	}

	@Test
	void deleteMissingTaskReturnsNotFound() throws Exception {
		mockMvc.perform(delete("/api/tasks/99"))
				.andExpect(status().isNotFound());
	}

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	void deleteExistingTaskRemovesItFromTaskList() throws Exception {
		mockMvc.perform(delete("/api/tasks/1"))
				.andExpect(status().isNoContent());

		mockMvc.perform(get("/api/tasks"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[?(@.id == 1)]").isEmpty());
	}

	@Test
	void completeMissingTaskReturnsNotFound() throws Exception {
		mockMvc.perform(patch("/api/tasks/99/complete"))
				.andExpect(status().isNotFound());
	}
}
