package com.smart.simplechat.common.repo.user.impl.mongo.mapper;

import java.util.List;

import com.smart.simplechat.common.mapper.CommonMapperConfig;
import com.smart.simplechat.common.model.User;
import com.smart.simplechat.common.repo.user.impl.mongo.document.UserDocument;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface UserDocumentMapper {

  UserDocument toDocument(User user);

  User toModel(UserDocument document);

  List<User> toModels(List<UserDocument> users);
}
