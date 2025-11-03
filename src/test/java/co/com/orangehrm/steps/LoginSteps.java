package co.com.orangehrm.steps;

import co.com.orangehrm.stepdefinitions.Setup;
import co.com.orangehrm.tasks.EsperarCargaPagina;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.orangehrm.userinterfaces.login.LoginPageUI.USERNAME_INPUT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginSteps {

    private static final Setup setup = new Setup();

    public void abrirPortal(String actorName){
        setup.setupActor(actorName);
        theActorInTheSpotlight().attemptsTo(
                Open.browserOn().thePageNamed("pages.orangehrm"),
                EsperarCargaPagina.completamente(),
                WaitUntil.the(USERNAME_INPUT, isVisible()).forNoMoreThan(Duration.ofSeconds(20))
        );
        Serenity.takeScreenshot();
    }

}
