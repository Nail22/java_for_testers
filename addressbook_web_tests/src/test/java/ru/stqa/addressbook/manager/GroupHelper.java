package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import ru.stqa.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper (ApplicationManager manager){
        super(manager);
    }
    public void createGroup(GroupData group) {
        opensGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void removeGroup() {
        opensGroupsPage();
        selectGruop();
        removeSelectedGroup();
        returnToGroupPage();
    }

    public void modifyGroup(GroupData modifyGroup) {
        selectGruop();
        initGroupModification();
        fillGroupForm(modifyGroup);
        submitGroupModification();
        returnToGroupPage();
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }


    private void initGroupCreation() {
        click(By.name("new"));
    }


    private void removeSelectedGroup() {
        click(By.name("delete"));
    }


    private void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGruop() {
        click(By.name("selected[]"));
    }

    public void opensGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public boolean isGroupPresent() {

        opensGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

}
