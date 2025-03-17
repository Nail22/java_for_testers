package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData().withFistName("FirstName").withLastName("LastName").withAddress("Address").withPhonesHome("phones").withEmail("email"));
        }
        int contactCount = app.contact().getCountContact();
        app.contact().removalContact();
        int newContactCount = app.contact().getCountContact();
        Assertions.assertEquals(contactCount-1, newContactCount);
    }

    @Test
    public void canRemoveAllContact() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData().withFistName("FirstName").withLastName("LastName").withAddress("Address").withPhonesHome("phones").withEmail("email"));
        }
        app.contact().removalAllContact();
        Assertions.assertEquals(0, app.contact().getCountContact());
    }
}
