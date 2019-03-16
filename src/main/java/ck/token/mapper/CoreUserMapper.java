package ck.token.mapper;

import ck.token.entity.CoreUser;
import org.apache.ibatis.annotations.Param;

public interface CoreUserMapper {
    CoreUser findByUserPhone(@Param("phone") String phone);

    CoreUser findUserById(@Param("Id") String Id);

}
