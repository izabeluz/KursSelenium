package com.zadanie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ZadanieKatalon {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void katal1onAmazonAWSTest(){
        // znajdz pole imie i wpisz imie
        WebElement firstNameInputField = driver.findElement(By.id("first-name"));
        firstNameInputField.clear();
        firstNameInputField.sendKeys("Karol");
        // znajdz pole nazwisko i wpisz nazwisko
        WebElement lastNameInputField = driver.findElement(By.id("last-name"));
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Nazwisko");
        // wybierz plec mezczyzna
        driver
                .findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"))
                .click();

        // date of birth
        WebElement dateofBirthInputField = driver.findElement(By.id("dob"));
        dateofBirthInputField.clear();
        dateofBirthInputField.sendKeys("05/22/2010");

        // address
        WebElement addressInputField = driver.findElement(By.id("address"));
        addressInputField.clear();
        addressInputField.sendKeys("Prosta 51");

        // email
        WebElement emailInputField = driver.findElement(By.id("email"));
        emailInputField.clear();
        emailInputField.sendKeys("karol.kowalski@mailinator.com");

        // password
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.clear();
        passwordInputField.sendKeys("Pass123");

        // company
        WebElement companyInputField = driver.findElement(By.id("company"));
        companyInputField.clear();
        companyInputField.sendKeys("Coders Lab");

        // role
        Select roleDropdown = new Select(driver.findElement(By.id("role")));
        roleDropdown.selectByVisibleText("QA");

        // comment
        WebElement commentInputField = driver.findElement(By.id("comment"));
        companyInputField.clear();
        companyInputField.sendKeys("To jest mój pierwszy automat testowy");

        driver.findElement(By.id("submit")).click();

        // check if confirmation appears
        Assert.assertTrue(driver.findElement(By.id("submit-msg")).isDisplayed());
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
