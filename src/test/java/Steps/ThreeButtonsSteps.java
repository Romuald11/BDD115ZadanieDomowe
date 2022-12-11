package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThreeButtonsSteps {

    private static WebDriver driver;

    @BeforeAll
    public static void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("Uzytkownik jest na stronie")
    public void uzytkownik_jest_na_stronie() {
        driver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise1");
    }

    @When("Uzytkownik pierwszy raz klika w odpowiedni przycisk")
    public void uzytkownik_pierwszy_raz_klika_w_odpowiedni_przycisk() throws InterruptedException {
        WebElement pierwszyElement = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]/code"));
        String pierwszyTekst = pierwszyElement.getText();
        System.out.println(pierwszyTekst);
        if (pierwszyTekst.equals("B1")) {
            // kliknij w przycisk B1
            driver.findElement(By.id("btnButton1")).click();
        } else {
            // kliknij w przycisk B2
            driver.findElement(By.id("btnButton2")).click();
        }
        //Thread.sleep(1000);
    }

    @When("Uzytkownik drugi raz klika w odpowiedni przycisk")
    public void uzytkownik_drugi_raz_klika_w_odpowiedni_przycisk() throws InterruptedException {
         String drugiTekst = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]/code")).getText();
         System.out.println(drugiTekst);
        if (drugiTekst.equals("B1")) {
            // kliknij w przycisk B1
            driver.findElement(By.id("btnButton1")).click();
        } else {
            // kliknij w przycisk B2
            driver.findElement(By.id("btnButton2")).click();
        }
        //Thread.sleep(1000);
    }

    @When("Uzytkownik trzeci raz klika w odpowiedni przycisk")
    public void uzytkownik_trzeci_raz_klika_w_odpowiedni_przycisk() throws InterruptedException {
        String trzeciTekst = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[2]/code")).getText();
        System.out.println(trzeciTekst);
        if (trzeciTekst.equals("B1")) {
            // kliknij w przycisk B1
            driver.findElement(By.id("btnButton1")).click();
        } else {
            // kliknij w przycisk B2
            driver.findElement(By.id("btnButton2")).click();
        }
        //Thread.sleep(1000);
    }

    @When("Uzytkownik klika w przycisk check solution")
    public void uzytkownik_klika_w_przycisk_check_solution() throws InterruptedException {
        driver.findElement(By.name("end")).click();

        // explicitly wait - oczekiwanie warunkowe
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement sprawdzanePole = driver.findElement(By.className("wrap"));
        wait.until(ExpectedConditions.textToBePresentInElement(sprawdzanePole,"OK. Good answer"));
        //Thread.sleep(1000);
    }

    @Then("Uzytkownikowi pokazuje sie napis OK. Good answer")
    public void uzytkownikowi_pokazuje_sie_napis_ok_good_answer() {
        String poprawnyTekst = driver.findElement(By.className("wrap")).getText();
        Assert.assertEquals("OK. Good answer",poprawnyTekst);
    }

    @AfterAll
    public static void tearDriver(){
        driver.close();
    }

}
