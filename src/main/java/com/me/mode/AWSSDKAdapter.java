package com.me.mode;

/**
 * @Autor syl
 * @Date 2019/2/22 14:07
 **/
public class AWSSDKAdapter implements CloudSDK {

    AWSSDK awssdk;

    public AWSSDKAdapter(AWSSDK awssdk) {
        this.awssdk = awssdk;
    }

    @Override
    public void putObject(String fileName) {
        awssdk.putObject(fileName);
    }
}
