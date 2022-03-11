package open.jolttesttool;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import open.jolttesttool.controllers.JoltQueryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = JoltQueryController.class)
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    // https://github.com/spring-guides/gs-serving-web-content/blob/main/complete/src/test/java/com/example/servingwebcontent/ServingWebContentApplicationTest.java

    @Test
    public void testGetRoot() throws Exception {
        // N.B. jsoup can be useful for asserting HTML content
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString("?")));
    }

    @Test
    public void testPostRoot() throws Exception {

    }

    @Test
    public void testPostUploadInputJson() throws Exception {

    }

    @Test
    public void testPostUploadJoltJson() throws Exception {

    }

    @Test
    public void testPostDownload() throws Exception {

    }

}
