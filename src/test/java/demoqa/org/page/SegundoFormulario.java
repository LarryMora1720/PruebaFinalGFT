package demoqa.org.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SegundoFormulario extends PaginaPrincipal {


    //Elementos segunda pantalla del registro

    @FindBy(xpath = "//button[contains(@class, 'clear-btn')]")
    WebElement clickBotonLimpiar;

    By listaCity = By.cssSelector("input[type='search']");
    By opcionDelaLista = By.cssSelector("ngf-option .option");

    @FindBy(id = "zip")
    WebElement codPostal;

    @FindBy(id = "countryId")
    WebElement country;

    @FindBy(xpath = "//button[span[text()='Next: Devices']]")
    WebElement clickBotonNextDivices;

    public void clickBotonLimpiar() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            // Esperar que el WebElement sea visible y clickeable
            wait.until(ExpectedConditions.visibilityOf(clickBotonLimpiar));
            wait.until(ExpectedConditions.elementToBeClickable(clickBotonLimpiar));

            clickBotonLimpiar.click();
            System.out.println("Botón 'Limpiar' clickeado correctamente.");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: El botón 'Limpiar' no estuvo listo.");
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'Limpiar' no existe en la página.");
        }
    }

    public void sendkeyCiudad(String textoBusqueda, String opcionDeseada) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Localizar el input por tipo search
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(listaCity));
        input.clear();
        input.sendKeys(textoBusqueda);

        List<WebElement> opciones = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(opcionDelaLista, 0));

        // Esperar que la lista de opciones aparezca
        List<WebElement> elemento = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(opcionDelaLista));// <-- aquí va la clase real de las opciones


        for (WebElement opcion : opciones) {
            if (opcion.getText().trim().equals("Bogotá, Bogota, Colombia")) {
                opcion.click();
                break;
            }
        }

    }


    public void sendkeyPostalCode(String postalCode) throws InterruptedException {
        //WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        Thread.sleep(2000);
        codPostal.sendKeys(postalCode);
    }

    public void sendkeyCountry() throws InterruptedException {
        WebElement listaDesplegableCountry = getDriver().findElement(By.id("countryId"));
        Select seleccionCountry = new Select(listaDesplegableCountry);
        //Se escoge por posición en la lista
        seleccionCountry.selectByIndex(5);

    }

    public void clickBotonNextDivices() {
        try {
            // Espera para el botón
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(
                    ExpectedConditions.elementToBeClickable(clickBotonNextDivices)
            );
            boton.click();

            // Espera para la URL
            WebDriverWait waitUrl = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            boolean enPaginaCorrecta = waitUrl.until(
                    ExpectedConditions.urlToBe("https://www.utest.com/signup/devices")
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


}
