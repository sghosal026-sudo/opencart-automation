package factory;

import com.github.javafaker.Faker;
import models.User;

public class UserFactory {

    private static final Faker faker = new Faker();

    public static User createRandomUser() {
        return new User.UserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .password(faker.internet().password(8, 16))
                .newsletter(faker.bool().bool())
                .build();
    }

    public static User createUserWithoutNewsletter() {
        return new User.UserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .password(faker.internet().password(8, 16))
                .build();
    }

    public static User createEmptyUser() {
        return new User.UserBuilder()
                .firstName("")
                .lastName("")
                .email("")
                .phone("")
                .password("")
                .newsletter(false)
                .build();
    }

    public static User createUserWithNewsletter() {
        return new User.UserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .password(faker.internet().password(8, 16))
                .newsletter(true)
                .build();
    }
}