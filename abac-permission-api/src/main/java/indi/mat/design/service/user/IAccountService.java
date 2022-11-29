package indi.mat.design.service.user;

import indi.mat.design.domain.model.user.Account;
import indi.mat.design.dto.request.user.form.AccountForm;
import indi.mat.design.dto.request.user.query.AccountQuery;
import indi.mat.design.service.IBaseService;

/**
 * <p>
 * Account 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public interface IAccountService extends IBaseService<Account,AccountForm,AccountQuery> {

}
