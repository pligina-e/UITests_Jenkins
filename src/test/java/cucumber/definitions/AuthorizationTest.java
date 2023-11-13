package cucumber.definitions;

import cucumber.pages.AuthorizationPage;
import cucumber.utils.HelperClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class AuthorizationTest {
    AuthorizationPage authorizationPage = new AuthorizationPage(HelperClass.getDriver());

    @Given("Открыть страницу {string}")
    public void openPage(String url) {
        HelperClass.openPage(url);
    }

    @When("Пользователь нажимает на кнопку \"Resources\"")
    public void clickOnButtonResources() {
        authorizationPage.pressMenuButtonResources();
    }

    @When("Пользователь в раскрывшемся меню нажимает на пункт \"Practice Site 2\"")
    public void clickOnButtonPracticeSite() {
        authorizationPage.pressMenuButtonPracticeSite();
    }

    @When("Пользователь нажимает на кнопку \"Registration\"")
    public void clickOnImageRegistrationButton() {
        authorizationPage.pressImageRegistration();
    }

    @When("Пользователь вводит логин {string}, пароль {string}, описание {string}")
    public void fillFieldsOnPage(String login, String password, String description) {
        authorizationPage.fillFields(login, password, description);
    }

    @When("Пользователь вводит данные")
    public void fillFieldsOnPage(DataTable arg) {
        List<List<String>> table = arg.asLists(String.class);
        authorizationPage.fillFields(table.get(0).get(0), table.get(0).get(1), table.get(0).get(2));
    }

    @When("Пользователь нажимает на кнопку \"Login\"")
    public void clickOnLoginButton() {
        authorizationPage.pressLoginButton();
    }

    @Then("Открылась страница, которая содержит текст {string}")
    public void reviewTextPage(String text) {
        Assert.assertEquals(text, authorizationPage.getLabelText(), "Что-то пошло не так при авторизации");
    }

    @Then("Страница содержит ошибку {string}")
    public void reviewTextError(String text) {
        Assert.assertEquals(text, authorizationPage.getErrorText(), "Текст ошибки не совпадает с текстом \"Username or password is incorrect\"");
    }

    @Then("Открытая страница имеет url {string}")
    public void reviewPageURL(String url) {
        Assert.assertEquals(url, HelperClass.getDriver().getCurrentUrl(), "Что-то пошло не так при авторизации. Url не совпадают");
    }
}
