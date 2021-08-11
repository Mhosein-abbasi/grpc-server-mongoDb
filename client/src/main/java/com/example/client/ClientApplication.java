package com.example.client;

import org.UserRequestsProtoGrpc;
import org.UserServiceGrpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        final UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

        UserRequestsProtoGrpc.UserResponse response = stub.create(UserRequestsProtoGrpc.UserRequest.newBuilder()
                .setName("jon")
                .setFamily("esi")
                .build());

        System.out.println(response);
    }

}
