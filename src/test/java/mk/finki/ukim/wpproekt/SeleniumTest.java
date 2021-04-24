package mk.finki.ukim.wpproekt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.junit.Assert.assertTrue;

public class SeleniumTest {
    private WebDriver driver;

    private WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/Viktorija/Desktop/Fakultet/chromedriver_win32/chromedriver.exe");
        return new ChromeDriver();
    }

    @BeforeTest
    public void setup(){
        driver = getDriver();
    }

    @Test
    public void shouldOpen() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    @Test
    public void shouldLogin() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("viktorija", "vm");
        assertTrue(new HomePage(driver).isLoaded());
    }

    @Test
    public void canNotLoginWithInvalidArguments() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("viktorija", "123");
        assertTrue(new HomePage(driver).isLoaded());
    }

    @Test
    public void canNotLoginWithEmptyArguments() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "");
        assertTrue(new HomePage(driver).isLoaded());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
