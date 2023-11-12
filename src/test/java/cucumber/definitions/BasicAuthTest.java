package cucumber.definitions;

import cucumber.pages.BasicAuthPage;
import cucumber.utils.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BasicAuthTest {
    BasicAuthPage basicAuthPage = new BasicAuthPage();

    @Given("Открываем страницу {string}")
    public void openPage(String url) {
        HelperClass.openPage(url);
    }

    @When("Пользователь нажимает на кнопку \"Display Image\"")
    public void clickOnDisplayImageButton() {
        basicAuthPage.clickOnButton();
    }

    @When("Пользователь вводит в promt dialog корректный логин и пароль")
    public void writeLoginPassword() {
        //данные передаются по url
    }

    @When("Пользователь нажимает на кнопку \"Вход\"")
    public void clickOnLoginButton() {
        //не требуется благодаря тому, что данные передаются по url
    }

    @Then("Появляется картинка с введенными ранее данными")
    public void presenceOfImageWithData() {
        Assert.assertTrue(basicAuthPage.presenceOfImage(), "Картинка не появилась. Возможно, были указаны неверные данные => вход на сайт не выполнен");
    }
}
