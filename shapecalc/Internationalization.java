import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {
    private ResourceBundle messages;

    public Internationalization(String language, String country) {
        Locale locale = new Locale(language, country);
        messages = ResourceBundle.getBundle("Messages", locale);
    }

    public String getMessage(String key, Object... params) {
        String message = messages.getString(key);
        return params.length > 0 ? String.format(message, params) : message;
    }
}
