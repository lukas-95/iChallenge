package com.iChallenge.notify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotifyController.class)
public class NotifyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotifyCheckService notifyCheckService;

    @MockBean
    private NotifyCheckHistoryRepository notifyCheckHistoryRepository;


    @Test
    public void testIsApproved() throws Exception {
        long personId = 1L;
        boolean isApproved = true;

        when(notifyCheckService.isApprovedPerson(personId)).thenReturn(isApproved);

        mockMvc.perform(get("/notifyCheck/" + personId))
                .andExpect(status().isOk());
    }

    @Test
    public void testDisapprovePerson() throws Exception {
        long personId = 1L;

        mockMvc.perform(post("/notifyCheck/" + personId + "/disapprove"))
                .andExpect(status().isNoContent());
    }





}
