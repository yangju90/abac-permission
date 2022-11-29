package indi.mat.design.dto.request.user.form;

import indi.mat.design.domain.model.user.User;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * User Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public class UserForm extends BaseForm {



    public User model(){
        User model = new User();
        BeanUtils.copyProperties(this,model);
        return model;
    }
}

