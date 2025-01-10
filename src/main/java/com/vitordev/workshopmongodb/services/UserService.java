package com.vitordev.workshopmongodb.services;

import com.vitordev.workshopmongodb.domain.User;
import com.vitordev.workshopmongodb.dto.UserDTO;
import com.vitordev.workshopmongodb.repository.UserRepository;
import com.vitordev.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDto) {
        User user = new User(userDto.getId(), userDto.getName(), userDto.getEmail());
        return user;
    }
}
