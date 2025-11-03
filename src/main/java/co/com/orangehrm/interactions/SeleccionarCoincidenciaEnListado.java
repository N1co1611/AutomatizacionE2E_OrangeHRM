package co.com.orangehrm.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class SeleccionarCoincidenciaEnListado implements Interaction {

    private final Target opcionesListado;
    private final String nombreCompleto;

    public SeleccionarCoincidenciaEnListado(Target opcionesListado, String nombreCompleto) {
        this.opcionesListado = opcionesListado;
        this.nombreCompleto = nombreCompleto;
    }

    public static SeleccionarCoincidenciaEnListado instancia(Target opcionesListado, String nombreCompleto) {
        return new SeleccionarCoincidenciaEnListado(opcionesListado, nombreCompleto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(opcionesListado, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10))
        );

        List<WebElementFacade> opciones = opcionesListado.resolveAllFor(actor);

        WebElementFacade coincidencia = opciones.stream()
                .filter(opcion -> opcion.getText().contains(nombreCompleto))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró una coincidencia con: " + nombreCompleto));

        actor.attemptsTo(Click.on(coincidencia));
    }
}
