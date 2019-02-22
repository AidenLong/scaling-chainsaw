package com.me.mode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Autor syl
 * @Date 2019/2/22 14:04
 **/
public class CloudFactory {

    static Map<String, CloudSDK> cloudSDKMap = new HashMap<>();

    static {
        cloudSDKMap.put("ALISDK", new ALISDKAdapter(new ALISDK()));
        cloudSDKMap.put("AWSSDK", new AWSSDKAdapter(new AWSSDK()));
    }

    public static CloudSDK createCloudSDK(String cloudStrategy) {
        return cloudSDKMap.get(cloudStrategy);
    }
}
