package co.com.orangehrm.steps;

import co.com.orangehrm.questions.ObjetoVisible;
import co.com.orangehrm.tasks.EsperarCargaPagina;
import co.com.orangehrm.tasks.SubirImagen;
import co.com.orangehrm.tasks.dashboard.NavegarAlModulo;
import co.com.orangehrm.utils.GeneradorNombres;
import co.com.orangehrm.utils.GenerarNumeroAlAzar;
import com.google.gson.JsonObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.orangehrm.userinterfaces.directory.ConsultaEmpleadoUI.BOTON_DESPLEGAR_BUSQUEDA;
import static co.com.orangehrm.userinterfaces.directory.ConsultaEmpleadoUI.BUSQUEDA_POR_NOMBRE_INPUT;
import static co.com.orangehrm.userinterfaces.login.LoginPageUI.USERNAME_INPUT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static co.com.orangehrm.userinterfaces.pim.RegistroUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CrearNuevoEmpleadoSteps {

    public void NavegarAModulo(String modulo){
        theActorInTheSpotlight().attemptsTo(
            NavegarAlModulo.instancia(modulo),
            EsperarCargaPagina.completamente()
        );
    }

    public void CompletarRegistro(){
        JsonObject nombreGenerado = GeneradorNombres.generarNombreCompleto();

        String primerNombre = nombreGenerado.get("primerNombre").getAsString();
        String segundoNombre = nombreGenerado.get("segundoNombre").getAsString();
        String apellido = nombreGenerado.get("apellido").getAsString();
        String nombreCompleto = primerNombre + " " + segundoNombre + " " + apellido;

        theActorInTheSpotlight().attemptsTo(
            Click.on(BOTON_AGREGAR),
            EsperarCargaPagina.completamente(),
            Enter.theValue(primerNombre).into(PRIMER_NOMBRE),
            Enter.theValue(segundoNombre).into(SEGUNDO_NOMBRE),
            Enter.theValue(apellido).into(APELLIDO)
        );

        theActorInTheSpotlight().remember("Empleado Nuevo",nombreCompleto);
        theActorInTheSpotlight().remember("Primer Nombre Empleado",primerNombre);
        theActorInTheSpotlight().remember("Segundo Nombre Empleado",segundoNombre);
    }

    String rutaImagen = System.getProperty("user.dir") + "/src/test/resources/data/imagen.jpg";

    public void CargarImagen(){

        theActorInTheSpotlight().attemptsTo(
            SubirImagen.instancia(INPUT_IMAGEN, rutaImagen),
            Click.on(BOTON_ENVIAR_REGISTRO)
        );

        if (ObjetoVisible.instancia(MENSAJE_ERROR).answeredBy(OnStage.theActorInTheSpotlight())) {
            Serenity.takeScreenshot();
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Enter.theValue(GenerarNumeroAlAzar.generar(4)).into(INPUT_ID),
                    Click.on(BOTON_ENVIAR_REGISTRO)
            );
        }else{
            EsperarCargaPagina.completamente();
            WaitUntil.the(NOMBRE_CREADO, isVisible()).forNoMoreThan(Duration.ofSeconds(10));
        }
    }

}
