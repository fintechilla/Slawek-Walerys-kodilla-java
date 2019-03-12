package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_DAY = "//select[@id='day']";
    public static final String XPATH_MONTH = "//select[@id='month']";
    public static final String XPATH_YEAR = "//select[@id='year']";
    public static final String XPATH_WAIT_FOR = "//div[@id='reg_form_box']";
    public static final String XPATH_FIRSTNAME = "//input[@id='u_0_j']";
    public static final String XPATH_LASTNAME = "//input[@id='u_0_l']";
    public static final String XPATH_EMAIL = "//input[@id='u_0_o']";
    public static final String XPATH_EMAIL2 = "//input[@id='u_0_r']";
    public static final String XPATH_PWD = "//input[@id='u_0_v']";
    public static final String XPATH_GENDER_MALE = "//input[@id='u_0_a']";
    public static final String XPATH_GENDER_FEMALE = "//input[@id='u_0_9']";
    public static final String XPATH_SUBMIT_BUTTON = "//button[@id='u_0_11']";
    public static void main(String[] args){
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement firstnameField = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstnameField.sendKeys("Jan");

        WebElement lastnameField = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastnameField.sendKeys("Kowalczyk");

        WebElement emailField = driver.findElement(By.xpath(XPATH_EMAIL));
        emailField.sendKeys("Jan.kowalczyk@gmail.com");

        WebElement email2Field = driver.findElement(By.xpath(XPATH_EMAIL2));
        email2Field.sendKeys("Jan.kowalczyk@gmail.com");

        WebElement pwdField = driver.findElement(By.xpath(XPATH_PWD));
        pwdField.sendKeys("Mypwd1");

        WebElement dayField = driver.findElement(By.xpath(XPATH_DAY));
        Select selectBoardDay = new Select(dayField);
        selectBoardDay.selectByIndex(16);

        WebElement monthField = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectBoardMonth = new Select(monthField);
        selectBoardMonth.selectByIndex(5);

//        WebElement yearField = driver.findElement(By.xpath(XPATH_YEAR));
//        Select selectBoardYear = new Select(yearField);
//        selectBoardYear.selectByIndex(1990);
        WebElement genderField = driver.findElement(By.xpath(XPATH_GENDER_FEMALE));
//        Select selectGengerFemale = new Select(genderField);
        genderField.click();

        WebElement submitButton = driver.findElement(By.xpath(XPATH_SUBMIT_BUTTON));
        submitButton.click();
//        Actions actionSubmitButton = new Actions(driver);
//        // use the action handler to move the cursor to given element
//        actionSubmitButton.moveToElement(submitButton).perform();
//        actionSubmitButton.click(submitButton);


    }
}
