package cucumber.definitions;

import cucumber.pages.PresenceElementsPage;
import cucumber.utils.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class PresenceElementsTest {
    PresenceElementsPage presenceElementsPage = new PresenceElementsPage(HelperClass.getDriver());

    @Given("Открываем страничку {string}")
    public void openPage(String url) {
        HelperClass.openPage(url);
    }

    @When("Пользователь проверяет наличие хидера с реквизитами для связи")
    public void lookingHeader() {
    }

    @When("Пользователь проверяет наличие горизонтального меню")
    public void lookingMenu() {
    }

    @When("Пользователь проверяет наличие блока с сертификацией")
    public void lookingCertificationBlock() {
    }

    @When("Пользователь проверяет наличие блока с курсами")
    public void lookingCoursesBlock() {
    }

    @When("Пользователь проверяет наличие футера")
    public void lookingFooter() {
    }

    @Then("Title открытой страницы содержит {string}")
    public void desiredPage(String text) {
        Assert.assertTrue(HelperClass.getDriver().getTitle().contains(text),"Title страницы не содержит \"Way2Automation\". Открылась не главная страница");
    }

    @Then("Хидер виден на странице и содержит соответствующие реквизиты для связи")
    public void presenceOfHeaderOnPage() {
        List<String> actualListOfHeaderLinks = List.of("+919711-111-558", "+919711-191-558", "+1 646-480-0603", "seleniumcoaching", "trainer@way2automation.com");

        Assert.assertTrue(presenceElementsPage.presenceOfHeader(), "Хидер не найден на странице");
        Assert.assertEquals(actualListOfHeaderLinks, presenceElementsPage.getContactDetailsOfHeader(), "Хидер с реквизитами для связи некорректен");
    }

    @Then("Горизонтальное меню видно на странице и оно содержит соответствующие ссылки")
    public void presenceOfMenuOnPage() {
        List<String> actualListOfMenuLinks = List.of("Home", "All Courses", "Video Tutorial", "Resources", "Careers", "Lifetime Membership", "Blog", "Forum", "Member Login");

        Assert.assertTrue(presenceElementsPage.presenceOfMenu(), "Горизонтальное меню не найдено на странице");
        Assert.assertEquals(actualListOfMenuLinks, presenceElementsPage.getLinksOfHorizontalMenu(), "Горизонтальное меню содержит некорректные ссылки");
    }

    @Then("Блок с сертификацией виден на странице и содержит текст {string}")
    public void presenceOfCertificationBlockOnPage(String text) {
        Assert.assertEquals(text, presenceElementsPage.titleOfCertificationBlock(), "Некорректное название блока сертификации");
        Assert.assertTrue(presenceElementsPage.presenceOfCertificationBlock(), "Блок сертификации не найден на странице");
    }

    @Then("Блок с курсами виден на странице и содержит текст {string}")
    public void presenceOfCoursesBlockOnPage(String text) {
        Assert.assertEquals(text, presenceElementsPage.titleOfCoursesBlock(), "Некорректное название блока курсов");
        Assert.assertTrue(presenceElementsPage.presenceOfCoursesBlock(), "Блок с курсами не найден на странице");
    }

    @Then("Футер виден на странице")
    public void presenceOfFooterOnPage() {
        Assert.assertTrue(presenceElementsPage.presenceOfFooter(), "Футер не найден на странице");
    }
}
