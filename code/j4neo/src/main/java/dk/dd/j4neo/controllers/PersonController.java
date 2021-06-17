package dk.dd.j4neo.controllers;

import dk.dd.j4neo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dk.dd.j4neo.repository.UserRepository;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController
{
        private final UserRepository userRepository;

        public PersonController(UserRepository userRepository)
        {
            this.userRepository = userRepository;
        }

        @GetMapping
        public Iterable<User> findAllPersons()
        { return userRepository.findAll(); }

        @GetMapping("/{name}")
        public User getPersonByName(@PathVariable String name)
        {
            return UserRepository.getUserByName(name);
        }



        @GetMapping("/actanddirect")
        public List<User> getPersonsWhoActAndDirect()
        {
            return userRepository.getPersonsWhoActAndDirect();
        }
}
