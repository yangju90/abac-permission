package indi.mat.design.controller.user;


import indi.mat.design.domain.model.user.Role;
import indi.mat.design.dto.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import  indi.mat.design.service.user.IRoleService;
import indi.mat.design.dto.request.user.query.RoleQuery;
import indi.mat.design.dto.request.user.form.RoleForm;
import org.springframework.web.bind.annotation.RestController;
import indi.mat.design.controller.BaseController;
/**
 * <p>
 * Role ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-28
 */
@RestController
@RequestMapping("/api/user/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService service;

    @GetMapping("{id}")
    public Response<Role> getById(@PathVariable("id") Long id ){
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<Role>> getPage(RoleQuery query){
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody  @Valid RoleForm form){
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid RoleForm form){
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id ){
         return Response.SUCCESS(service.deleteById(id));
    }


}
