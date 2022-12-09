package tests;

import config.Application;
import models.ProductDetailsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static io.restassured.RestAssured.given;

import static org.assertj.core.api.Assertions.assertThat;
import static spec.SearchSpec.requestSpec;

class ProductsApiTests {

    @Test
    @DisplayName("Должен венуть статус 200 при запросе по индификатору категории.")
    void returnList(){
        String categoryId = Application.config.categoryId();
        given()
                .spec(requestSpec)
                .get("/bff/products/listing?categoryId=" + categoryId)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Должен вернуть список описания продуктов по списку идентификаторов.")
    void returnListHonor() {
        InputStream request = this.getClass().getClassLoader().getResourceAsStream("json/product-details-request.json");

        ProductDetailsResponse productDetailsResponse = given()
                .spec(requestSpec)
                .body(request)
                .log().all()
                .when()
                .post("/bff/product-details/list")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .as(ProductDetailsResponse.class);

        assertThat(productDetailsResponse).isNotNull();
        List<ProductDetailsResponse.Product> products = productDetailsResponse.getBody().getProducts();
        assertThat(products).isNotEmpty();
        for (var product : products) {
            assertThat(product.getProductId()).isNotBlank();
        }
    }

}
