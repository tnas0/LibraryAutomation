package com.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver obj;


    private Driver(){

    }

    /**
     * Return obj with only one WebDriver instance
     * @return
     */

    
    public static WebDriver getDriver(){
        //read the browser type you want to launch from properties file
        String browserName= ConfigReader.read("browser");

        if(obj==null) {
            switch (browserName.toLowerCase().trim()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    obj.manage().window().maximize();
              obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    obj.manage().window().maximize();
                    obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    obj = null;
                    //System.out.println("Unknown browser type! " + browserName);
            }

            return obj;


        }else {
            // System.out.println("You have it just use existing one");
            return obj;
        }
    }

    /**
     * Quitting the browser and setting the value of
     * WebDriver instance to null because you can re-use already quitted driver
     */
    public static void closeBrowser(){
        /**check if we have WebDriver instance or not
        *basically checking if obj is null or not
        *if not null
        *quit the browser
        *make it null, because once quit it can not be used
         */

        if(obj!=null){
            obj.quit();
            obj = null;
        }

    }




}
