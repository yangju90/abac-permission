package indi.mat.design.service.user;

import indi.mat.design.domain.model.user.Application;
import indi.mat.design.dto.request.user.form.ApplicationForm;
import indi.mat.design.dto.request.user.query.ApplicationQuery;
import indi.mat.design.service.IBaseService;

/**
 * <p>
 * Application Info 服务类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
public interface IApplicationService extends IBaseService<Application,ApplicationForm,ApplicationQuery> {

}
