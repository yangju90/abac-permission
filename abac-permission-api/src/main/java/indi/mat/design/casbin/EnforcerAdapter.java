package indi.mat.design.casbin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import indi.mat.design.domain.model.permission.CasbinRule;
import indi.mat.design.domain.persist.permission.CasbinRuleMapper;
import indi.mat.design.util.EnforcerUtils;
import org.apache.commons.collections.CollectionUtils;
import org.casbin.jcasbin.model.Model;
import org.casbin.jcasbin.persist.Adapter;
import org.casbin.jcasbin.persist.BatchAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mat
 * @version : EnforcerAdapter, v 0.1 2022-11-29 23:32 Yang
 */

@Service
public class EnforcerAdapter implements Adapter, BatchAdapter {

    private static final Logger logger = LoggerFactory.getLogger(EnforcerAdapter.class);

    @Autowired
    CasbinRuleMapper mapper;

    @Override
    public void loadPolicy(Model model) {
        LambdaQueryWrapper<CasbinRule> wapper = new LambdaQueryWrapper<>();
        List<CasbinRule> casbinRules = mapper.selectList(wapper);
        EnforcerUtils.policyLinesToModel(casbinRules, model);
    }

    @Override
    public void savePolicy(Model model) {
        List<Integer> ans = new ArrayList<>();
        List<CasbinRule> rules = EnforcerUtils.modelToPolicyLines(model);
        for(CasbinRule rule : rules){
            int i = mapper.insert(rule);
            ans.add(i);
        }

        logger.info("insert casbin roles, ids :" + ans.toArray().toString());
    }

    @Override
    public void addPolicy(String sec, String ptype, List<String> rule) {
        if(CollectionUtils.isEmpty(rule)) return;
        CasbinRule line = EnforcerUtils.createPolicyLine(ptype, rule);
        mapper.insert(line);
    }

    @Override
    public void removePolicy(String sec, String ptype, List<String> rule) {

    }

    @Override
    public void removeFilteredPolicy(String sec, String ptype, int fieldIndex, String... fieldValues) {

    }

    @Override
    public void addPolicies(String sec, String ptype, List<List<String>> rules) {

    }

    @Override
    public void removePolicies(String sec, String ptype, List<List<String>> rules) {

    }
}
