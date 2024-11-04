package com.example.api.fw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.example.api", "com.example.common" })
public class AppConfig {

}
