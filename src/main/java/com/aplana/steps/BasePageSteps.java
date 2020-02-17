package com.aplana.steps;

import com.aplana.utils.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePageSteps {
    protected static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void startScenario(){
        String nameDriver = properties.getProperty("browser");
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.get(properties.getProperty("app.url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);

    }

    @After
    public void closeScenario(){
        driver.quit();
    }

    @Attachment(type = "text/txt", value = "Text")
    public byte[] saveToFileAllure(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines.toString().getBytes();
    }
}