package indi.mat.design.dto.request.user.form;

import indi.mat.design.domain.model.user.OrganizationRole;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * Organization Role Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public class OrganizationRoleForm extends BaseForm {



    public OrganizationRole model(){
        OrganizationRole model = new OrganizationRole();
        BeanUtils.copyProperties(this,model);
        return model;
    }
}

