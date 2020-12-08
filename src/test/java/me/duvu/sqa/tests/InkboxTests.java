package me.duvu.sqa.tests;

import me.duvu.sqa.seleniumStarterPack.DriverBase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InkboxTests extends DriverBase {

    @Test
    @Order(1)
    public void step1_SignupTest() {
        driver.get("https://inkbox.com/");
        driver.findElement(By.className("ub-emb-close")).click();
        driver.findElement(By.xpath("//*[@id='header-user']/button")).click();
        waitForElement(driver, By.id("signup-email-field"));

        driver.findElement(By.id("signup-email-field")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("signup-password-field")).sendKeys("123456780");
        driver.findElement(By.xpath("//*[@id='createAccountForm_popup']/div/button")).click();
    }

    @Test
    @Order(2)
    public void step2_GotoShop() {
        driver.findElement(By.xpath("//*[@id='nav-links']/div[1]/a[2]")).click();
        driver.findElement(By.linkText("Bebo")).click();

        String prices = driver.findElement(By.xpath("//*[@id='site-content']/main/div[1]/div[1]/div/div[2]/div[2]")).getText();

        assertThat(prices).isEqualToIgnoringCase("$14 USD");
    }
}
