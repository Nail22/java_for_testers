package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones(){
        var contacts = app.hbm().getContactList();
        var expected =  contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.home(),contact.mobile(),contact.work(),contact.secondary())
                        .filter(s->s !=null&& !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.contact().getPhones();
        Assertions.assertEquals(expected, phones);
    }
    @Test
    void testMail(){
        var contacts = app.hbm().getContactList();
        var expected =  contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.email(),contact.email2(),contact.email3())
                        .filter(s->s !=null&& !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var mail = app.contact().getMail();
        Assertions.assertEquals(expected,mail);
    }

    @Test
    void TestAddress(){
        var contacts = app.hbm().getContactList();
        var expected =  contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.address())
                        .filter(s->s !=null&& !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var address = app.contact().getAddress();
        Assertions.assertEquals(expected,address );
    }
    @Test
    void TestContentContact(){
        var contacts = app.hbm().getContactList();
        var expected =  contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.lastName(),contact.firstName(),contact.address(),contact.email(),contact.email2(),contact.email3(),contact.home(),contact.mobile(),contact.work(),contact.secondary())
                        .filter(s->s !=null&& !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var contentContact = app.contact().getContentContact();
        Assertions.assertEquals(expected,contentContact);
    }
}
