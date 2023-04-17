package com.issuetracker.engine.domain.service;

import com.issuetracker.engine.domain.dto.UserDto;
import com.issuetracker.engine.domain.model.entity.UserEntity;
import com.issuetracker.engine.domain.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNmUser(userDto.getUserName());
        userEntity.setNmDepartment(userDto.getUserDepartment());
        userEntity.setPhone(userDto.getUserPhone());
        userEntity.setDsEmail(userDto.getUserEmail());
        UserEntity saved = userEntityRepository.save(userEntity);

        UserDto userDtoResponse = new UserDto();
        userDtoResponse.setUserCode(String.valueOf(saved.getCdUser()));

        return userDtoResponse;
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = userEntityRepository.findAll();

        List<UserDto> response = new ArrayList<UserDto>();

        userEntities.forEach(entity -> {
            UserDto dto = new UserDto();
            dto.setUserCode(String.valueOf(entity.getCdUser()));
            dto.setUserEmail(entity.getDsEmail());
            dto.setUserName(entity.getNmUser());
            dto.setUserPhone(entity.getPhone());
            dto.setUserDepartment(entity.getNmDepartment());

            response.add(dto);
        });

//        List<UserDto> responseMapped =   userEntities.stream().map(entity -> {
//            UserDto dto = new UserDto();
//            dto.setUserCode(String.valueOf(entity.getCdUser()));
//            dto.setUserEmail(entity.getDsEmail());
//            dto.setUserName(entity.getNmUser());
//            dto.setUserPhone(entity.getPhone());
//            dto.setUserDepartment(entity.getNmDepartment());
//            return dto;
//        }).collect(Collectors.toList());


        return response;
    }


}
