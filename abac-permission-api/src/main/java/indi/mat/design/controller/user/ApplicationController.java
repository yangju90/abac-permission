package indi.mat.design.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import indi.mat.design.controller.BaseController;
import indi.mat.design.domain.model.user.Application;
import indi.mat.design.dto.request.user.form.ApplicationForm;
import indi.mat.design.dto.request.user.query.ApplicationQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.user.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * Application Info ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/api/user/application")
public class ApplicationController extends BaseController {

    @Autowired
    private IApplicationService service;

    @GetMapping("{id}")
    public Response<Application> getById(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<Application>> getPage(ApplicationQuery query) {
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody @Valid ApplicationForm form) {
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid ApplicationForm form) {
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.deleteById(id));
    }


}
