package exercise;

import java.util.List;

// BEGIN
public class App {
    private static List<String> freeDomains = List.of("gmail.com", "yandex.ru", "hotmail.com");
    public static long getCountOfFreeEmails(List<? extends String> emails) {
        return emails.stream()
                .filter(App::isEmailOnFreeDomain)
                .count();
    }

    private static boolean isEmailOnFreeDomain(String email) {
        if (email.isBlank() || !email.contains("@")) {
            return false;
        }

        String domain = email.split("@")[1];
        return freeDomains.stream()
                .anyMatch(freeDomain -> freeDomain.equals(domain));
    }
}
// END
