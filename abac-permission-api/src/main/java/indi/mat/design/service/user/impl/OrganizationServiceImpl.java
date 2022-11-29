package indi.mat.design.service.user.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.user.Organization;
import indi.mat.design.domain.persist.user.OrganizationMapper;
import indi.mat.design.dto.request.user.form.OrganizationForm;
import indi.mat.design.dto.request.user.query.OrganizationQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.user.IOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Organization 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, OrganizationForm, OrganizationQuery> implements IOrganizationService {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Autowired
    private OrganizationMapper mapper;

    @Override
    protected BaseMapper<Organization> mapper() {
        return mapper;
    }

    @Override
    protected Organization model() {
        return new Organization();
    }

}
