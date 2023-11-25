package com.stockmanager;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetAllItems() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/item")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}