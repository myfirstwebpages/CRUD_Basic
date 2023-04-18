package com.example.webapplication.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> listAllUser() {
        return (List<User>) userRepo.findAll();
    }


    public void save(User user) {
        userRepo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = userRepo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Can not find user" + id);
    }

    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

}
