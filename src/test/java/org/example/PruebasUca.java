package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class PruebasUca {
    public WebDriver driver;

    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void logIn() {
        // Variables que tienen referencias a los elementos.
        WebElement userInput = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        WebElement buscarBoton = driver.findElement(By.cssSelector("#login-button"));

        // Colocar información en los inputs.
        userInput.click();
        userInput.sendKeys("standard_user");
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        // Click al log in.
        buscarBoton.click();
    }

    public void addToCart() {
        // Variables que tienen referencias a los elementos.
        WebElement addElement1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        WebElement addElement2 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));

        // Agregar dos articulos al carrito.
        addElement1.click();
        addElement2.click();
    }

    public void navigateCarrito() {
        // Variables que tienen referencias a los elementos.
        WebElement carritoDeCompras = driver.findElement(By.cssSelector("#shopping_cart_container > a"));

        // Clickear el carrito de compras.
        carritoDeCompras.click();
    }

    public void removeFromCart() {
        // Variables que tienen referencias a los elementos.
        WebElement removeItem2 = driver.findElement(By.cssSelector("#remove-sauce-labs-bike-light"));

        // Clickear en remover item de luces de bici.
        removeItem2.click();
    }

    public void checkout() {
        // Variables que tienen referencias a los elementos.
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));

        // Clickear el boton checkout.
        checkoutButton.click();
    }

    @Test (priority = 1)
    public void test() {
        setUp();

        logIn();
        addToCart();

        navigateCarrito();
        removeFromCart();

        checkout();
    }
}
