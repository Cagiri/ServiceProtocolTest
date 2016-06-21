package com.serviceprotocol.protobuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication
public class ProtobufServerExp {
	
	public static void main(String[] args) {
        SpringApplication.run(ProtobufServerExp.class, args);
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
}
