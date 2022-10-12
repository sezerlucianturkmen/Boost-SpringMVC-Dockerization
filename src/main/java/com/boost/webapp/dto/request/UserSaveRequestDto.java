package com.boost.webapp.dto.request;

import com.boost.webapp.repository.entity.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserSaveRequestDto {
    String username;
    String password;
    String email;
    String gender;

}
