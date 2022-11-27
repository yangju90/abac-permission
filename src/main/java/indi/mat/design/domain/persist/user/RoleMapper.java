package indi.mat.design.domain.persist.user;

import indi.mat.design.domain.model.user.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 * Role Mapper 接口
 * </p>
 *
 * @author Mat
 * @since 2022-11-28
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
