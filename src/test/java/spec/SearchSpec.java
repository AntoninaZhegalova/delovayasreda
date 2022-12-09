package spec;

import config.AppConfig;
import config.Application;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class SearchSpec {
    private static final AppConfig config = Application.config;
    private static final String baseUrl = Application.config.baseUrl();
    public static RequestSpecification requestSpec = with()
            .baseUri(baseUrl)
            .log().uri()
            .contentType(JSON)
            .header("Origin", baseUrl)
            .header("referer", baseUrl)
            .header("x-set-application-id", config.xSetApplicationId())
            .header("sec-ch-ua-platform", config.secChUaPlatform())
            .header("User-Agent", config.userAgent())
            .cookie("MVID_CITY_ID", config.cookieMvidCityId())
            .cookie("MVID_REGION_ID", config.cookieMvidRegionId())
            .cookie("MVID_REGION_SHOP", config.cookieMvidRegionShop())
            .cookie("MVID_TIMEZONE_OFFSET", config.cookieMvidTimezoneOffset());
}
