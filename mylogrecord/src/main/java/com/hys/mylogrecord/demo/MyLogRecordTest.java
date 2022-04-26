package com.hys.mylogrecord.demo;

import com.hys.mylogrecord.aop.annotation.MyLogRecord;
import com.hys.mylogrecord.demo.dto.ProductContentDTO;
import com.hys.mylogrecord.log.OperationLogTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Robert Hou
 * @since 2022年04月26日 18:39
 **/
@Component
@Slf4j
public class MyLogRecordTest {

    @MyLogRecord(
            type = OperationLogTypeEnum.INSERT_PRODUCT,
            relationId = "123",
            operatorId = "456",
            description = "添加商品")
    public void simpleTest() {
        log.info("执行业务操作...");
    }

    @MyLogRecord(
            type = OperationLogTypeEnum.INSERT_PRODUCT,
            relationId = "{#spuId}",
            operatorId = "{#operatorId}",
            description = "添加商品 {#productContentDTO.content}")
    public void dynamicTemplateTest(Long spuId, Long operatorId, ProductContentDTO productContentDTO) {
        log.info("执行业务操作...");
    }
}
