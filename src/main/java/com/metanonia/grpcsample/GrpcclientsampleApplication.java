package com.metanonia.grpcsample;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.metanonia.grpcsample.lib.MyServiceGrpc;
import com.metanonia.grpcsample.lib.HelloReply;
import com.metanonia.grpcsample.lib.HelloRequest;

@SpringBootApplication
public class GrpcclientsampleApplication implements CommandLineRunner {
    @GrpcClient("sample1")
    private MyServiceGrpc.MyServiceBlockingStub sampleStub;

    public static void main(String[] args) {
        SpringApplication.run(GrpcclientsampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        HelloReply response = sampleStub.sayHello(
                HelloRequest.newBuilder()
                        .setName("UserName")
                        .build()
            );
        System.out.println("Response=" + response.getMessage());
    }
}
