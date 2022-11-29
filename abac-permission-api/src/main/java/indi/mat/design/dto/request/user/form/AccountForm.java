package indi.mat.design.dto.request.user.form;

import indi.mat.design.domain.model.user.Account;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * Account Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public class AccountForm extends BaseForm {



    public Account model(){
        Account model = new Account();
        BeanUtils.copyProperties(this,model);
        return model;
    }
}

