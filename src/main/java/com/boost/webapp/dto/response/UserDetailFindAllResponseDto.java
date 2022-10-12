package com.boost.webapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDetailFindAllResponseDto {
    String name;
    String surname;
    String address;
    String telephone;
    String dob;
}
