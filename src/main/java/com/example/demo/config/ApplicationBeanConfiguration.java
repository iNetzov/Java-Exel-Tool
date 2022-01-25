package com.example.demo.config;

import com.example.demo.utils.XmlParser;
import com.example.demo.utils.impl.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public XmlParser xmlParser (){
        return new XmlParserImpl();
    }
}
