package open.jolttesttool.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileReader{

    public String doFileRead(MultipartFile file){
        try {
            return new String(file.getBytes());
        } catch (Exception e) {}
        return null;
    }
}
