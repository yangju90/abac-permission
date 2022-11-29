package indi.mat.design.service.user.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.user.OrganizationRole;
import indi.mat.design.domain.persist.user.OrganizationRoleMapper;
import indi.mat.design.dto.request.user.form.OrganizationRoleForm;
import indi.mat.design.dto.request.user.query.OrganizationRoleQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.user.IOrganizationRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Organization Role 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@Service
public class OrganizationRoleServiceImpl extends BaseServiceImpl<OrganizationRole, OrganizationRoleForm, OrganizationRoleQuery> implements IOrganizationRoleService {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationRoleServiceImpl.class);

    @Autowired
    private OrganizationRoleMapper mapper;

    @Override
    protected BaseMapper<OrganizationRole> mapper() {
        return mapper;
    }

    @Override
    protected OrganizationRole model() {
        return new OrganizationRole();
    }

}
