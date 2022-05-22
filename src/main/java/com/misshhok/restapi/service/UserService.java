package com.misshhok.restapi.service;
import java.util.List;
import com.misshhok.restapi.entity.TodoEntity;
import com.misshhok.restapi.entity.UserEntity;
import com.misshhok.restapi.exceptions.UserAlreadyExistsException;
import com.misshhok.restapi.exceptions.UserNotFoundException;
import com.misshhok.restapi.model.User;
import com.misshhok.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registartion(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("User already exists!");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException{
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }
        return User.toModel(user);
    }

    public List<TodoEntity> getTodos(Long id) throws UserNotFoundException{
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }
        return user.getTodos();
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
