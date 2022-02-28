package open.jolttesttool.services;

import org.springframework.stereotype.Service;

public interface JoltTransformer {

    String doJoltTransform(String input, String joltSpec);
}
