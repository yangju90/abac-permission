package indi.mat.design.service.user;

import indi.mat.design.domain.model.user.Role;
import indi.mat.design.dto.request.user.query.RoleQuery;
import indi.mat.design.dto.request.user.form.RoleForm;
import indi.mat.design.service.IBaseService;


/**
 * <p>
 * Role 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-28
 */
public interface IRoleService extends IBaseService<Role, RoleForm, RoleQuery> {

}
