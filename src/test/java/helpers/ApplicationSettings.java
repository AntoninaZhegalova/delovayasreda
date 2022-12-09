package helpers;

import com.codeborne.selenide.Configuration;
import config.Application;

public class ApplicationSettings {
    public static void configure() {
        Configuration.baseUrl = Application.config.baseUrl();
    }
}
