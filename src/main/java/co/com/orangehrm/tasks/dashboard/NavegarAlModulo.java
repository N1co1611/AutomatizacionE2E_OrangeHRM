package co.com.orangehrm.tasks.dashboard;

import co.com.orangehrm.tasks.EsperarCargaPagina;
import co.com.orangehrm.userinterfaces.dashboard.DashboardPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.orangehrm.userinterfaces.dashboard.DashboardPageUI.*;
import static co.com.orangehrm.userinterfaces.login.LoginPageUI.USERNAME_INPUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarAlModulo implements Task {

    private final String nombreModulo;

    public NavegarAlModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public static NavegarAlModulo instancia(String nombreModulo) {
        return new NavegarAlModulo(nombreModulo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target modulo = DashboardPageUI.modulo(nombreModulo);
        actor.attemptsTo(
                Click.on(modulo),
                EsperarCargaPagina.completamente(),
                WaitUntil.the(modulo, isVisible()).forNoMoreThan(Duration.ofSeconds(20))
        );
    }
}
