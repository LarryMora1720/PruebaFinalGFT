package demoqa.org.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UltimoFormulario extends PaginaPrincipal {


    //Elementos ultima pantalla del registro

    @FindBy(id = "password")
    WebElement clickPass;
    //By clickPass = By.xpath("//*[@id=\"password\"]");

    @FindBy(id = "confirmPassword")
    WebElement clickConfirmPass;
    //By clickConfirmPass = By.xpath("//*[@id=\"confirmPassword\"]");

    By clickStay = By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[4]/label/span");
    By clickIHaveReadOne = By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[5]/label/span[1]");


    By clickIHaveReadTwo = By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[6]/label/span[1]");
    By clickCompleteSetup = By.xpath("//*[@id=\"laddaBtn\"]");


//    public void finalizacionRegistro(String contraseña) {
//
//        clickPass.sendKeys(contraseña);
//        clickConfirmPass.sendKeys(contraseña);
//
//        WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        WebElement checkBoxStay = waitBoton.until(ExpectedConditions.elementToBeClickable(clickStay));
//
//        checkBoxStay.click();
//
//        WebElement checkBoxOne = waitBoton.until(ExpectedConditions.elementToBeClickable(clickIHaveReadOne));
//
//        checkBoxOne.click();
//
//        WebElement checkBoxTwo = waitBoton.until(ExpectedConditions.elementToBeClickable(clickIHaveReadTwo));
//
//        checkBoxTwo.click();
//
//        WebElement CompleteSetup = waitBoton.until(ExpectedConditions.elementToBeClickable(clickCompleteSetup));
//
//        CompleteSetup.click();
//
//
//    }

    public void finalizacionRegistro(String contraseña) {

        try {
            // Espera
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement campo = waitBoton.until(ExpectedConditions.elementToBeClickable(clickPass));
            Thread.sleep(2000);
            campo.sendKeys(contraseña);
            System.out.println("nueva contraseña");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: no se logro ingresar la nueva contraseña");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("el campo para ingresar nueva contraseña no estuvo listo");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // Espera
            WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement campo = waitBoton.until(ExpectedConditions.elementToBeClickable(clickConfirmPass));
            Thread.sleep(2000);
            campo.sendKeys(contraseña);
            System.out.println("confirmación nueva contraseña");

        } catch (TimeoutException e) {
            System.out.println("Tiempo agotado: no se logro ingresar la confirmación nueva contraseña");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("el campo para ingresar confirmación nueva contraseña no estuvo listo");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebDriverWait waitBoton = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement checkBoxStay = waitBoton.until(ExpectedConditions.elementToBeClickable(clickStay));

        checkBoxStay.click();

        WebElement checkBoxOne = waitBoton.until(ExpectedConditions.elementToBeClickable(clickIHaveReadOne));

        checkBoxOne.click();

        WebElement checkBoxTwo = waitBoton.until(ExpectedConditions.elementToBeClickable(clickIHaveReadTwo));

        checkBoxTwo.click();

        WebElement CompleteSetup = waitBoton.until(ExpectedConditions.elementToBeClickable(clickCompleteSetup));

        CompleteSetup.click();

    }

    public void registroOk() {

        // Espera para la URL
        WebDriverWait waitUrl = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        boolean RegistroCorecto = waitUrl.until(ExpectedConditions.urlToBe("https://www.utest.com/welcome?from=signup"));
        if (RegistroCorecto) {
            System.out.println("Registro exitosos del nuevo usuario");
        } else {
            System.out.println("La URL no es la esperada después de hacer click - FALLO REGISTRO");
        }
    }
}
