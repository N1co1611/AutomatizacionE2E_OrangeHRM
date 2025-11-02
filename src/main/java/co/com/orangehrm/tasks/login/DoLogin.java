package co.com.orangehrm.tasks.login;

import co.com.orangehrm.tasks.EsperarCargaPagina;
import co.com.orangehrm.utils.CredencialesReader;
import com.google.gson.JsonObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.orangehrm.userinterfaces.login.LoginPageUI.*;

public class DoLogin implements Performable {

    private final String actorName;

    public DoLogin(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(actorName);
        JsonObject credenciales = CredencialesReader.getCredencialesPorRol(actorName);
        String usuario = credenciales.get("Username").getAsString();
        String password = credenciales.get("Password").getAsString();
        actor.attemptsTo(
                Scroll.to(USERNAME_INPUT),
                Enter.theValue(usuario).into(USERNAME_INPUT),
                Scroll.to(PASSWORD_INPUT),
                Enter.theValue(password).into(PASSWORD_INPUT),
                Click.on(BOTON_LOGIN),
                EsperarCargaPagina.completamente()
        );
    }

}
