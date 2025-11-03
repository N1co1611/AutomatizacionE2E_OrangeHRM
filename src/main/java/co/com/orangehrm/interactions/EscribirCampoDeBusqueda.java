package co.com.orangehrm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.Duration;

public class EscribirCampoDeBusqueda implements Interaction {

    private final Target campoBusqueda;
    private final String texto;

    public EscribirCampoDeBusqueda(Target campoBusqueda, String texto) {
        this.campoBusqueda = campoBusqueda;
        this.texto = texto;
    }

    public static EscribirCampoDeBusqueda instancia(Target campoBusqueda, String texto) {
        return new EscribirCampoDeBusqueda(campoBusqueda, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(texto).into(campoBusqueda),
            WaitUntil.the(campoBusqueda, WebElementStateMatchers.isVisible())
                .forNoMoreThan(Duration.ofSeconds(10))
        );
    }
}
