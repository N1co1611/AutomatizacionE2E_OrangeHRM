package co.com.orangehrm.steps;

import co.com.orangehrm.interactions.EscribirCampoDeBusqueda;
import co.com.orangehrm.interactions.SeleccionarCoincidenciaEnListado;
import co.com.orangehrm.questions.ObjetoVisible;
import co.com.orangehrm.tasks.EsperarCargaPagina;
import co.com.orangehrm.tasks.dashboard.NavegarAlModulo;
import com.google.gson.JsonObject;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.orangehrm.userinterfaces.login.LoginPageUI.USERNAME_INPUT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static co.com.orangehrm.userinterfaces.directory.ConsultaEmpleadoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultaEmpleadoSteps {

    public void ConsultaPorNombre(){
        if (!ObjetoVisible.instancia(BUSQUEDA_POR_NOMBRE_INPUT).answeredBy(OnStage.theActorInTheSpotlight())) {
            OnStage.theActorInTheSpotlight().attemptsTo(Click.on(BOTON_DESPLEGAR_BUSQUEDA));
        }

        String NombreRecordado = theActorInTheSpotlight().recall("Empleado Nuevo");

        theActorInTheSpotlight().attemptsTo(
            EscribirCampoDeBusqueda.instancia(BUSQUEDA_POR_NOMBRE_INPUT,theActorInTheSpotlight().recall("Primer Nombre Empleado")),
            SeleccionarCoincidenciaEnListado.instancia(OPCIONES_LISTADO,theActorInTheSpotlight().recall("Empleado Nuevo")),
            Click.on(BOTON_BUSCAR),
            EsperarCargaPagina.completamente(),
            WaitUntil.the(PRIMER_RESULTADO, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
            Click.on(PRIMER_RESULTADO),
            WaitUntil.the(NOMBRE_SIDEBAR, isVisible()).forNoMoreThan(Duration.ofSeconds(20))
        );
    }

}
