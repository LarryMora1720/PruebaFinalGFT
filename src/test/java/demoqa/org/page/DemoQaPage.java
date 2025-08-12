package demoqa.org.page;

import io.cucumber.java.eo.Se;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DemoQaPage extends PageObject {

    //Elementos primera pantalla
    @FindBy(className = "unauthenticated-nav-bar__sign-up")
    WebElement botonLogin;

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
/*
    @FindBy(xpath = "//button[contains(@class, 'btn btn-blue')]")
    WebElement clickBotonNextLocation;
*/
    @FindBy(xpath = "//button[span[text()='Next: Location']]")
    WebElement clickBotonNextLocation;

    public void openUrlPrueba(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    public void clickBotonJoinNow() {
        botonLogin.click(); // Hacer clic en el botón "Join Now"
    }

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
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            // Esperar que el botón sea clickeable
            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(clickBotonNextLocation));
            boton.click();

            // Validar que la URL sea la esperada
            boolean enPaginaCorrecta = wait.until(
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
        }
    }

    //Elementos segunda pantalla

    @FindBy(xpath = "//button[contains(@class, 'clear-btn')]")
        WebElement clickBotonLimpiar;

    @FindBy(xpath = "//button[contains(@class, 'clear-btn')]")//corregir
    WebElement ciudad;

    @FindBy(id = "zip")
    WebElement codPostal;

    @FindBy(id = "countryId")
    WebElement country;

    @FindBy(xpath = "//button[contains(@class,'btn btn-blue')]")
    WebElement nextDivices;

    public void clickBotonLimpiar() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clickBotonLimpiar));
        clickBotonLimpiar.click();
    }

    public void sendkeyCiudad(String City) {
        ciudad.sendKeys(City);
    }

    public void sendkeyPostalCode(String postalCode) {
        codPostal.sendKeys(postalCode);
    }

    public void sendkeyCountry() {
        WebElement listaDesplegableCountry = getDriver().findElement(By.id("countryId"));
        Select seleccionCountry = new Select(listaDesplegableCountry);
        //Se escoge por posición en la lista
        seleccionCountry.selectByIndex(5);

    }

    public void clickBotonNextDivices() {
        nextDivices.click();
    }
}









