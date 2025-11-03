package co.com.orangehrm.userinterfaces.directory;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ConsultaEmpleadoUI extends PageObject {
    public static final Target BUSQUEDA_POR_NOMBRE_INPUT = Target.the("Input Busqueda de Empleado por Nombre").located(By.xpath("//input[contains(@placeholder, 'Type for hints')]"));
    public static final Target BOTON_BUSCAR = Target.the("Boton para hacer la busqueda").located(By.xpath("//button[contains(@type, 'submit')]"));
    public static final Target BOTON_DESPLEGAR_BUSQUEDA = Target.the("Boton para desplegar las opciones de busqueda").located(By.xpath("//button[i[contains(@class, 'bi-caret-down-fill')]]"));
    public static final Target OPCIONES_LISTADO = Target.the("Opciones del listado de coincidencias").located(By.xpath("//div[@role='listbox']//span"));
    public static final Target PRIMER_RESULTADO = Target.the("Primer Resultado de la busqueda").located(By.xpath("//div[@class='orangehrm-container']/div/div[1]/div/p"));
    public static final Target NOMBRE_SIDEBAR = Target.the("Nombre del empleado seleccionado despues de la busqueda").located(By.xpath("//div[contains(@class, 'orangehrm-corporate-directory-sidebar')]/div/div/p[1]"));

}
