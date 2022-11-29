package indi.mat.design.service.permission;

import indi.mat.design.domain.model.permission.CasbinRule;
import indi.mat.design.dto.request.permission.form.CasbinRuleForm;
import indi.mat.design.dto.request.permission.query.CasbinRuleQuery;
import indi.mat.design.service.IBaseService;
import org.casbin.jcasbin.model.Model;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-26
 */
public interface ICasbinRuleService extends IBaseService<CasbinRule, CasbinRuleForm, CasbinRuleQuery> {
}
