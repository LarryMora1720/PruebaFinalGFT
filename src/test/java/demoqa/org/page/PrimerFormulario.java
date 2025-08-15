package demoqa.org.page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class PaginaPrincipal extends PageObject {

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
            // Espera para el botón
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(
                    ExpectedConditions.elementToBeClickable(clickBotonNextLocation)
            );
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
        }
    }

    //Elementos segunda pantalla del registro

    @FindBy(xpath = "//button[contains(@class, 'clear-btn')]")
    WebElement clickBotonLimpiar;

    @FindBy(xpath = "//button[contains(@class, 'clear-btn')]")
    WebElement ciudad;

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

    public void sendkeyPostalCode(String postalCode) {
        //WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        codPostal.sendKeys(postalCode);
    }

    public void sendkeyCountry() {
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

    //Elementos tercera pantalla del registro

    By clickUcomputer = By.xpath("//span[@aria-label='Select OS'][.//button[@aria-label='Clear Computer OS selection']]");
    By clickSoPc = By.xpath("//div[@ng-bind-html='device.name | highlight: $select.search' and normalize-space(.)='Windows']");
    // By clickSoMobile = By.xpath("//span[@aria-label='Select OS'][.//button[@aria-label='Clear Mobile OS selection']]");//segundo campo de Sistema operativo

    public void listaSistemaOperativo() {
        try {
            // Espera y clic para abrir la lista
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(
                    ExpectedConditions.elementToBeClickable(clickUcomputer)
            );
            boton.click();
            System.out.println("Botón 'lista computer' clickeado correctamente.");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: El botón 'computer' no estuvo listo.");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'computer' no existe en la página.");
            return;
        }

        try {
            // Espera y clic para seleccionar Windows
            WebDriverWait waitListaSoPC = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement opcionWindows = waitListaSoPC.until(
                    ExpectedConditions.elementToBeClickable(clickSoPc)
            );
            opcionWindows.click();
            System.out.println("'Windows' seleccionado correctamente.");
        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: La opción 'Windows' no estuvo disponible.");
        }
    }

}
/*
    public void clickEligeSistemaOperativo(String valorBusqueda) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Esperar que las opciones estén visibles
        List<WebElement> opcionesSo = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector("div[ng-bind-html*='device.name']")
                )
        );

        boolean encontrado = false;
        for (WebElement opcion : opcionesSo) {
            if (opcion.getText().trim().equalsIgnoreCase(valorBusqueda)) {
                opcion.click();
                encontrado = true;
                System.out.println("✅ Dispositivo seleccionado: " + valorBusqueda);
                break;
            }
        }

    }

 */