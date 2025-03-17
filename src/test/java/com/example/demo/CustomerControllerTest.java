//package com.example.demo;
//
//
//import com.children.care.controller.CustomerController;
//import com.children.care.entity.Customer;
//import com.children.care.service.CustomerService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@ExtendWith(MockitoExtension.class)
//class CustomerControllerTest {
//    @Mock
//    private CustomerService customerService;
//
//    @InjectMocks
//    private CustomerController customerController;
//
//    private MockMvc mockMvc;
//    private Customer customer;
//
//    @BeforeEach
//    void setUp() {
//        customer = new Customer();
//        customer.setId(1L);
//        customer.setFullName("John Doe");
//        customer.setEmail("john@example.com");
//
//        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
//    }
//
//    @Test
//    void getAllCustomers_ShouldReturnOkStatus() throws Exception {
//        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(customer));
//        mockMvc.perform(get("/api/customers"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void saveCustomer_ShouldReturnCreatedStatus() throws Exception {
//        when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);
//        mockMvc.perform(post("/api/customers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"fullName\":\"John Doe\",\"email\":\"john@example.com\"}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void deleteCustomer_ShouldReturnNoContentStatus() throws Exception {
//        doNothing().when(customerService).deleteCustomer(1L);
//        mockMvc.perform(delete("/api/customers/1"))
//                .andExpect(status().isOk());
//    }
//}
