package indi.mat.design.service.user.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.user.User;
import indi.mat.design.domain.persist.user.UserMapper;
import indi.mat.design.dto.request.user.form.UserForm;
import indi.mat.design.dto.request.user.query.UserQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * User 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserForm, UserQuery> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper mapper;

    @Override
    protected BaseMapper<User> mapper() {
        return mapper;
    }

    @Override
    protected User model() {
        return new User();
    }

}
