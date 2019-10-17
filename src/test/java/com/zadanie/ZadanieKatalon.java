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
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void katal1onAmazonAWSTest() {
        // znajdz pole imie i wpisz imie
        String firstNameLabel = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[1]/label")).getText();
        String firstName = "Kamil";
        System.out.println(firstNameLabel + firstName);
        WebElement firstNameInputField = driver.findElement(By.id("first-name"));
        if (firstNameInputField.isEnabled()) {
            firstNameInputField.clear();
            firstNameInputField.sendKeys(firstName);
        } else {
            Assert.fail("Pole firstName jest nieaktywne");
        }

        // znajdz pole nazwisko i wpisz nazwisko
        String lastNameLabel = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[2]/label")).getText();
        String lastName = "Nowak";
        System.out.println(lastNameLabel + lastName);
        WebElement lastNameInputField = driver.findElement(By.id("last-name"));
        if (lastNameInputField.isEnabled()) {
            lastNameInputField.clear();
            lastNameInputField.sendKeys(lastName);
        } else {
            Assert.fail("Pole nazwisko jest nieaktywne");
        }
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Nowak");


        // wybierz plec mezczyzna
        driver
                .findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"))
                .click();


        // date of birth
        WebElement dateofBirthInputField = driver.findElement(By.id("dob"));
        if (dateofBirthInputField.isEnabled()) {
            dateofBirthInputField.clear();
            dateofBirthInputField.sendKeys("dateofBirth");
        } else {
            Assert.fail("Pole data urodzenia jest niekatywne");
        }
        dateofBirthInputField.clear();
        dateofBirthInputField.sendKeys("05/22/2010");


        // address
        WebElement addressInputField = driver.findElement(By.id("address"));
        if (addressInputField.isEnabled()) {
            addressInputField.clear();
            addressInputField.sendKeys("address");
        } else {
            Assert.fail("Pole adres jest nieaktywne");
        }
        addressInputField.clear();
        addressInputField.sendKeys("Prosta 51");


        // email
        WebElement emailInputField = driver.findElement(By.id("email"));
        if (emailInputField.isEnabled()) {
            emailInputField.clear();
            emailInputField.sendKeys("email");
        } else {
            Assert.fail("Pole adres mailowy jest nieaktynwe");
        }
        emailInputField.clear();
        emailInputField.sendKeys("karol.kowalski@mailinator.com");

        // password
        WebElement passwordInputField = driver.findElement(By.id("password"));
        if (passwordInputField.isEnabled()) {
            passwordInputField.clear();
            passwordInputField.sendKeys("password");
        } else {
            Assert.fail("Pole hasło jest nieaktywne");
        }
        passwordInputField.clear();
        passwordInputField.sendKeys("Pass123");


        // company
        WebElement companyInputField = driver.findElement(By.id("company"));
        if (companyInputField.isEnabled()) {
            companyInputField.clear();
            companyInputField.sendKeys("company");
        } else {
            Assert.fail("Pole firma jest nieaktywne");
        }
        companyInputField.clear();
        companyInputField.sendKeys("Coders Lab");

        // role
        Select roleDropdown = new Select(driver.findElement(By.id("role")));
        roleDropdown.selectByVisibleText("QA");

        // comment
        WebElement commentInputField = driver.findElement(By.id("comment"));
        if (commentInputField.isEnabled()) {
            commentInputField.clear();
            commentInputField.sendKeys("commment");
        } else {
            Assert.fail("Pole komentarz jest nieaktynwe");
        }
        companyInputField.clear();
        companyInputField.sendKeys("To jest mój pierwszy automat testowy");

        driver.findElement(By.id("submit")).click();

        // check if confirmation appears
        WebElement submitSuccesfullMsg = driver.findElement(By.id("submit-msg"));
        Assert.assertTrue(driver.findElement(By.id("submit-msg")).isDisplayed());

        System.out.println("isDisplayed():" + submitSuccesfullMsg.isDisplayed());
        System.out.println("isEnabled():" + submitSuccesfullMsg.isEnabled());
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
