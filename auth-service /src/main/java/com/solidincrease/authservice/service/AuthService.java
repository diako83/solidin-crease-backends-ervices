package com.solidincrease.authservice.service;



import com.solidincrease.authservice.email.EmailSenderService;
import com.solidincrease.authservice.entity.UserCredential;

import com.solidincrease.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private EmailSenderService senderService;
    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;



    public String saveUser(UserCredential credential) {

       if(repository.existsByName(credential.getName()))
       {
           return  "email already exists";
       }else {
           credential.setPassword(passwordEncoder.encode(credential.getPassword()));
           credential.setCode(null);
           repository.save(credential);
           return "user added to the system";
       }

    }

    public Optional<UserCredential> getUser(String username){

        return repository.findByName(username);
    }

    public String  generateToken(Optional<UserCredential> user) {
       String userName= user.get().getName();
       String id = String.valueOf(user.get().getId());
        return jwtService.generateToken(userName,id);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


    public String generateCode(String email) {
        if(repository.findByName(email) ==null)
        {
            return  " email dose not  exists";
        }else {
          String nr =  randomStringNumber();
            Optional<UserCredential> credential = repository.findByName(email);
            if (credential.isPresent()) {
                credential.get().setCode(nr);

                UserCredential userCredential =credential.get();
                 repository.save(userCredential);

                senderService.sendSimpleEmail(email,
                        "Single use code",
                        "Update password code " + nr);

                return "Code sent ";

            }else{
                return "Code not set";

            }
        }
    }



    public String UpdateCredentials(UserCredential credential) {
        Optional<UserCredential> userCred = repository.findByName(credential.getName());

        if(userCred.isPresent())
        {
            if (userCred.get().getCode() == credential.getCode() || userCred.get().getCode()!=null){
                userCred.get().setPassword(passwordEncoder.encode(credential.getPassword()));
                credential.setCode(null);
                userCred.get().setCode(null);
                repository.save(userCred.get());
                return "Password updated ";
            }
           else {
               return "incorrect code ";
            }



        }else  {
            return  " email dose not  exists";
        }

    }

    public String randomStringNumber(){

        Random rand = new Random();

        // Generate a random 6-digit number
        int digits6 = rand.nextInt(999999);
        String randomString = String.valueOf(digits6);

        // Generate a random letter
        char randomLetter = (char) (rand.nextInt(26) + 'A');

        // Combine the random number and letter
        String result = randomString + randomLetter;

        return result;

    }
}
