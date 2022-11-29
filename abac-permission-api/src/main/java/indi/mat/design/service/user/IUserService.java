package indi.mat.design.service.user;

import indi.mat.design.domain.model.user.User;
import indi.mat.design.dto.request.user.form.UserForm;
import indi.mat.design.dto.request.user.query.UserQuery;
import indi.mat.design.service.IBaseService;

/**
 * <p>
 * User 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public interface IUserService extends IBaseService<User,UserForm,UserQuery> {

}
