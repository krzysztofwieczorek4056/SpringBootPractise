package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"Krzysztof", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Grzegorz", LocalDate.now().minusYears(26)));
        users.add(new User(++userCount,"Cezary", LocalDate.now().minusYears(28)));
        users.add(new User(++userCount,"Kalina", LocalDate.now().minusYears(7)));
    }

    public static List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
