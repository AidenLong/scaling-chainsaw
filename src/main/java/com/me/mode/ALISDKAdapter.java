package com.me.mode;

/**
 * @Autor syl
 * @Date 2019/2/22 14:07
 **/
public class ALISDKAdapter implements CloudSDK {

    ALISDK alisdk;

    public ALISDKAdapter(ALISDK alisdk) {
        this.alisdk = alisdk;
    }

    @Override
    public void putObject(String fileName) {
        alisdk.setBucket();
        alisdk.uploadFile(fileName);
    }
}
