package indi.mat.design.dto.request.user.form;

import indi.mat.design.domain.model.user.Organization;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * Organization Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public class OrganizationForm extends BaseForm {



    public Organization model(){
        Organization model = new Organization();
        BeanUtils.copyProperties(this,model);
        return model;
    }
}

