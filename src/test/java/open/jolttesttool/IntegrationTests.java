package open.jolttesttool;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import open.jolttesttool.controllers.JoltQueryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    // https://github.com/spring-guides/gs-serving-web-content/blob/main/complete/src/test/java/com/example/servingwebcontent/ServingWebContentApplicationTest.java

    @Test
    public void testGetRoot() throws Exception {
        // N.B. jsoup can be useful for asserting HTML content
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString("Jolt Test Tool!")));
    }

    @Test
    public void testPostRoot() throws Exception {

    }

    @Test
    public void testPostUploadInputJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                    .file(new MockMultipartFile("file", "Hi bob".getBytes())))
                .andExpect(content().string(containsString("Jolt Test Tool!")));

    }

    @Test
    public void testPostUploadJoltJson() throws Exception {

    }

    @Test
    public void testPostDownload() throws Exception {

    }

}
