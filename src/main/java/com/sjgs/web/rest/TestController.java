package com.sjgs.web.rest;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.core.oauth.CustomUserDetails;
import io.choerodon.core.oauth.DetailsHelper;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "test")
@RestController("TestController.v1")
@RequestMapping("/v1/{organizationId}/test")
public class TestController {

    @ApiOperation(value = "hello world")
    @Permission(level = ResourceLevel.ORGANIZATION, tags = {})
    @GetMapping
    public ResponseEntity<String> hello(@PathVariable @ApiParam(value = "租户ID", required = true, example = "0") long organizationId) {
        return ResponseEntity.ok("hello world");
    }

    @ApiOperation(value = "user")
    @Permission(level = ResourceLevel.ORGANIZATION, tags = {})
    @GetMapping("user")
    public ResponseEntity<Object> user(@PathVariable @ApiParam(value = "租户ID", required = true, example = "0") long organizationId) {
        CustomUserDetails userDetails = DetailsHelper.getUserDetails();
        return ResponseEntity.ok(userDetails);
    }

}
