package open.jolttesttool.services;

import org.springframework.stereotype.Service;

@Service
public class JoltTransformerImpl  implements  JoltTransformer{

    public String doJoltTransform(String input, String joltSpec){
        return "{}";
    }
}
