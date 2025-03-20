package ru.stqa.addressbook.model;

public record ContactData(String id, String firstName, String middleName, String lastName, String nickName,
                          String address, String phonesHome, String email) {

    public ContactData() {
        this("", "", "", "", "", "", "", "");

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.phonesHome, this.email);
    }

    public ContactData withFistName(String firstName) {
        return new ContactData(this.id, firstName, this.middleName, this.lastName, this.nickName, this.address, this.phonesHome, this.email);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.nickName, this.address, this.phonesHome, this.email);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, this.middleName, lastName, this.nickName, this.address, this.phonesHome, this.email);
    }

    public ContactData withNickName(String nickName) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, nickName, this.address, this.phonesHome, this.email);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, address, this.phonesHome, this.email);
    }

    public ContactData withPhonesHome(String phonesHome) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, phonesHome, this.email);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.phonesHome, email);
    }
}
