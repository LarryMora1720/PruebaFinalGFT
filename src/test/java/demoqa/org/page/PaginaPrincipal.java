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


    public void openUrlPrueba(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    public void clickBotonJoinNow() {
        botonLogin.click(); // Hacer clic en el botón "Join Now"
    }


}
