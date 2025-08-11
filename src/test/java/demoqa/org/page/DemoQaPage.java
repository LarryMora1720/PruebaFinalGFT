package demoqa.org.page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DemoQaPage extends PageObject {

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

    @FindBy(className = "material-icons")
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
public void clickBotonNextLocation() {
        clickBotonNextLocation.click();
}

    }







