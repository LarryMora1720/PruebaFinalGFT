package demoqa.org.page;

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


public class TercerFormulario extends PaginaPrincipal {


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