package indi.mat.design.service.user;

import indi.mat.design.domain.model.user.OrganizationRole;
import indi.mat.design.dto.request.user.form.OrganizationRoleForm;
import indi.mat.design.dto.request.user.query.OrganizationRoleQuery;
import indi.mat.design.service.IBaseService;

/**
 * <p>
 * Organization Role 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public interface IOrganizationRoleService extends IBaseService<OrganizationRole,OrganizationRoleForm,OrganizationRoleQuery> {

}
