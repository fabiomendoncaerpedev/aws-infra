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
        AluraRDSStack RDSStack = new AluraRDSStack(app, "RDS", vpcStack.getVpc());

        clusterStack.addDependency(vpcStack);
        serviceStack.addDependency(clusterStack);
        RDSStack.addDependency(vpcStack);

        app.synth();
    }
}

