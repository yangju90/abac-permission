package indi.mat.design.domain.persist.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.user.Account;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 * Account Mapper 接口
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
