package co.com.orangehrm.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.JavascriptExecutor;

import static co.com.orangehrm.userinterfaces.pim.RegistroUI.INPUT_IMAGEN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SubirImagen implements Task {

    private final Target inputArchivo;
    private final String rutaImagen;

    public SubirImagen(Target inputArchivo, String rutaImagen) {
        this.inputArchivo = inputArchivo;
        this.rutaImagen = rutaImagen;
    }

    public static SubirImagen instancia(Target inputArchivo, String rutaImagen) {
        return new SubirImagen(inputArchivo, rutaImagen);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade input = inputArchivo.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].style.display='block'; arguments[0].style.opacity=1;", input);
        input.sendKeys(rutaImagen);
    }
}
