package com.ruoyi.travel.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;

public class ZfbUtil {

    public void t1() throws Exception{
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHUEGDJ18+ymL4hnW/eDdyiPHF1D4SxJCCccs8j6gsHj4IDVMjCQRvz0ioBtcdLxZSkoJE2SMIP2XGs+cn4q8yhSg/Dxy7au8w/dWIGM5dnA3n+IsYMwFNfEi3L8zI5bAwerUfTeohjuYbuW6VhL0+7dCRrC+/Fb6Nqr/+Ds81EzXxrV0Xs6MtONF4vvRkLm2/RFivA57gJsQkaIWUgktRzZN35iNnrDNoDqls071YO04ra17DJg1MhnW6nodZW+Ag8gzrq0Vgw4G6v6714/j27GYuotRaS/zrL2RqKnHKLr7snLw541NgmDcuklMLIoAwtmpJZxzD5NJwF9bAg4T/AgMBAAECggEAZV4yNdag+6ESU6wnObENmLgOp21Asz6eI5qr7kqQabyeK9oPlgeDU1+txnKZZDuKNYGcJYelPuB/lkPfv3mKVgZ7CAKCO8T4O3NtK++paWcm48jGKvLK3wlkUBd3CmlHfInwdesgotMyf0KDHW+7dhEiVn7vpe7cObTY77KYd+E84JGVu1Ljlq5mGWGWanxpkjfQZiD0W//ipQEEAymyz69pvdxedRXyn516oV8eEVUnrZZO3tiSJ0IVeII33ir60OfY508jMCqjmV2emJuBnR2lZpxOWrrBajY920NtYczBf2Mt7xXcUeoRhv6ozBIv9XC6c1XrE+2xlNSfaAuKgQKBgQDHJSwCqu1ZLGQvRcP+ZEbuvkefI1tjYfCrM4FVLqwO1sApkVb0y3RPC5OuCmSFmRZ1JDJ/Ji4zxmJLW1pi23or1/YMgE08p5qDC/EuVNnZaACrgcf0b/RONFF7JtSC4bzXRt+zzwTmswzpDNADJ70u0axomruZzymS9nMZXXwjOQKBgQCt8dj2PlfrQxqllEJrHKFv07hXccmMj0AS/ft09ELUMB9CiWEwxZNqHBK5+47husnygFQ2+j53dG6vIogtKpBF45rhrjF4ZVNwtWQhp7PuH6xEz3gHIbuxBkAwgMYkG6iojc/Rd9J5/GRzi0DVEUQM9j/cM6cjy9j2IOKUcNzR9wKBgG6PFH/mpR58pqIX+VeiFD83JEwVNQdXuGVTktnXr24Ni2GIbt44lbnMk5Br9KK2+uDN17r/V2cnHCr57JQ1hP4SR2dpU3f5FK7sUlmGgetQ8g5FXt01ykwgf5v/UrvW1yAtGMSaif4KKYC4vEMELONxRGZOgRhDCrGsYPoUDHcBAoGAS8M4LeDvqF/8/ju6Ri8dPbjo5OWB1QAb92m6mbE+Xm9rXi66L2UPFTuPCITCMh2Kkl5E0AFlLeB/yTZwO8P7PQWq0zts/rSbiE7pgyMpYsFW5k27SNfviWZglP+xzc5iQrAp4WGgQlOlaRIxNdykWET1gbLZzOSf5mxiZCdYdvcCgYAf2S8MWoLg8WhctqEhUG1RWv14icMBXkdCFQtCN+eGossELf92SVM9FRS5l5Ve5+xvfLcVtnf+1D7iuldoLPHD2imB+I+eiqVQNVoAx7eo6xJR5klCgxxWSW/f9m1wmX5rTsVezYp/2VPg36c/C7fKAEDQZml+H1D0AiyWLn7ZsQ==";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh1BBgydfPspi+IZ1v3g3cojxxdQ+EsSQgnHLPI+oLB4+CA1TIwkEb89IqAbXHS8WUpKCRNkjCD9lxrPnJ+KvMoUoPw8cu2rvMP3ViBjOXZwN5/iLGDMBTXxIty/MyOWwMHq1H03qIY7mG7lulYS9Pu3QkawvvxW+jaq//g7PNRM18a1dF7OjLTjReL70ZC5tv0RYrwOe4CbEJGiFlIJLUc2Td+YjZ6wzaA6pbNO9WDtOK2tewyYNTIZ1up6HWVvgIPIM66tFYMOBur+u9eP49uxmLqLUWkv86y9kaipxyi6+7Jy8OeNTYJg3LpJTCyKAMLZqSWccw+TScBfWwIOE/wIDAQAB";
        String appId = "2021001130603749";
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",appId,privateKey,"json","GBK",publicKey,"RSA2");

        request.setBizContent("{" +
                "\"out_trade_no\":\"20150320010101001\"," +
                "\"seller_id\":\"2088102146225135\"," +
                "\"total_amount\":88.88," +
                "\"discountable_amount\":8.88," +
                "\"undiscountable_amount\":80.00," +
                "\"buyer_logon_id\":\"15901825620\"," +
                "\"subject\":\"Iphone6 16G\"," +
                "\"body\":\"Iphone6 16G\"," +
                "\"buyer_id\":\"2088102146225135\"," +
                "      \"goods_detail\":[{" +
                "        \"goods_id\":\"apple-01\"," +
                "\"alipay_goods_id\":\"20010001\"," +
                "\"goods_name\":\"ipad\"," +
                "\"quantity\":1," +
                "\"price\":2000," +
                "\"goods_category\":\"34543238\"," +
                "\"categories_tree\":\"124868003|126232002|126252004\"," +
                "\"body\":\"特价手机\"," +
                "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
                "        }]," +
                "\"product_code\":\"FACE_TO_FACE_PAYMENT\"," +
                "\"operator_id\":\"Yx_001\"," +
                "\"enable_pay_channels\":\"pcredit,moneyFund,debitCardExpress\"," +
                "\"store_id\":\"NJ_001\"," +
                "\"disable_pay_channels\":\"pcredit,moneyFund,debitCardExpress\"," +
                "\"terminal_id\":\"NJ_T_001\"," +
                "\"extend_params\":{" +
                "\"sys_service_provider_id\":\"2088511833207846\"," +
                "\"hb_fq_num\":\"3\"," +
                "\"hb_fq_seller_percent\":\"100\"," +
                "\"industry_reflux_info\":\"{\\\\\\\"scene_code\\\\\\\":\\\\\\\"metro_tradeorder\\\\\\\",\\\\\\\"channel\\\\\\\":\\\\\\\"xxxx\\\\\\\",\\\\\\\"scene_data\\\\\\\":{\\\\\\\"asset_name\\\\\\\":\\\\\\\"ALIPAY\\\\\\\"}}\"," +
                "\"card_type\":\"S0JP0000\"" +
                "    }," +
                "\"timeout_express\":\"90m\"," +
                "\"royalty_info\":{" +
                "\"royalty_type\":\"ROYALTY\"," +
                "        \"royalty_detail_infos\":[{" +
                "          \"serial_no\":1," +
                "\"trans_in_type\":\"userId\"," +
                "\"batch_no\":\"123\"," +
                "\"out_relation_id\":\"20131124001\"," +
                "\"trans_out_type\":\"userId\"," +
                "\"trans_out\":\"2088101126765726\"," +
                "\"trans_in\":\"2088101126708402\"," +
                "\"amount\":0.1," +
                "\"desc\":\"分账测试1\"," +
                "\"amount_percentage\":\"100\"" +
                "          }]" +
                "    }," +
                "\"settle_info\":{" +
                "        \"settle_detail_infos\":[{" +
                "          \"trans_in_type\":\"cardAliasNo\"," +
                "\"trans_in\":\"A0001\"," +
                "\"summary_dimension\":\"A0001\"," +
                "\"settle_entity_id\":\"2088xxxxx;ST_0001\"," +
                "\"settle_entity_type\":\"SecondMerchant、Store\"," +
                "\"amount\":0.1" +
                "          }]" +
                "    }," +
                "\"alipay_store_id\":\"2016041400077000000003314986\"," +
                "\"sub_merchant\":{" +
                "\"merchant_id\":\"19023454\"," +
                "\"merchant_type\":\"alipay: 支付宝分配的间连商户编号, merchant: 商户端的间连商户编号\"" +
                "    }," +
                "\"merchant_order_no\":\"20161008001\"," +
                "\"logistics_detail\":{" +
                "\"logistics_type\":\"EXPRESS\"" +
                "    }," +
                "\"ext_user_info\":{" +
                "\"name\":\"李明\"," +
                "\"mobile\":\"16587658765\"," +
                "\"cert_type\":\"IDENTITY_CARD\"," +
                "\"cert_no\":\"362334768769238881\"," +
                "\"min_age\":\"18\"," +
                "\"fix_buyer\":\"F\"," +
                "\"need_check_info\":\"F\"" +
                "    }," +
                "\"business_params\":{" +
                "\"campus_card\":\"0000306634\"," +
                "\"card_type\":\"T0HK0000\"," +
                "\"actual_order_time\":\"2019-05-14 09:18:55\"" +
                "    }," +
                "\"receiver_address_info\":{" +
                "\"name\":\"张三\"," +
                "\"address\":\"上海市浦东新区陆家嘴银城中路501号\"," +
                "\"mobile\":\"13120180615\"," +
                "\"zip\":\"200120\"," +
                "\"division_code\":\"310115\"" +
                "    }" +
                "  }");
        AlipayTradeCreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
