package com.smart.simplechat.usecase.user.mapper;

import java.util.List;

import com.smart.simplechat.common.mapper.CommonMapperConfig;
import com.smart.simplechat.rest.controller.model.UserAnswerDTO;
import com.smart.simplechat.rest.controller.model.UserRequestDTO;
import com.smart.simplechat.common.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapperConfig.class)
public interface UserMapper {

  @Mapping(target = "id", ignore = true)
  User toModel(UserRequestDTO dto);

  UserAnswerDTO toDTO(User user);

  List<UserAnswerDTO> toDTOs(List<User> users);
}
