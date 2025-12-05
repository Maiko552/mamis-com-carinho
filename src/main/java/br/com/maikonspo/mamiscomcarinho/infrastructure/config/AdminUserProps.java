package br.com.maikonspo.mamiscomcarinho.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.admin")
public record AdminUserProps(
        String username,
        String password
) {}
