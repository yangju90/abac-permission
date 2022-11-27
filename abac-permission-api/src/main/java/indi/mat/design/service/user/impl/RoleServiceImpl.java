package indi.mat.design.service.user.impl;


import indi.mat.design.domain.model.user.Role;
import indi.mat.design.domain.persist.user.RoleMapper;
import indi.mat.design.dto.request.user.query.RoleQuery;
import indi.mat.design.dto.request.user.form.RoleForm;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.user.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Role 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-28
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleForm, RoleQuery> implements IRoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper mapper;

    @Override
    protected BaseMapper<Role> mapper() {
        return mapper;
    }

    @Override
    protected Role model() {
        return new Role();
    }

}
