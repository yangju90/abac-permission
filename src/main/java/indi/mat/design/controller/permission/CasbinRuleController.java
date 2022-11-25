package indi.mat.design.controller.permission;


import indi.mat.design.domain.model.permission.CasbinRule;
import indi.mat.design.dto.request.permission.form.CasbinRuleForm;
import indi.mat.design.dto.request.permission.query.CasbinRuleQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.permission.ICasbinRuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import indi.mat.design.controller.BaseController;

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


}
