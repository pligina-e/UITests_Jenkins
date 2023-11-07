package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DroppablePage;

@Epic("Тестирование страницы droppable.php")
@Feature("Возможность перетаскивания мышкой элемента на странице")
public class ActionDragDropTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь мышкой перетаскивает элемент в принимающий, чтобы текст принимающего элемента изменился")
    public final void dragAndDropTest() {
        DroppablePage droppablePage = new DroppablePage(driver);
        droppablePage.dragAndDropElement();
        Assert.assertEquals("Dropped!", droppablePage.getTextReceivingElement(), "Текст принимающего элемента не корректен, drag&drop не произошел");
    }
}
