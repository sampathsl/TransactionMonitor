package com.n26.main;

import com.n26.main.domain.Transaction;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by SAMPATH on 4/23/2017.
 *  Test for sample transaction saving in the collection
 */
@Ignore
public class AsyncSaveTransactionTest extends AbstractControllerTest {

    private final String URI = "/transactions";

    @Test
    public void getInitialTransactionStatistics() throws Exception {

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON).
                        content(toJson(getSampleTransaction()).getBytes("UTF-8"));

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                .isCreated())
                .andExpect(content().string(""));

    }

    private Transaction getSampleTransaction() {
        return new Transaction(7,Instant.now().getEpochSecond() * 1000);
    }

}
