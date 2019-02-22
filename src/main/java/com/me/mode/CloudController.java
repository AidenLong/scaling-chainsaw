package com.me.mode;

/**
 * @Autor syl
 * @Date 2019/2/22 13:53
 **/
public class CloudController {

    CloudService cloudService;

    public CloudController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    public void storeFileToCloud() {
        cloudService.uoloadFile("222.txt");
    }

    public static void main(String[] args) {
        CloudController cloudController = new CloudController(new CloudService("ALISDK"));
        cloudController.storeFileToCloud();
    }
}
