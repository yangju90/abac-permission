package indi.mat.design.service.user.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import indi.mat.design.domain.model.permission.MetaData;
import indi.mat.design.domain.model.user.Organization;
import indi.mat.design.domain.model.user.TrdParty;
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

    @Override
    public Organization getOrganizationByAccountId(Long accountId) {
        LambdaQueryWrapper<Organization> wapper = new LambdaQueryWrapper<>();
        wapper.eq(Organization:: getAccountId, accountId);
        Organization organization= mapper.selectOne(wapper);
        return organization;
    }
}
