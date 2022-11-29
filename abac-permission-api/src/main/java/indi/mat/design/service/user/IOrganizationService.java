package indi.mat.design.service.user;

import indi.mat.design.domain.model.user.Organization;
import indi.mat.design.dto.request.user.form.OrganizationForm;
import indi.mat.design.dto.request.user.query.OrganizationQuery;
import indi.mat.design.service.IBaseService;

/**
 * <p>
 * Organization 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public interface IOrganizationService extends IBaseService<Organization,OrganizationForm,OrganizationQuery> {

}
