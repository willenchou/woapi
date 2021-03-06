package com.willen.woapi.param;

import com.willen.openapi.validation.NotEmpty;

/**
 * 广告主参数对�?
 *
 * @author willen
 *
 */
public class AdvertiserParam {

    @NotEmpty
    private String advertiserName;

    private String description;

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
