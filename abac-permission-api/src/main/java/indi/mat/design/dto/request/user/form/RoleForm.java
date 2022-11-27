package indi.mat.design.dto.request.user.form;

import indi.mat.design.domain.model.user.Role;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * Role Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-28
 */
public class RoleForm extends BaseForm {



    public Role model(){
        Role model = new Role();
        BeanUtils.copyProperties(this,model);
        return model;
    }
}

