package indi.mat.design.service.user.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.mat.design.domain.model.user.Application;
import indi.mat.design.domain.persist.user.ApplicationMapper;
import indi.mat.design.dto.request.user.form.ApplicationForm;
import indi.mat.design.dto.request.user.query.ApplicationQuery;
import indi.mat.design.service.BaseServiceImpl;
import indi.mat.design.service.user.IApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Application Info 服务实现类
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Application, ApplicationForm, ApplicationQuery> implements IApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private ApplicationMapper mapper;

    @Override
    protected BaseMapper<Application> mapper() {
        return mapper;
    }

    @Override
    protected Application model() {
        return new Application();
    }

}
