package indi.mat.design.dto.request.user.form;

import indi.mat.design.domain.model.user.Application;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * Application Info Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public class ApplicationForm extends BaseForm {



    public  Application model(){
        Application model = new Application();
        BeanUtils.copyProperties(this, model);
        return model;
    }
}

