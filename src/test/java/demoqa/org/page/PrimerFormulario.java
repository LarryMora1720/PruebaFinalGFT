package demoqa.org.page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class PrimerFormulario extends PaginaPrincipal {

    //Elementos Primer formulario

    @FindBy(id = "firstName")
    WebElement primerNombre;

    @FindBy(id = "lastName")
    WebElement apellidos;

    @FindBy(id = "email")
    WebElement correo;

    @FindBy(id = "birthMonth")
    WebElement mesNacimiento;

    @FindBy(id = "birthDay")
    WebElement diaNacimiento;

    @FindBy(id = "birthYear")
    WebElement añoNacimiento;

    @FindBy(xpath = "//button[span[text()='Next: Location']]")
    WebElement clickBotonNextLocation;


    public void sendkeyPrimerNombre(String name) {
        primerNombre.sendKeys(name); // Usa el parámetro correctamente
    }

    public void sendkeyApellido(String apellido) {
        apellidos.sendKeys(apellido); // Usa el parámetro correctamente
    }

    public void sendkeycorreo(String correoUsuario) {
        correo.sendKeys(correoUsuario); // Correo user
    }

    public void sendkeymesNacimiento() {

        WebElement listaDesplegableMes = getDriver().findElement(By.id("birthMonth"));
        // Encuentra el elemento de la lista desplegable por su identificador

        Select selecionMes = new Select(listaDesplegableMes);
        // Crear un objeto Select con el WebElement

        selecionMes.selectByIndex(1);
        // El índice comienza en 0// Seleccionar un valor por índice (por ejemplo, seleccionar el segundo elemento)

    }

    public void sendkeydiaNacimiento() {

        WebElement listaDesplegableDia = getDriver().findElement(By.id("birthDay"));
        Select seleccionDia = new Select(listaDesplegableDia);
        seleccionDia.selectByIndex(5);
    }

    public void sendkeyañoNacimiento() {

        WebElement listaDesplegableaño = getDriver().findElement(By.id("birthYear"));
        Select seleccionaño = new Select(listaDesplegableaño);
        //select.selectByIndex(6);//Se escoge por posición en la lista
        seleccionaño.selectByValue("2007");
    }

    public void clickBotonNextLocationYValidarPagina() {
        try {
            // Espera para el botón
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(
                    ExpectedConditions.elementToBeClickable(clickBotonNextLocation)
            );
            Thread.sleep(2000);
            boton.click();

            // Espera para la URL
            WebDriverWait waitUrl = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            boolean enPaginaCorrecta = waitUrl.until(
                    ExpectedConditions.urlToBe("https://www.utest.com/signup/address")
            );

            if (enPaginaCorrecta) {
                System.out.println("Ya estás en la página de dirección.");
            } else {
                System.out.println("La URL no es la esperada después de hacer clic.");
            }

        } catch (TimeoutException e) {
            System.out.println("Tiempo de espera agotado: No se encontró el botón o la URL no cargó.");
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'Next: Location' no existe en la página.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
