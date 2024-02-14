package Tests;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class BookPageTest extends BaseTest {
    //first name [data-code="first_name"]
//Last name  [data-id='2']
    //mail [data-id="3"]
    //phone [data-id="4"] input
    //book now //input[@value="Book Now"]
    //red frame css input.ng-pristine
    //[name = 'booking[state]'] combobox States
    // [data-id= '5']>input      address
        //[data-id= '6']>input        city
    // [data-id= '8']>input           zipCode
    @Test
    public void registrationSuccessTest() throws InterruptedException {

By bookXml = By.cssSelector("li[id='menu-item-122']");
By frame = By.cssSelector("//div[@data-id = '1']/input[not(contains(@class,'ng-pristine'))]");
By firstN = By.cssSelector("input[name='booking[first_name]']");
By lastN = By.cssSelector("[data-id='2'] input");
By mailCSS = By.cssSelector("[data-id='3'] input");
By phoneCSS = By.cssSelector("[data-id='4'] input");
By submit = By.cssSelector("[data-name = 'Submit Button']");
By iframeXpath = By.xpath("//iframe[@data-lazyloaded = '1']");
By stateCss = By.cssSelector("[name = 'booking[state]']");
By addressCss = By.cssSelector("[data-id= '5']>input ");
By cityCss = By.cssSelector("[data-id= '6']>input");
By zipCss = By.cssSelector("[data-id= '8']>input");
By subEmail = By.cssSelector(".mc-field-group>[type='email']");
By subId = By.cssSelector("input[type = 'submit']");
By denyXpath = By.xpath("//div[text()='Please enter a valid email address.']");
       By dataCss = By.cssSelector("[data-id= '181']>input");
 //       By dataCss = By.id("dp1706116425190");
        By monthCss = By.xpath("//span[@class ='ui-datepicker-month']");
       JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement bookNowBtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(bookXml));
        bookNowBtn.click();
        System.out.println("Before");
        Thread.sleep(3000);
        WebElement iframe = wait.until(ExpectedConditions
                .visibilityOfElementLocated(iframeXpath));
        driver.switchTo().frame(iframe);
        Thread.sleep(1000);
        WebElement firstName =driver.findElement(firstN);
        firstName.click();

        firstName.clear();
        firstName.sendKeys("John");


        //last name
        WebElement lastName =driver.findElement(lastN);
        lastName.click();
        lastName.clear();
        lastName.sendKeys("Dou");
        //email
        WebElement email =  wait.until(ExpectedConditions
                .visibilityOfElementLocated(mailCSS));
        email.click();
        email.clear();
        email.sendKeys("<@gmail.co");
        //phone number
        WebElement phone =  wait.until(ExpectedConditions
                .visibilityOfElementLocated(phoneCSS));
        phone.click();
        phone.clear();
        phone.sendKeys("346-75-234-44");



         // Address of order
       WebElement address = wait.until(ExpectedConditions
               .elementToBeClickable(addressCss));
       address.click();
       address.clear();
       address.sendKeys("Oriental blvd");
        System.out.println(address.getText());
       WebElement city = wait.until(ExpectedConditions
               .elementToBeClickable(cityCss));
               city.click();
       city.clear();
       city.sendKeys("Brooklyn");

       WebElement zipCode = wait.until(ExpectedConditions
               .elementToBeClickable(zipCss));
                 zipCode.click();
                 zipCode.clear();
                 zipCode.sendKeys("12345");


        WebElement statesDrop = wait.until(ExpectedConditions
                .elementToBeClickable(stateCss));
     //   statesDrop.click();
        Select drpStates = new Select(statesDrop);
         drpStates.selectByVisibleText("NY");
        address.click();
        String textCheck = address.getText();
        System.out.println(textCheck);

        driver.switchTo().defaultContent();
       WebElement subscribeEmail = wait.until(ExpectedConditions
               .elementToBeClickable(subEmail));
   //     js.executeScript("arguments[0].scrollIntoView(true);", subscribeEmail);
       subscribeEmail.click();
        subscribeEmail.clear();
        subscribeEmail.sendKeys("<@gmail.co");

        WebElement subscribe  = driver.findElement(subId);
        subscribe.click();
        WebElement subscriptionDeny = driver.findElement(denyXpath);
        String warning = subscriptionDeny.getText();
        System.out.println(warning);
        Assert.assertEquals(warning,"Please enter a valid email address.");


    }
}
