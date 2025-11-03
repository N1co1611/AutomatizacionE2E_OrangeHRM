package co.com.orangehrm.questions;

import co.com.orangehrm.tasks.dashboard.NavegarAlModulo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ObjetoVisible implements Question<Boolean> {

    private final Target elemento;

    public ObjetoVisible(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return elemento.resolveFor(actor).isVisible();
    }

    public static ObjetoVisible instancia(Target elemento) {
        return new ObjetoVisible(elemento);
    }
}
