package indi.mat.design.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import indi.mat.design.controller.BaseController;
import indi.mat.design.domain.model.user.TrdParty;
import indi.mat.design.dto.request.user.form.TrdPartyForm;
import indi.mat.design.dto.request.user.query.TrdPartyQuery;
import indi.mat.design.dto.response.Response;
import indi.mat.design.service.user.ITrdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * <p>
 * 3rd-Party ?????
 * </p>
 *
 * @author Mat
 * @since 2022-11-29
 */
@RestController
@RequestMapping("/api/user/trdParty")
public class TrdPartyController extends BaseController {

    @Autowired
    private ITrdPartyService service;

    @GetMapping("{id}")
    public Response<TrdParty> getById(@PathVariable("id") Long id ){
        return Response.SUCCESS(service.selectById(id));
    }

    @GetMapping
    public Response<IPage<TrdParty>> getPage(TrdPartyQuery query){
        return Response.SUCCESS(service.queryPage(query));
    }

    @PutMapping
    public Response<Long> add(@RequestBody  @Valid TrdPartyForm form){
        return Response.SUCCESS(service.insert(form));
    }

    @PostMapping
    public Response<Integer> update(@RequestBody @Valid TrdPartyForm form){
        return Response.SUCCESS(service.updateById(form));
    }

    @DeleteMapping("{id}")
    public Response<Integer> delete(@PathVariable("id") Long id ){
         return Response.SUCCESS(service.deleteById(id));
    }


}
