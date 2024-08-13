package open.jolttesttool.services;

import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;

public class TestFileReader {

    @Test
    public void TestDoJoltTransform(){
        FileReader a = new FileReader();

        MultipartFile b = new MultipartFile(){

            public String getName() { return null; }
            public String getOriginalFilename() { return null; }
            public String getContentType() { return null; }
            public boolean isEmpty() { return false; }
            public long getSize() { return 0; }
            public InputStream getInputStream() throws IOException { return null; }
            public void transferTo(File dest) throws IOException, IllegalStateException {}

            public byte[] getBytes() throws IOException {
                return "Hello World".getBytes();
            }
        };


        Assertions.assertEquals("Hello World", a.doFileRead(b));
    }
}
