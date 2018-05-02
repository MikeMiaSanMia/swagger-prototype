package pl.sii.eu.swaggerprototype.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.eu.swaggerprototype.model.User;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("rest/user")
public class UserResource {

    @GetMapping
    public List<User> getUsers() {
        return Arrays.asList(
                new User("Kate", 6000L),
                new User("Alice", 5000L)
        );
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") final String userName) {
        return new User(userName, 4000L);
    }
}
