package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import ru.stqa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper (ApplicationManager manager){
        super(manager);
    }

    public void createContact (ContactData contact){
        opensContactCreatePage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void removalContact(){
        opensHomePage();
        selectContact();
        removeSelectedContact();
        returnToHomePage();
    }

    public void removalAllContact(){
        opensHomePage();
        selectAllContact();
        removeSelectedContact();
        opensHomePage();
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void opensHomePage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("home"));
        }
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("nickname"), contact.nickName());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.phonesHome());
        type(By.name("email"), contact.email());
    }

    private void opensContactCreatePage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("add new"));
        }
    }

    public int getCountContact() {
        opensHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void selectAllContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes){
            checkbox.click();
        }
    }
}
