package config;

import org.aeonbits.owner.ConfigFactory;

public class Application {

    public static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());

}
