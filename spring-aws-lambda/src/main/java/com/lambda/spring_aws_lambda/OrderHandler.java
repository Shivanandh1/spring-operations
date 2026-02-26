package com.lambda.spring_aws_lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class OrderHandler implements RequestHandler<String, Object> {
  
    @Override
    public Object handleRequest(String string, Context context) {
        return null;
    }
}
