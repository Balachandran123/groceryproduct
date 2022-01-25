package com.groceryproduct.productms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groceryproduct.productms.entity.Product;
import com.groceryproduct.productms.response.entity.ErrorInfo;
import com.groceryproduct.productms.response.entity.SuccessInfo;
import com.groceryproduct.productms.service.ProductServiceImpl;
@SpringBootTest
class ProductmsApplicationTests 
{
	
	private  MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeEach
	public  void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
		
	@Autowired
	ProductServiceImpl ps;
	
    
	@Test
	void ftGetProductById() throws Exception
	{
		MvcResult result = mockMvc.perform(get("/products/id/{id}",0)
				                  .accept(MediaType.APPLICATION_JSON))
	                              .andDo(print())
	                              .andExpect(status().isNotFound())
	                              .andReturn();
		String resultContent = result.getResponse().getContentAsString();
		//ErrorInfo info = om.readValue(resultContent, ErrorInfo.class);
		//assertEquals(404,info.getStausCode());
	}
	

	@Test
	void ftGetProductByType() throws Exception
	{
		MvcResult result = mockMvc.perform(get("/products/type/{name}","Pizza").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        //ErrorInfo info = om.readValue(resultContent, ErrorInfo.class);
        //assertEquals(404,info.getStausCode());		
	}
	
	
	@Test
	void ftDeleteProduct() throws Exception
	{
		MvcResult result = mockMvc.perform(delete("/products/id/{id}",99)
				.accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
		String resultContent = result.getResponse().getContentAsString();
        //ErrorInfo info = om.readValue(resultContent, ErrorInfo.class);
       // assertEquals(404,info.getStausCode());
		
	}
}
