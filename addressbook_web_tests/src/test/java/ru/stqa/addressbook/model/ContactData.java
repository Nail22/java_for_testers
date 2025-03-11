package ru.stqa.addressbook.model;

public record ContactData (String firstName, String middleName, String lastName, String nickName, String address, String phonesHome, String email ) {

    public ContactData() {
        this ("","","","","","","");

    }
    public ContactData withFistName (String firstName){
        return new ContactData(firstName, this.middleName, this.lastName,this.nickName, this.address, this.email, this.phonesHome);
    }
    public ContactData withLastName (String lastName){
        return new ContactData(this.firstName, this.middleName, lastName, this.nickName, this.address, this.email, this.phonesHome);
    }
    public ContactData withAddress (String address){
        return new ContactData(this.firstName, this.middleName, this.lastName, this.nickName, address, this.email, this.phonesHome);
    }
    public ContactData withEmail (String phonesHome){
        return new ContactData(this.firstName, this.middleName, this.lastName, this.nickName, this.address, phonesHome, this.phonesHome);
    }
    public ContactData withPhonesHome(String email){
        return new ContactData(this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.email, email);
    }
}
