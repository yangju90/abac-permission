package indi.mat.design.dto.request.permission.form;


import indi.mat.design.domain.model.permission.CasbinRule;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 *  Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-26
 */
public class CasbinRuleForm extends BaseForm {



    public CasbinRule model(){
        CasbinRule model = new CasbinRule();
        BeanUtils.copyProperties(this,model);
        return model;
    }
}

