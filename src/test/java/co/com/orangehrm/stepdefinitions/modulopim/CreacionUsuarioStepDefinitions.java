package co.com.orangehrm.stepdefinitions.modulopim;

import co.com.orangehrm.steps.LoginSteps;
import co.com.orangehrm.tasks.login.DoLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreacionUsuarioStepDefinitions {

    @Steps()
    LoginSteps loginSteps;

    @Given("^(.*) accede al portal de OrangeHRM")
    public void AccederAlPortalDeOrangeHRM(String actorName){
        loginSteps.abrirPortal(actorName);
        theActorInTheSpotlight().attemptsTo(
                new DoLogin(actorName)
        );

    }

    @When("el navega al módulo PIM")
    public void elNavegaAlModuloPIM() {
    }

    @And("agrega un nuevo empleado con nombre {string} y apellido {string}")
    public void agregaUnNuevoEmpleadoConNombreYApellido(String arg0, String arg1) {
    }

    @And("sube una foto de perfil para el empleado")
    public void subeUnaFotoDePerfilParaElEmpleado() {
    }

    @And("navega al módulo Directory")
    public void navegaAlModuloDirectory() {
    }

    @And("realiza una búsqueda por nombre {string}")
    public void realizaUnaBusquedaPorNombre(String arg0) {
    }

    @Then("valida que la información básica del empleado se haya almacenado correctamente")
    public void validaQueLaInformacionBasicaDelEmpleadoSeHayaAlmacenadoCorrectamente() {
    }
}
