package com.me.mode;

/**
 * @Autor syl
 * @Date 2019/2/22 13:53
 **/
public class CloudService {

    CloudSDK cloudSDK;

    public CloudService(String cloudStrategy) {
        cloudSDK = CloudFactory.createCloudSDK(cloudStrategy);
    }

    public void uoloadFile(String fileName) {
        cloudSDK.putObject(fileName);
    }
}
