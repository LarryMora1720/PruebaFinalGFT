package demoqa.org.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TercerFormulario extends PaginaPrincipal {


    //Elementos tercera pantalla del registro

    By clickUcomputer = By.xpath("//span[@aria-label='Select OS'][.//button[@aria-label='Clear Computer OS selection']]");
    By clickSoPc = By.xpath("//div[@ng-bind-html='device.name | highlight: $select.search' and normalize-space(.)='Windows']");

    By clickVersion = By.xpath("//*[@id=\"web-device\"]/div[2]/div[2]/div/div[1]/span");
    By clickSelectAVersion = By.xpath("//*[@id=\"ui-select-choices-row-1-26\"]/span/div");


    By clickLanguage = By.xpath("//*[@id=\"web-device\"]/div[3]/div[2]/div/div[1]/span/span[1]");
    By clickSelectALanguage = By.xpath("//*[@id=\"ui-select-choices-row-2-37\"]/span/div");

    By clickUMobileDivice = By.xpath("//*[@id=\"mobile-device\"]/div[1]/div[2]/div/div[1]/span/span[1]");
    By clickSelectDivice = By.xpath("//*[@id=\"ui-select-choices-row-3-2\"]/span/div");


    By clickModel = By.xpath("//*[@id=\"mobile-device\"]/div[2]/div[2]/div/div[1]/span/span[1]");
    By clickSelectModel = By.xpath("//*[@id=\"ui-select-choices-row-4-72\"]/span/div");

    By clicksystem = By.xpath("//*[@id=\"mobile-device\"]/div[3]/div[2]/div/div[1]/span");
    By clickSelectSystem = By.xpath("//*[@id=\"ui-select-choices-row-5-0\"]/span/div");

    By clickLastStep = By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/div[2]/div/button");

    // By clickSoMobile = By.xpath("//span[@aria-label='Select OS'][.//button[@aria-label='Clear Mobile OS selection']]");//segundo campo de Sistema operativo

    public void listaSistemaOperativoPc() {
        try {
            // Espera y clic para abrir la lista
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(ExpectedConditions.elementToBeClickable(clickUcomputer));
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
            WebElement opcionWindows = waitListaSoPC.until(ExpectedConditions.elementToBeClickable(clickSoPc));
            opcionWindows.click();
            System.out.println("'Windows' seleccionado correctamente.");
        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: La opción 'Windows' no estuvo disponible.");
        }
    }

    public void listaVersion() {
        try {
            // Espera y clic para abrir la lista
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(ExpectedConditions.elementToBeClickable(clickVersion));
            Thread.sleep(2000);
            boton.click();
            System.out.println("Botón 'lista Version' clickeado correctamente.");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: El botón 'lista version' no estuvo listo.");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'lista version' no existe en la página.");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // Espera y clic para seleccionar Windows
            WebDriverWait waitListaVersion = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement opcionVersion = waitListaVersion.until(ExpectedConditions.elementToBeClickable(clickSelectAVersion));
            opcionVersion.click();
            System.out.println("'Windows 11' seleccionado correctamente.");
        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: La opción 'Windows 11' no estuvo disponible.");
        }

    }

    public void clickLanguage() {
        try {
            // Espera y clic para abrir la lista
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(ExpectedConditions.elementToBeClickable(clickLanguage));
            Thread.sleep(2000);
            boton.click();
            System.out.println("Botón 'lenguaje' clickeado correctamente.");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: El botón 'lenguaje' no estuvo listo.");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'lenguaje' no existe en la página.");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // Espera y clic para seleccionar Windows
            WebDriverWait waitListaLenguaje = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement opcionLenguaje = waitListaLenguaje.until(ExpectedConditions.elementToBeClickable(clickSelectALanguage));
            opcionLenguaje.click();
            System.out.println("'Spanish' seleccionado correctamente.");
        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: La opción 'Spanish' no estuvo disponible.");
        }

    }

    public void clickUMobileDivice() {
        try {
            // Espera y clic para abrir la lista
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(ExpectedConditions.elementToBeClickable(clickUMobileDivice));
            Thread.sleep(2000);
            boton.click();
            System.out.println("Botón 'Divice' clickeado correctamente.");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: El botón 'Divice' no estuvo listo.");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'lenguaje' no existe en la página.");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // Espera y clic para seleccionar Windows
            WebDriverWait waitDivice = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement opcionDivice = waitDivice.until(ExpectedConditions.elementToBeClickable(clickSelectDivice));
            Thread.sleep(2000);
            opcionDivice.click();
            System.out.println("'Apple' seleccionado correctamente.");
        }
        catch (TimeoutException | InterruptedException e) {
            System.out.println("Tiempo agotado: La opción 'Apple' no estuvo disponible.");
        }

    }

    public void clickModel() {
        try {
            // Espera y clic para abrir la lista
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(ExpectedConditions.elementToBeClickable(clickModel));
            Thread.sleep(2000);
            boton.click();
            System.out.println("Botón 'Modelo' clickeado correctamente.");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: El botón 'Modelo' no estuvo listo.");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'Modelo' no existe en la página.");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // Espera y clic para seleccionar Windows
            WebDriverWait waitModel = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement opcionModel = waitModel.until(ExpectedConditions.elementToBeClickable(clickSelectModel));
            Thread.sleep(2000);
            opcionModel.click();
            System.out.println("'iPhone 12 Pro Max' seleccionado correctamente.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Tiempo agotado: La opción 'iPhone 12 Pro Max' no estuvo disponible.");
        }

    }

    public void clicksystem() {
        try {
            // Espera y clic para abrir la lista
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement boton = waitBoton.until(ExpectedConditions.elementToBeClickable(clicksystem));
            Thread.sleep(2000);
            boton.click();
            System.out.println("Botón 'Sistema' clickeado correctamente.");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: El botón 'Sistema' no estuvo listo.");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("El botón 'Sistema' no existe en la página.");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // Espera y clic para seleccionar Windows
            WebDriverWait waitSystem = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement opcionSystem = waitSystem.until(ExpectedConditions.elementToBeClickable(clickSelectSystem));
            Thread.sleep(2000);
            opcionSystem.click();
            System.out.println("'IOS 14' seleccionado correctamente.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Tiempo agotado: La opción 'IOS 14' no estuvo disponible.");
        }
        try {
            // Espera y clic para seleccionar Windows
            WebDriverWait waitBotonLastStep = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement opcionBotonLastStep = waitBotonLastStep.until(ExpectedConditions.elementToBeClickable(clickLastStep));
            Thread.sleep(2000);
            opcionBotonLastStep.click();
            System.out.println("'Next: Last Step' seleccionado correctamente.");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Tiempo agotado: La opción 'Next: Last Step' no estuvo disponible.");
        }

        // Espera para la URL
        WebDriverWait waitUrl = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        boolean enPaginaCorrecta = waitUrl.until(
                ExpectedConditions.urlToBe("https://www.utest.com/signup/complete")
        );

        if (enPaginaCorrecta) {
            System.out.println("Ya estás en la página de dirección.");
        } else {
            System.out.println("La URL no es la esperada después de hacer clic.");
        }
    }

}
