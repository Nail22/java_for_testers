package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected WebDriver driver;

    private LoginHelper session;

    private GroupHelper groups;

    private ContactHelper contact;

    public void init(String browser) {
        if (driver == null) {
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1280, 810));
            session().login("admin", "secret");
        }
    }

    public LoginHelper session(){
        if (session == null){
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups(){
        if (groups == null){
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public ContactHelper contact(){
        if (contact == null){
            contact = new ContactHelper(this);
        }
        return contact;
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
