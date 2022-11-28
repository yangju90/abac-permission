package indi.mat.design.service.permission.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.permission.CasbinRule;
import indi.mat.design.domain.persist.permission.CasbinRuleMapper;
import indi.mat.design.dto.request.permission.form.CasbinRuleForm;
import indi.mat.design.dto.request.permission.query.CasbinRuleQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.permission.ICasbinRuleService;
import org.casbin.jcasbin.model.Assertion;
import org.casbin.jcasbin.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public String[] loadPolicy(Model model) {
        int p = 0,g = 0;
        for (Map.Entry<String, Assertion> entry : model.model.get("p").entrySet()) {
            String ptype = entry.getKey();
            Assertion ast = entry.getValue();

            for (List<String> rule : ast.policy) {
                CasbinRule line = createPolicyLine(ptype, rule);
                mapper.insert(line);
                p++;
            }
        }

        for (Map.Entry<String, Assertion> entry : model.model.get("g").entrySet()) {
            String ptype = entry.getKey();
            Assertion ast = entry.getValue();

            for (List<String> rule : ast.policy) {
                CasbinRule line = createPolicyLine(ptype, rule);
                mapper.insert(line);
                g++;
            }
        }

        return new String[]{
                "insert p " + p,
                "insert g " + g
        };
    }

    private CasbinRule createPolicyLine(String ptype, List<String> rule) {
        CasbinRule line = new CasbinRule();

        line.setPtype(ptype);
        if (rule.size() > 0) {
            line.setv0(rule.get(0));
        }
        if (rule.size() > 1) {
            line.setv1(rule.get(1));
        }
        if (rule.size() > 2) {
            line.setv2(rule.get(2));
        }
        if (rule.size() > 3) {
            line.setv3(rule.get(3));
        }
        if (rule.size() > 4) {
            line.setv4(rule.get(4));
        }
        if (rule.size() > 5) {
            line.setv5(rule.get(5));
        }

        line.setInUser("api");
        line.setInDate(new Date().getTime());

        return line;
    }
}
