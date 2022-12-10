package com.example.week9sq12360.controllers;

import com.example.week9sq12360.dto.AdminDto;
import com.example.week9sq12360.services.AdminService;
import com.example.week9sq12360.services.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class AdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private AdminService mockAdminService;

    @MockBean
    private UsersService usersService;

    private MockMvc mockMvc;

    private AdminDto adminDto;

    private List<AdminDto> adminDtoList;
    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        adminDto = new AdminDto();
        adminDto.setSurName("Bode");
        adminDto.setFirstName("Bamidele");
        adminDto.setEmail("bamidele@gmail.com");
        adminDto.setPassword("bamidele12");

        AdminDto adminDto1 = new AdminDto();
        adminDto1.setSurName("Aron");
        adminDto1.setFirstName("Jonathan");
        adminDto1.setEmail("jonathan@gmail.com");
        adminDto1.setPassword("jonathan12");

        adminDtoList = new ArrayList<>();
        adminDtoList.add(adminDto);
        adminDtoList.add(adminDto1);

    }

    @Test
    void addAdmin() throws Exception{
        when(mockAdminService.createAdmin(any(AdminDto.class))).thenReturn("successful");

        String jsonBody = "{\"surName\":\"Bode\", \"firstName\":\"Bamidele\", \"email\":\"bamidele@gmail.com\", " +
                "\"contact\":\"09034567891\", \"password\":\"bamidele12\"}";

        MvcResult mvcResult = mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody)
        )
                .andDo(print())
                .andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.surName").value("Bode"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Bamidele"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("bamidele@gmail.com"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.contact").value("09034567891"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("bamidele12"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
        verify(mockAdminService, times(1)).createAdmin(any(AdminDto.class));
    }

    @Test
    void createPost() {
    }

    @Test
    void postUpdate() {
    }

    @Test
    void deletePost() {
    }


}