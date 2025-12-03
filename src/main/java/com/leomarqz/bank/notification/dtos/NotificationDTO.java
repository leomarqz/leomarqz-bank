package com.leomarqz.bank.notification.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.leomarqz.bank.auth_users.dtos.UserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Long id;
    private String subject;

    @NotBlank(message = "Recipient is required")
    private String recipient;

    private String body;
    private String type; // Email, SMS, Push
    private LocalDateTime createdAt;

    // For values/variables to be passed into email template to send.
    private String templaName;
    private Map<String,Object> templateVariables;
}
