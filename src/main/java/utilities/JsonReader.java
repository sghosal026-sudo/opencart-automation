package utilities;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {

    public static Map<String, String> readJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                new File("src/test/java/data/LoginData/LoginInvalidCredentials.json"),
                new TypeReference<Map<String, String>>() {
                }
        );
    }
}