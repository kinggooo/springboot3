package com.wangnz.springboot.hello.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BHUtil {

    private static String RSA_PUBLIC_KEY;

    @Value("${sb.rsaPubKey}")
    public void setRSAKey(String rsaKey) {
        RSA_PUBLIC_KEY = rsaKey;
    }

//    public static InterfaceUploadResponse encryptUploadField(List<String> datas) {
//        InterfaceUploadRequest req = new InterfaceUploadRequest();
//        //设置待加密的原始数据集合
//        req.setData(datas);
//        BhCreditWebApiClient client = new BhCreditWebApiClient();
//        //初始化设置RSA公钥
//        try {
//            client.init(RSAUtil.readRSAPublicKey(RSA_PUBLIC_KEY));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //执行加密操作
//        InterfaceUploadResponse response = client.execute(req);
//        if (response.isSuccess) {
////            List<String> data = response.getEncryptData();
////            for (int i = 0; i < data.size(); i++) {
////                System.out.println(data.get(i));
////            }
//            System.out.println("encrypt success;encrypt data = " + response.getEncryptData());
//        } else {
//            System.out.println("encrypt fail;errorMessage = " + response.getErrorMessage());
//        }
//        return response;
//    }
}
