package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData().withFistName("FirstName").withLastName("LastName").withAddress("Address").withPhoto("src/test/resources/images/avatar.jpg").withPhonesHome("phones").withEmail("email"),
                new ContactData("", "First_name", "Middle_name", "Last_name", "Nickname", "address", "src/test/resources/images/avatar.jpg", "Telephone", "email")));
        for (int i = 0; i < 7; i++) {
            result.add(new ContactData("", randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2),randomFile("src/test/resources/images"), randomString(i * 2), randomString(i * 2)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleGroups(ContactData contact) {
        var oldGroups = app.contact().getList();
        app.contact().createContact(contact);
        var newGroups = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(contact.withId(newGroups.get(newGroups.size() - 1).id()).withMiddleName("").withNickName("").withAddress("").withPhoto("").withPhonesHome("").withEmail(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }
}
