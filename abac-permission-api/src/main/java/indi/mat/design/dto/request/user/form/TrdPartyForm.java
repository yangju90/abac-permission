package indi.mat.design.dto.request.user.form;

import indi.mat.design.domain.model.user.TrdParty;
import indi.mat.design.dto.request.BaseForm;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 3rd-Party Form
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public class TrdPartyForm extends BaseForm {



    public TrdParty model(){
        TrdParty model = new TrdParty();
        BeanUtils.copyProperties(this,model);
        return model;
    }
}

