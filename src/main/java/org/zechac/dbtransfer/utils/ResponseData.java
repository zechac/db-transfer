package org.zechac.dbtransfer.utils;

import java.util.HashMap;

public class ResponseData extends HashMap {

    public static ResponseData Success(){
        ResponseData responseData=new ResponseData();
        responseData.put("success",true);
        return responseData;
    }

    public static ResponseData Failed(){
        ResponseData responseData=new ResponseData();
        responseData.put("success",false);
        return responseData;
    }

    public ResponseData putData(Object data){
        this.put("data",data);
        return this;
    }


}
