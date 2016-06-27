package com.willen.woapi.controller;

import com.willen.openapi.model.PagingParam;
import com.willen.openapi.model.PagingResult;
import com.willen.openapi.model.Response;
import com.willen.openapi.jdbc.page.Paging;
import com.willen.woapi.param.AdvertiserParam;
import com.willen.woapi.result.AdvertiserResult;
import com.willen.woapi.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 控制器
 *
 * @author willen
 *
 */
@RestController //该注解进行对象与JASON 数据格式的序列化与反序列化
public class AdvertiserController {

    @Autowired
    private AdvertiserService advertiserService;

    @RequestMapping(value = "/advertisers", method = RequestMethod.GET)
    public Response listAdvertiser(
        PagingParam pagingParam
    ) {
        int pageNumber = pagingParam.getPagingNumber();
        int pageSize = pagingParam.getPageSize();
        String whereCondition = pagingParam.getWhereCondition("advertiser_name");
        String orderBy = pagingParam.getOrderBy();
        Paging<AdvertiserResult> advertiserResultPaging = advertiserService.getAdvertiserPaging(pageNumber, pageSize, whereCondition, orderBy);
        return new Response().success(new PagingResult<>(advertiserResultPaging));
    }

    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.GET)
    public Response getAdvertiser(
        @PathVariable("id") String advertiserId
    ) {
        AdvertiserResult advertiserResult = advertiserService.getAdvertiser(advertiserId);
        return new Response().success(advertiserResult);
    }

    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.PUT)
    public Response updateAdvertiser(
        @PathVariable("id") String advertiserId,
        @RequestBody @Valid AdvertiserParam advertiserParam
    ) {
        String advertiserName = advertiserParam.getAdvertiserName();
        String description = advertiserParam.getDescription();
        advertiserService.updateAdvertiser(advertiserId, advertiserName, description);
        return new Response().success();
    }

    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.DELETE)
    public Response deleteAdvertiser(
        @PathVariable("id") String advertiserId
    ) {
        advertiserService.deleteAdvertiser(advertiserId);
        return new Response().success();
    }

    @RequestMapping(value = "/advertiser", method = RequestMethod.POST)
    public Response createAdvertiser(
        @RequestBody @Valid AdvertiserParam advertiserParam
    ) {
        String advertiserName = advertiserParam.getAdvertiserName();
        String description = advertiserParam.getDescription();
        advertiserService.createAdvertiser(advertiserName, description);
        return new Response().success();
    }
}
