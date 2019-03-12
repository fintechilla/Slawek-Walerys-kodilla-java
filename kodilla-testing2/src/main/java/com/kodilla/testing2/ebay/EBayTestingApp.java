package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EBayTestingApp {
    public static final String SEARCHFIELD = "gh-ac";//"gsfi";
    public static void main(String[] args){
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.ebay.com");

        WebElement searchField = driver.findElement(By.id(SEARCHFIELD));
        searchField.sendKeys("laptop");
        searchField.submit();

        List<WebElement> productFields = new ArrayList<>();
        productFields =  driver.findElements(By.className("s-item__price"));

        int noProducts = productFields.size();
        System.out.println("No of laptops: " + noProducts);
        double sumPrice = 0;
        for( WebElement product:productFields){
            String text = product.getText();
            text = text.substring(1,text.length()-1);
            //System.out.println("Price as string: " + text);
            String[] newPriceStr = text.split(" ");
            String priceStr = newPriceStr[0].replace(",", "");
            double price = Double.parseDouble(priceStr);
            sumPrice += price;
        }
        System.out.println("Avg Price: " + sumPrice / noProducts);
    }
}
