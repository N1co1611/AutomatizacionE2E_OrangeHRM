package co.com.orangehrm.steps;

import co.com.orangehrm.stepdefinitions.Setup;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps {

    private static final Setup setup = new Setup();

    public void abrirPortal(String actorName){
        setup.setupActor(actorName);
        theActorInTheSpotlight().attemptsTo(
                Open.browserOn().thePageNamed("pages.orangehrm")
        );
    }

}
