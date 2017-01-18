import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class JsonConverter {
    JsonNode convert(String initialRecord) throws IOException {
        return new ObjectMapper().readTree(initialRecord);
    }
}

