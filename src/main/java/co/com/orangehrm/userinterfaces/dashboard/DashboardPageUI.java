package co.com.orangehrm.userinterfaces.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DashboardPageUI extends PageObject {
    public static Target modulo(String nombreModulo){
        String xpath = String.format("//span[text()='%s']/ancestor::li", nombreModulo);
        return Target.the("Opción módulo " + nombreModulo).located(By.xpath(xpath));
    }

}
