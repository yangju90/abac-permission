package indi.mat.design.config;

import indi.mat.design.casbin.EnforcerAdapter;
import indi.mat.design.domain.model.permission.MetaData;
import indi.mat.design.service.permission.IMetaService;
import indi.mat.design.util.Constant;
import org.casbin.jcasbin.main.Enforcer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mat
 * @version : PermissionInterceptor, v 0.1 2022-11-30 0:06 Yang
 */
public class PermissionInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

    private final Enforcer enforcer;
    private final IMetaService metaService;

    public PermissionInterceptor(EnforcerAdapter adapter, IMetaService service) {
        this.enforcer = new Enforcer("examples/rbac_model.conf", adapter);
        this.metaService = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean flag = false;
        String accountId = request.getHeader(Constant.REQUEST_ACCOUNT_ID);
        if (accountId != null) {
            Long id = Long.valueOf(accountId);
            MetaData metaData = this.metaService.getMetaDataByAccountId(id);

            String method = request.getMethod();
            String url = request.getRequestURI().substring(request.getContextPath().length());

//            flag = this.enforcer.enforce(metaData.composeApiSubString(), metaData.composeDomainString(), url, method);

            logger.info("sub: " + metaData.composeApiSubString() + "\\n" +
                    "domain: " + metaData.composeDomainString() + "\\n" +
                    "data: " + url + "\\n" +
                    "act: " + method + "\\n" +
                    "result: " + flag);

            flag = this.enforcer.enforce("alice", "data1", "read");

        } else {
            throw new RuntimeException("account_id Header not exists!");
        }

        if (flag) return flag;

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Permission Denied!");
    }
}
