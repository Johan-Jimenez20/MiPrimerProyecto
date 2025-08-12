import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PruebaIntegracionLogin {

    @Test
    public void loginMiprimerProyectoPrueba() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
        System.out.println("Abriendo página de login...");
        driver.get("http://localhost:5050/login");

        System.out.println("Buscando campo de correo...");
        WebElement correo = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        correo.sendKeys("holaholahola@hotmail.com");
        password.sendKeys("mia");

        WebElement boton = driver.findElement(By.cssSelector("input[type='submit']"));
        boton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.endsWith("/") || currentUrl.contains("index"), "no redirigio al inicio");
        System.out.println("URL actual después del login: " + currentUrl);

    } catch (Exception e) {
        e.printStackTrace();  // Mostrar el error real en consola
        throw e;               // Volver a lanzar para que el test falle como debe
    } finally {
        driver.quit();
    }
    }
}
