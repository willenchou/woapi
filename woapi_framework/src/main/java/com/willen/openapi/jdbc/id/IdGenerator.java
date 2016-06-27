package com.willen.openapi.jdbc.id;

import java.util.List;

/**
 * ID 生成器接口
 *
 * @author willen
 *
 */
public interface IdGenerator {

    String generateId();

    List<String> generateIdList(int count);
}
