package indi.mat.design.service.permission.impl;


import indi.mat.design.domain.model.permission.CasbinRule;
import indi.mat.design.domain.persist.permission.CasbinRuleMapper;
import indi.mat.design.dto.request.permission.form.CasbinRuleForm;
import indi.mat.design.dto.request.permission.query.CasbinRuleQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.permission.ICasbinRuleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-26
 */
@Service
public class CasbinRuleServiceImpl extends BaseServiceImpl<CasbinRule, CasbinRuleForm, CasbinRuleQuery> implements ICasbinRuleService {

    private static final Logger logger = LoggerFactory.getLogger(CasbinRuleServiceImpl.class);

    @Autowired
    private CasbinRuleMapper mapper;

    @Override
    protected BaseMapper<CasbinRule> mapper() {
        return mapper;
    }

    @Override
    protected CasbinRule model() {
        return new CasbinRule();
    }

}
