package demo.mapper;

import demo.dto.UserDto;
import demo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(source = "identityNumber", target = "tckn")
    UserDto map(UserEntity userEntity);

    @Mapping(source = "tckn", target = "identityNumber")
    UserEntity map(UserDto dto);

    @Mapping(source = "tckn", target = "identityNumber")
    void map(UserDto dto, @MappingTarget UserEntity entity);
}
