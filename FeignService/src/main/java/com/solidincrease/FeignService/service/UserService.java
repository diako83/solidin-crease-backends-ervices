package com.solidincrease.FeignService.service;

import com.soldincrease.FeignServices.dto.Responce;
import com.soldincrease.FeignServices.dto.UserRegistrationRequest;
import com.soldincrease.FeignServices.entity.Users;
import com.soldincrease.FeignServices.repository.UserRepository;
import com.soldincrease.FeignServices.utils.UtilUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    public Optional<Responce> registerCustomer(UserRegistrationRequest userRegister) {
        Responce responce = new Responce();
        Users user = new Users();
        UUID uuid = UUID.randomUUID();

       if( !userRepository.existsUsersByEmail(userRegister.getEmail())){

         user = Users.builder()
                   .user_id(uuid.toString())
                   .email(userRegister.getEmail())
                   .password(userRegister.getPassword())
                   .build();

         userRepository.save(user);

         responce.Data = UtilUser.UserToDto(user);
         responce.Success= true;
         responce.Message = "User created";

       }else {
           responce.Data= "";
           responce.Success= false;
           responce.Message = "email already exists ";
       }

        return Optional.of(responce);
    }
}
