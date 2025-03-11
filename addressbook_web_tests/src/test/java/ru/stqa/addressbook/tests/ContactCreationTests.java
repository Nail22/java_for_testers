package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateBaseContact() {
        app.contact().createContact(new ContactData().withFistName("FirstName").withLastName("LastName").withAddress("Address").withPhonesHome("phones").withEmail("email"));
    }

    @Test
    public void canCreateFullContact() {
        app.contact().createContact(new ContactData("First_name", "Middle_name", "Last_name", "Nickname", "address", "Telephone", "email"));
    }
}
