package tests;

import com.codeborne.selenide.ElementsCollection;
import config.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SmartfonyUiTests extends TestBase {

    @BeforeEach
    public void stepOpenPage() {
        open("/smartfony-i-svyaz-10/smartfony-205?from=homepage");
    }

    @Test
    @DisplayName("Смарфоны. Провека отображения списка главной страницы.")
    void productCardsLayoutTest() {
        ElementsCollection collection = $$(".product-cards-layout__item without-border ng-star-inserted");

        for (var selenideElement : collection) {
            String ownText = selenideElement.getOwnText();

            assertThat(ownText).isNotBlank();
        }
    }

    @Test
    @DisplayName("Смарфоны. Проверка работы поиска.")
    void inputContainerTest() {
        String modelName = Application.config.modelName();
        $(".input__container").click();
        $(".input__field").setValue(modelName).pressEnter();
        $(".accessories-product-list").shouldHave(text(modelName));
    }

}
