package indi.mat.design.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import indi.mat.design.controller.BaseController;
import indi.mat.design.domain.model.user.Organization;
import indi.mat.design.dto.request.user.form.OrganizationForm;
import indi.mat.design.dto.request.user.query.OrganizationQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.user.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * <p>
 * Organization ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/api/user/organization")
public class OrganizationController extends BaseController {

    @Autowired
    private IOrganizationService service;

    @GetMapping("{id}")
    public Response<Organization> getById(@PathVariable("id") Long id ){
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<Organization>> getPage(OrganizationQuery query){
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody  @Valid OrganizationForm form){
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid OrganizationForm form){
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id ){
         return Response.SUCCESS(service.deleteById(id));
    }


}
