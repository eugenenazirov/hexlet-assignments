package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;

    public FileKV(String path) {
        this.path = path;
    }

    @Override
    public void set(String key, String value) {
        String json = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(json);
        map.put(key, value);
        json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    @Override
    public void unset(String key) {
        String json = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(json);
        map.remove(key);
        json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    @Override
    public String get(String key, String defaultValue) {
        String json = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(json);
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String json = Utils.readFile(path);
        return Utils.unserialize(json);
    }
}
// END
