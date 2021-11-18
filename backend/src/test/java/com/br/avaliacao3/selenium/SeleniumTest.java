package com.br.avaliacao3.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinic\\OneDrive\\Documents\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");

        WebElement botao = driver.findElement(By.id("btn-create"));
        botao.click();

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("John Doe");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("john@doe.com");

        WebElement telephone = driver.findElement(By.id("telephone"));
        telephone.sendKeys("4002-8922");

        WebElement enviar = driver.findElement(By.id("btn-form-submit-create"));
        enviar.click();
    }
}
