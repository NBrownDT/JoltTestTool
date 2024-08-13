package open.jolttesttool.services;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class FileReader{

    public String doFileRead(MultipartFile file){
        try {
            return new String(file.getBytes());
        } catch (Exception e) {}
        return null;
    }
}
