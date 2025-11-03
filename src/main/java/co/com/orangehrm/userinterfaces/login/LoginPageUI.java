package co.com.orangehrm.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPageUI extends PageObject {
    public static final Target USERNAME_INPUT = Target.the("Input Username").located(By.xpath("//input[@placeholder='Username']"));
    public static final Target PASSWORD_INPUT = Target.the("Input Password").located(By.xpath("//input[@placeholder='Password']"));
    public static final Target BOTON_LOGIN = Target.the("Boton Ingreso Login").located(By.xpath("//button[@type='submit']"));
}
