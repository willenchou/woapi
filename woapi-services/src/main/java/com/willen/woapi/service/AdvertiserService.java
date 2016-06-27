package com.willen.woapi.service;

import com.willen.openapi.jdbc.ServiceException;
import com.willen.openapi.jdbc.dao.DataAccessor;
import com.willen.openapi.jdbc.id.IdGenerator;
import com.willen.openapi.jdbc.page.Paging;
import com.willen.openapi.util.DateUtil;
import com.willen.woapi.constant.Message;
import com.willen.woapi.result.AdvertiserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 广告主服�?
 *
 * @author willen
 *
 */
@Service
public class AdvertiserService {

    @Autowired
    private DataAccessor dataAccessor;

    @Autowired
    private IdGenerator idGenerator;

    public Paging<AdvertiserResult> getAdvertiserPaging(int pageNumber, int pageSize, String whereCondition, String orderBy) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereCondition", whereCondition);
        paramMap.put("orderBy", orderBy);
        return dataAccessor.selectPaging("AdvertiserMapper.selectAdvertiserPaging", paramMap, pageNumber, pageSize);
    }

    public AdvertiserResult getAdvertiser(String advertiserId) {
        AdvertiserResult advertiserResult = dataAccessor.selectOne("AdvertiserMapper.selectAdvertiserById", advertiserId);
        if (advertiserResult == null) {
            throw new ServiceException(Message.QUERY_FAILURE);
        }
        return advertiserResult;
    }

    @Transactional
    public void updateAdvertiser(String advertiserId, String advertiserName, String description) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", advertiserId);
        paramMap.put("advertiserName", advertiserName);
        paramMap.put("description", description);
        dataAccessor.update("AdvertiserMapper.updateAdvertiser", paramMap);
    }

    @Transactional
    public void deleteAdvertiser(String advertiserId) {
        dataAccessor.update("AdvertiserMapper.deleteAdvertiser", advertiserId);
    }

    @Transactional
    public void createAdvertiser(String advertiserName, String description) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", idGenerator.generateId());
        paramMap.put("advertiserName", advertiserName);
        paramMap.put("description", description);
        paramMap.put("createdTime", DateUtil.getCurrentDateTime());
        dataAccessor.insert("AdvertiserMapper.insertAdvertiser", paramMap);
    }
}
