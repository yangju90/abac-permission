package indi.mat.design.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import indi.mat.design.controller.BaseController;
import indi.mat.design.domain.model.user.OrganizationRole;
import indi.mat.design.dto.request.user.form.OrganizationRoleForm;
import indi.mat.design.dto.request.user.query.OrganizationRoleQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.user.IOrganizationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * Organization Role ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/api/user/organizationRole")
public class OrganizationRoleController extends BaseController {

    @Autowired
    private IOrganizationRoleService service;

    @GetMapping("{id}")
    public Response<OrganizationRole> getById(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<OrganizationRole>> getPage(OrganizationRoleQuery query) {
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody @Valid OrganizationRoleForm form) {
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid OrganizationRoleForm form) {
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id) {
        return Response.SUCCESS(service.deleteById(id));
    }


}
