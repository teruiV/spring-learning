package com.frank.springlearning.http;

import okhttp3.*;

import java.io.IOException;

/**
 * @author jianweilin
 * @date 2018/7/31
 */
public class HttpDemo {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"comment\": \"\",\n" +
                "\t\"updateTime\": 1527595767,\n" +
                "\t\"blockId\": 80,\n" +
                "\t\"shortPinyin\": \"\",\n" +
                "\t\"esStatus\": 1,\n" +
                "\t\"lng\": 121.56266169348142,\n" +
                "\t\"id\": 1,\n" +
                "\t\"inService\": 1,\n" +
                "\t\"supplierId\": 1,\n" +
                "\t\"walkStatus\": 0,\n" +
                "\t\"isDefault\": 1,\n" +
                "\t\"areaId\": 10,\n" +
                "\t\"pinyin\": \"\",\n" +
                "\t\"cityId\": 1,\n" +
                "\t\"phone\": \"13900000001\",\n" +
                "\t\"address\": \"poiaddress门牌号\",\n" +
                "\t\"lat\": 31.252930015463065,\n" +
                "\t\"createTime\": 1450530336,\n" +
                "\t\"name\": \"合适的话哈哈哈哈哈哈哈哈合适的话哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈\",\n" +
                "\t\"mobile\": \"\",\n" +
                "\t\"bdPhotoUrl\": \"\",\n" +
                "\t\"isDel\": 0\n" +
                "}";

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url("http://192.168.1.202:8080/modelservice/supplierContact/v2/cache")
                .header("Content-Type", "application/json")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response = " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
