package demo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
       // WebDriverManager.chromedriver().timeout(30).setup();     //not necessary for wedriver 114
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(2000);
        try{
            writeText(driver, By.xpath("//div['Xb9hP']/input[@type='text']"), "Jyoti Sharma");
            writeText(driver, By.xpath("//textarea[@aria-label='Your answer']"),
            "I want to be the best QA Engineer! " + epochTime(0));
            checkBox(driver, By.xpath(
                "(//span[normalize-space(text()) = 'How much experience do you have in Automation Testing?']/ancestor::div[4]//div[@class='AB7Lab Id5V1'])[2]"));

                checkBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[1]"));
            checkBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[2]"));
            checkBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[4]"));
                    radioBtn(driver, By.xpath(
                        "//*[normalize-space(text()) = 'How should you be addressed?']/ancestor::div[4]//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"),
                        "Mrs");

                        writeText(driver, By.xpath(
                            "//*[normalize-space(text()) = 'What was the date 7 days ago?']/ancestor::div[4]//input[@class='whsOnd zHQkBf']"),
                            calculateDateTimeToString("dd/MM/YYYY", (long) 6.048e+8));

                            writeText(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'What is the time right now?']/ancestor::div[4]//input[@class='whsOnd zHQkBf'])[1]"),
                    getCurrentTime("HH", 0));
            writeText(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'What is the time right now?']/ancestor::div[4]//input[@class='whsOnd zHQkBf'])[2]"),
                    getCurrentTime("mm", 0));
                   

                    driver.get("https://amazon.in");
                    Thread.sleep(2000);
                    // on cancel
                    handleAlert(driver, false);
                    // Submit the form
                    driver.findElement(By.xpath("//*[normalize-space(text())='Submit']/ancestor::div[1]")).click();
                    // Print the message upon successful completion
                    System.out.println(driver.findElement(By.xpath("//div[@role='heading']/../div[3]")).getText());
                    Thread.sleep(3000);
       
        }
    catch (Exception e) {
        e.printStackTrace();
        System.out.println("Failure!");
        return;
    }
        System.out.println("end Test case: testCase02");
        
    }
    private static void writeText(ChromeDriver driver, By selector, String tosend) throws InterruptedException{
        System.out.println("Trying to send text" + tosend);
       // WebDriverWait wait =new WebDriverWait(driver,Duration.seconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        Thread.sleep(2000);
        WebElement box=driver.findElement(selector);
        box.clear();
        box.sendKeys(tosend);
        Thread.sleep(2000);
        System.out.println("Successfully inserted");
    }

    private static String epochTime(int offsetInMs){
        Instant now=Instant.now();
        Instant newInstant = now.plusMillis(offsetInMs);
        // Convert the Instant to epoch time in milliseconds
        long epochMilli = newInstant.toEpochMilli();
        // Return the epoch time as a string
        return String.valueOf(epochMilli);
    }

    private static void radioBtn(ChromeDriver driver, By dropdownselector, String selectedText) throws InterruptedException{
        System.out.println("Trying to select from dropdown - "+selectedText);
        // Find Dropdown
        WebElement dropdownElement = driver.findElement(dropdownselector);

        // Create a Select instance
        dropdownElement.click();
        Thread.sleep(2000);

        // Select the option by visible text
        driver.findElement(By.xpath("(//div[@data-value='" + selectedText + "'])[2]")).click();
        Thread.sleep(2000);
        System.out.println("Success!");
    }

    private static void checkBox(ChromeDriver driver, By selector) throws Exception {
        System.out.println("Trying to check boxes/ radio buttons");
        // Initialize the webdriver wait
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // Wait till the element is visible
       //wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        Thread.sleep(2000);
        // Click the button
        WebElement element = driver.findElement(selector);
        element.click();
        Thread.sleep(2000);
        System.out.println("Success!");
    }
     
    // private static void ofSeconds(long seconds,long nanos){
        
    // }

    private static String calculateDateTimeToString(String formatString, long offsetInMs) {
//         LocalDateTime now = LocalDateTime.now();

//         // Add the offset in milliseconds to the current date and time
        
//         long seconds = offsetInMs / 1000;
//         long nanos = (offsetInMs % 1000) * 1000000;
        
//         LocalDateTime newDateTime = now.minus(Duration.ofSeconds(seconds, nanos));

//         // Format the new date and time according to the provided format string
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
//         String formattedDateTime = newDateTime.format(formatter);

//         // Print the formatted date and time
//         return formattedDateTime;
// //     LocalDateTime now = LocalDateTime.now();

LocalDateTime now = LocalDateTime.now();

// Subtract 7 days from the current date-time
LocalDateTime sevenDaysAgo = now.minusDays(7);

// Define the desired date-time format
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

// Format the 7 days ago date-time to the desired format
String formattedDateTime = sevenDaysAgo.format(formatter);

// Return the formatted date-time string
return formattedDateTime;
 }

 private static String getCurrentTime(String formatString, long offsetInMs) {
    // Get the current time
    LocalDateTime currentTime = LocalDateTime.now();

    // Define the desired time format (e.g., "HH:mm:ss" for 24-hour format)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    // Format the current time to the desired format
    String formattedTime = currentTime.format(formatter);

    // Return the formatted time string
    return formattedTime;
}
   
    private static void handleAlert(ChromeDriver driver, Boolean confirm) throws InterruptedException {
        System.out.println("Trying to handle alert");
        // Wait for the alert to be present and switch to it
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        if (confirm) {
            // Accept the alert (click OK)
            alert.accept();
        } else {
            // Dismiss the alert (click Cancel)
            alert.dismiss();
        }
        System.out.println("Success!");
    }


}
