package com.example.server;

import org.UserRequestsProtoGrpc;
import org.UserServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import io.grpc.stub.StreamObserver;

@GRpcService
public class Controller extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    Service service;

    @Override
    public void create(UserRequestsProtoGrpc.UserRequest request, StreamObserver<UserRequestsProtoGrpc.UserResponse> responseObserver) {
        String userName = request.getName();
        String userFamily = request.getFamily();

        User user = service.create(userName, userFamily);

        UserRequestsProtoGrpc.UserResponse response = UserRequestsProtoGrpc.UserResponse.newBuilder()
                .setName(user.getName())
                .setFamily(user.getFamily())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
