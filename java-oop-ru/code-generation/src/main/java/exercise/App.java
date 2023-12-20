package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


// BEGIN
public class App {
    public static void save(Path pathToFile, Car car) {
        try {
            Files.writeString(pathToFile, car.serialize(), StandardOpenOption.CREATE);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Car extract(Path pathToFile) {
        try {
            return Car.unserialize(Files.readString(pathToFile));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
// END
