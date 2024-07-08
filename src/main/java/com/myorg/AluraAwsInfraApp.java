package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        AluraVPCStack vpcStack = new AluraVPCStack(app, "VPC");
        AluraClusterStack clusterStack = new AluraClusterStack(app, "Cluster", vpcStack.getVpc());
        AluraServiceStack serviceStack = new AluraServiceStack(app, "Service", vpcStack.getVpc(), clusterStack.getCluster());

        clusterStack.addDependency(vpcStack);
        serviceStack.addDependency(clusterStack);

        app.synth();
    }
}

