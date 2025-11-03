package co.com.orangehrm.stepdefinitions.modulopim;

import co.com.orangehrm.questions.TextoDelCampo;
import co.com.orangehrm.steps.ConsultaEmpleadoSteps;
import co.com.orangehrm.steps.CrearNuevoEmpleadoSteps;
import co.com.orangehrm.steps.LoginSteps;
import co.com.orangehrm.tasks.EsperarCargaPagina;
import co.com.orangehrm.tasks.dashboard.NavegarAlModulo;
import co.com.orangehrm.tasks.login.DoLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.orangehrm.userinterfaces.directory.ConsultaEmpleadoUI.NOMBRE_SIDEBAR;
import static co.com.orangehrm.userinterfaces.directory.ConsultaEmpleadoUI.PRIMER_RESULTADO;
import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class CreacionUsuarioStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Steps
    CrearNuevoEmpleadoSteps CrearEmpleado;

    @Steps
    ConsultaEmpleadoSteps ConsultaEmpleado;

    @Given("^(.*) accede al portal de OrangeHRM")
    public void AccederAlPortalDeOrangeHRM(String actorName){
        loginSteps.abrirPortal(actorName);
        theActorInTheSpotlight().attemptsTo(
                new DoLogin(actorName)
        );
    }

    @When("el navega al módulo (.+)$")
    public void elNavegaAlModuloPIM(String modulo) {
        CrearEmpleado.NavegarAModulo(modulo);
    }

    @And("agrega un nuevo empleado con 2 nombres y un apellido")
    public void agregaUnNuevoEmpleadoConNombreYApellido() {
        CrearEmpleado.CompletarRegistro();
    }

    @And("sube una foto de perfil para el empleado")
    public void subeUnaFotoDePerfilParaElEmpleado() {
        CrearEmpleado.CargarImagen();
    }

    @And("navega al módulo (.+)$")
    public void navegaAlModuloDirectory(String modulo) {
        CrearEmpleado.NavegarAModulo(modulo);
    }

    @And("realiza una búsqueda por nombre del empleado creado")
    public void realizaUnaBusquedaPorNombre() {
        ConsultaEmpleado.ConsultaPorNombre();
    }

    @Then("valida que la información básica del empleado se haya almacenado correctamente")
    public void validaQueLaInformacionBasicaDelEmpleadoSeHayaAlmacenadoCorrectamente() {
        String NombreRecordado = theActorInTheSpotlight().recall("Empleado Nuevo");

        System.out.println(TextoDelCampo.visibleEn(NOMBRE_SIDEBAR));
        System.out.println(NombreRecordado);
        theActorInTheSpotlight().should(
                seeThat(TextoDelCampo.visibleEn(NOMBRE_SIDEBAR), containsString(NombreRecordado))
        );
    }
}
