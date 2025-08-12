import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaIntegracionRegistro {

    @Test
    public void registroUsuarioExitoso() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            System.out.println("Abriendo formulario de registro...");
            driver.get("http://localhost:5050/registro");

            // Completar los campos del formulario
            driver.findElement(By.name("nombre")).sendKeys("Juan");
            driver.findElement(By.name("apellido")).sendKeys("Ramirez");
            driver.findElement(By.name("correo")).sendKeys("juan" + System.currentTimeMillis() + "@test.com");
            driver.findElement(By.name("numeroCelular")).sendKeys("12345678");
            driver.findElement(By.name("password")).sendKeys("clave123");

             // ✅ Seleccionar roles (checkboxes)
            WebElement rolComprador = driver.findElement(By.id("checkRol1"));  // Reemplaza con el id correcto del checkbox
            WebElement rolVendedor = driver.findElement(By.id("checkRol2"));    // Reemplaza si tienes más roles

            if (!rolComprador.isSelected()) {
                rolComprador.click();  // Marca el rol comprador
            }

            // Si deseas seleccionar también el rol vendedor:
            if (!rolVendedor.isSelected()) {
                rolVendedor.click();
            }

            // Enviar el formulario
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Esperar unos segundos para que se procese y redirija
            Thread.sleep(3000);

            // Verificar si redirige correctamente
            String currentUrl = driver.getCurrentUrl();
            System.out.println("URL después del registro: " + currentUrl);

            // Validar que contiene el parámetro esperado
            assertTrue(currentUrl.contains("registro?exito=true"), "No redirigió a la URL de éxito esperada");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            driver.quit();
        }
    }
}