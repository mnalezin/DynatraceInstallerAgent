package com.dynatrace.installer.agent;

import com.amazonaws.cloudformation.proxy.AmazonWebServicesClientProxy;
import com.amazonaws.cloudformation.proxy.Logger;
import com.amazonaws.cloudformation.proxy.ProgressEvent;
import com.amazonaws.cloudformation.proxy.OperationStatus;
import com.amazonaws.cloudformation.proxy.ResourceHandlerRequest;

import java.util.Base64;

public class CreateHandler extends BaseHandler<CallbackContext> {

    @Override
    public ProgressEvent<ResourceModel, CallbackContext> handleRequest(
        final AmazonWebServicesClientProxy proxy,
        final ResourceHandlerRequest<ResourceModel> request,
        final CallbackContext callbackContext,
        final Logger logger) {

        final ResourceModel model = request.getDesiredResourceState();

        StringBuilder scriptBuilder = new StringBuilder();
        scriptBuilder.append("#!/bin/bash\n");
        scriptBuilder.append("echo 'failure' > user-data-status.txt\n");
        scriptBuilder.append(String.format("wget -O Dynatrace-OneAgent-Linux.sh \"https://%s/e/%s/api/v1/deployment/installer/agent/unix/default/latest?Api-Token=%s&arch=x86&flavor=default\" --no-check-certificate\n",
                model.getHostname(), model.getTenantId(), model.getApiToken()));
        scriptBuilder.append("/bin/sh Dynatrace-OneAgent-Linux.sh APP_LOG_CONTENT_ACCESS=1 INFRA_ONLY=0\n");
        scriptBuilder.append("echo 'success' > user-data-status.txt\n");

        String scriptString = Base64.getEncoder().encodeToString(scriptBuilder.toString().getBytes());
        model.setScriptString(scriptString);

        return ProgressEvent.<ResourceModel, CallbackContext>builder()
            .resourceModel(model)
            .status(OperationStatus.SUCCESS)
            .build();
    }
}
