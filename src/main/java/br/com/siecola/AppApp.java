package br.com.siecola;

import software.amazon.awscdk.core.App;

public class AppApp {
    public static void main(final String[] args) {
        App app = new App();

        VpcStack vpcStack = new VpcStack(app, "Vpc");

        ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        SqsStack sqsStack = new SqsStack(app, "Sqs");

        DdbStack ddbStack = new DdbStack(app, "Ddb");

        ServiceStack serviceStack = new ServiceStack(app, "Service", clusterStack.getCluster(),
                sqsStack.getProductEventsQueue(), ddbStack.getProductEventsDdb());
        serviceStack.addDependency(clusterStack);
        serviceStack.addDependency(sqsStack);
        serviceStack.addDependency(ddbStack);

        app.synth();
    }
}