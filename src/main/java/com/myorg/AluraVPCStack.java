package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;

public class AluraVPCStack extends Stack {
    public AluraVPCStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AluraVPCStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        Vpc vpc = Vpc.Builder.create(this, "AluraVPC")
                .maxAzs(3)  // Default is all AZs in region
                .build();
    }
}
