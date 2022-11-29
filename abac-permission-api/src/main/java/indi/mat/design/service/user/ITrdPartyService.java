package indi.mat.design.service.user;

import indi.mat.design.domain.model.user.TrdParty;
import indi.mat.design.dto.request.user.form.TrdPartyForm;
import indi.mat.design.dto.request.user.query.TrdPartyQuery;
import indi.mat.design.service.IBaseService;

/**
 * <p>
 * 3rd-Party 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public interface ITrdPartyService extends IBaseService<TrdParty, TrdPartyForm, TrdPartyQuery> {
    TrdParty getTrdPartyAccountId(Long accountId);
}
