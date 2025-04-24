package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser(String username){
        var email = String.format("%slocalhost", username);
        // создаем пользователя (адрес) на почтовом сервере (JamesHelper)
        // заполняем форму создания и отправляем (браузер)
        // ждем почту (MailHelper)
        // извлекаем ссылку из письма
        // проходим по ссылке и завершаем регистрацию пользователя (браузер, создать класс помощник)
        // проверяем, что пользователь может залогиниться (HttpSessionHelper)

    }
}
