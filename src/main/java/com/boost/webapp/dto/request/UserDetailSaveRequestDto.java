package com.boost.webapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDetailSaveRequestDto {
    String name;
    String surname;
    String address;
    String telephone;
    String dob;
}
