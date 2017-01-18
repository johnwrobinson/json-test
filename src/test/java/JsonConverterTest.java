import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

public class JsonConverterTest {
    @Test
    public void itConvertsTheJson () throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String initialRecord = IOUtils.toString(classLoader.getResourceAsStream("incomingDataRecord.json"));

        JsonNode expectedJson = new ObjectMapper()
                .readTree(IOUtils.toString(classLoader.getResourceAsStream("queuedDataRecord.json")));

        JsonNode converted = new JsonConverter().convert(initialRecord);
        assertThat(converted, hasItem(expectedJson));
    }

}