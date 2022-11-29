package indi.mat.design.controller.permission;


import indi.mat.design.casbin.EnforcerAdapter;
import indi.mat.design.domain.model.permission.CasbinRule;
import indi.mat.design.dto.request.permission.form.CasbinRuleForm;
import indi.mat.design.dto.request.permission.query.CasbinRuleQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.permission.ICasbinRuleService;
import indi.mat.design.util.EnforcerUtils;
import org.casbin.adapter.MybatisAdapter;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import indi.mat.design.controller.BaseController;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * <p>
 * ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-26
 */
@RestController
@RequestMapping("/api/casbin/casbinRule")
public class CasbinRuleController extends BaseController {

    @Autowired
    private ICasbinRuleService service;

    @Autowired
    EnforcerAdapter adapter;

    @GetMapping("{id}")
    public Response<CasbinRule> getById(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<CasbinRule>> getPage(CasbinRuleQuery query) {
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody @Valid CasbinRuleForm form) {
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid CasbinRuleForm form) {
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.deleteById(id));
    }

    @GetMapping("loadPolicy")
    public Response<List<CasbinRule>> loadPolicy() {
        Enforcer e = new Enforcer("examples/rbac_model.conf", adapter);
        e.clearPolicy();
        adapter.loadPolicy(e.getModel());
        return Response.SUCCESS(EnforcerUtils.modelToPolicyLines(e.getModel()));
    }


    public Response<List<CasbinRule>> savePolicy() {
        Enforcer e = new Enforcer("examples/rbac_model.conf", adapter);
        e.clearPolicy();
        adapter.loadPolicy(e.getModel());
        return Response.SUCCESS(EnforcerUtils.modelToPolicyLines(e.getModel()));
    }

}
