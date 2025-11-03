package co.com.orangehrm.userinterfaces.pim;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroUI {
    public static final Target BOTON_AGREGAR = Target.the("Boton Agregar Empleado").located(By.xpath("//button[contains(., 'Add')]"));
    public static final Target PRIMER_NOMBRE = Target.the("Input Primer Nombre").located(By.xpath("//input[@name='firstName']"));
    public static final Target SEGUNDO_NOMBRE = Target.the("Input Segundo Nombre").located(By.xpath("//input[@name='middleName']"));
    public static final Target APELLIDO = Target.the("Input Apellido").located(By.xpath("//input[@name='lastName']"));
    public static final Target BOTON_ENVIAR_REGISTRO = Target.the("Boton para agregar al empleado").located(By.xpath("//button[@type='submit']"));
    public static final Target INPUT_IMAGEN = Target.the("input para subir imagen").located(By.xpath("//input[@type='file']"));
    public static final Target NOMBRE_CREADO = Target.the("Nombre del empleado despues de crearlo").located(By.xpath("//div[contains(@class,'orangehrm-edit-employee-name')]"));
    public static final Target MENSAJE_ERROR = Target.the("Mensaje de error id duplicado").located(By.xpath("//span[contains(@class, 'error-message')]"));
    public static final Target INPUT_ID = Target.the("Mensaje de error id duplicado").located(By.xpath("//span[contains(@class, 'error-message')]/preceding::input[1]"));
}
