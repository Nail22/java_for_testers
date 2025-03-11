package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData().withFistName("FirstName").withLastName("LastName").withAddress("Address").withPhonesHome("phones").withEmail("email"));
        }
        app.contact().removalContact();
    }
}
