package co.com.orangehrm.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TextoDelCampo implements Question<String> {

    private final Target campo;

    private TextoDelCampo(Target campo) {
        this.campo = campo;
    }

    public static TextoDelCampo visibleEn(Target campo) {
        return new TextoDelCampo(campo);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(campo).answeredBy(actor);
    }
}
