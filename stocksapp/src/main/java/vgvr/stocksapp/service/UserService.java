package vgvr.stocksapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vgvr.stocksapp.model.User;
import vgvr.stocksapp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        return userRepository.getOne(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public void save(User user){
        userRepository.save(user);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public boolean exist(User user){
        List<User> users = findAll();
        for(User rec: users){
            if(rec.getEmail().equals(user.getEmail())) return false;
        }
        return true;
    }
    public User findByEmailPassword(User user){
        List<User> users = findAll();
        for(User userRecord: users){
            if(userRecord.getEmail().equals(user.getEmail()) && userRecord.getPassword().equals(user.getPassword())) {
                return userRecord;
            }
        }
        return null;
    }

}
