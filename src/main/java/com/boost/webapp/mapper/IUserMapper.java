package com.boost.webapp.mapper;

import com.boost.webapp.dto.request.LoginRequestDto;
import com.boost.webapp.dto.request.UserSaveRequestDto;
import com.boost.webapp.dto.response.UserFindAllResponseDto;
import com.boost.webapp.dto.response.UserFindByIdResponseDto;
import com.boost.webapp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
   IUserMapper INSTANCE=Mappers.getMapper(IUserMapper.class);

   User toUser(final UserSaveRequestDto dto);
   UserFindByIdResponseDto toUserDetailFindByIdResponseDto (final User user);
   List<UserFindAllResponseDto> toUserfindAllReponseDto(final List<User> userList);

   User toUser(final LoginRequestDto dto);


}
