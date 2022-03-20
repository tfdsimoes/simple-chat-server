package com.smart.simplechat.usecase.message.mapper;

import com.smart.simplechat.common.mapper.CommonMapperConfig;
import com.smart.simplechat.rest.controller.model.MessageAnswerDTO;
import com.smart.simplechat.rest.controller.model.MessageRequestDTO;
import com.smart.simplechat.usecase.message.model.Message;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface MessageMapper {

  Message toModel(MessageRequestDTO messageRequestDTO, String from, String timeStamp);

  MessageAnswerDTO toDTO(Message message);
}
