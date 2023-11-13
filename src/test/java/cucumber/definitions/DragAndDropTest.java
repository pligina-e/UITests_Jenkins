package cucumber.definitions;

import cucumber.pages.DragAndDropPage;
import cucumber.utils.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DragAndDropTest {
    DragAndDropPage dragAndDropPage = new DragAndDropPage(HelperClass.getDriver());

    @Given("Открываем {string}")
    public void openPage(String url) {
        HelperClass.openPage(url);
    }

    @When("Пользователь мышкой перетаскивает элемент в принимающий")
    public void dragAndDropElement() {
        dragAndDropPage.dragAndDropElement();
    }

    @Then("Текст принимающего элемента изменился")
    public void reviewTextReceivingElement() {
        Assert.assertEquals("Dropped!", dragAndDropPage.getTextReceivingElement(), "Текст принимающего элемента не корректен, drag&drop не произошел");
    }
}
