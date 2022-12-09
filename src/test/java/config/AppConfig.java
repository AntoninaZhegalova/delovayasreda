package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/app.properties"
})
public interface AppConfig extends Config {

    String baseUrl();

    @Key("header.x-set-application-id")
    String xSetApplicationId();
    @Key("header.sec-ch-ua-platform")
    String secChUaPlatform();
    @Key("header.User-Agent")
    String userAgent();

    @Key("cookie.MVID_CITY_ID")
    String cookieMvidCityId();
    @Key("cookie.MVID_REGION_ID")
    String cookieMvidRegionId();
    @Key("cookie.MVID_REGION_SHOP")
    String cookieMvidRegionShop();
    @Key("cookie.MVID_TIMEZONE_OFFSET")
    String cookieMvidTimezoneOffset();
    @Key("app.modelName")
    String modelName();
    @Key("app.categoryId")
    String categoryId();

}
