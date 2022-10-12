package com.boost.webapp.mapper;

import com.boost.webapp.dto.request.UserDetailSaveRequestDto;
import com.boost.webapp.dto.response.UserDetailFindAllResponseDto;
import com.boost.webapp.dto.response.UserDetailFindByIdResponseDto;
import com.boost.webapp.repository.entity.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserDetailMapper {
    IUserDetailMapper INSTANCE=Mappers.getMapper(IUserDetailMapper.class);

    UserDetail toUserDetail(final UserDetailSaveRequestDto dto);
    UserDetailFindByIdResponseDto toUserDetailDetailFindByIdResponseDto(final UserDetail userDetail);
    List<UserDetailFindAllResponseDto> toUserDetailfindAllReponseDto(final List<UserDetail> userDetailList);
    
}
