package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testSet() {
        KeyValueStorage storage = new FileKV(filepath.toString());
        storage.set("key", "value");
        assert storage.get("key", "default").equals("value");
    }

    @Test
    public void testUnset() {
        KeyValueStorage storage = new FileKV(filepath.toString());
        storage.set("key", "value");
        storage.unset("key");
        assert storage.get("key", "default").equals("default");
    }

    @Test
    public void mustBeImmutableTest() {
        KeyValueStorage storage = new FileKV(filepath.toString());
        storage.set("key", "value");
        storage.toMap().put("key2", "value2");
        assert storage.get("key2", "default").equals("default");
    }

    @Test
    public void testSwapKeyValue() {
        KeyValueStorage storage = new FileKV(filepath.toString());
        storage.set("key1", "value1");
        storage.set("key2", "value2");
        storage.set("key3", "value3");
        App.swapKeyValue(storage);
        assert storage.get("value1", "default1").equals("key1");
        assert storage.get("value2", "default2").equals("key2");
        assert storage.get("value3", "default3").equals("key3");
    }
    // END
}
