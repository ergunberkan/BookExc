package com.example.BookExc;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import  org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import  org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
class BookExcApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	@Test
	public void testAllUsers()throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/bookexc/v1/users")
		.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*].user_name").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*].email").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$[*].name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$[*].sur_name").exists());
	}
	@Test
	public void testAllExchange() throws Exception
	{
	mockMvc.perform(MockMvcRequestBuilders.get("/bookexc/exc/Exchanges")
			.accept(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
