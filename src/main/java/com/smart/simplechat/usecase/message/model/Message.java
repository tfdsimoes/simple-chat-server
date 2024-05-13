package com.smart.simplechat.usecase.message.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {

  String from;

  String timeStamp;

  String content;
}
