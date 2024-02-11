package com.latihan.adi.service;

import com.latihan.adi.entity.TblUsers;
import com.latihan.adi.pojo.UsersPostPojo;
import com.latihan.adi.repository.UserRepository;
import com.latihan.adi.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserPostService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<MessageModel> addDataUsers(UsersPostPojo usersPostPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            TblUsers tblUsers = new TblUsers();
            tblUsers.setIdUser(UUID.randomUUID());
            tblUsers.setNameUser(usersPostPojo.getNamaUser());
            tblUsers.setRoleUser(usersPostPojo.getRoleUser());

            userRepository.save(tblUsers);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("Data", tblUsers);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

}
