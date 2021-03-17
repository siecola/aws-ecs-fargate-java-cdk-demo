package br.com.siecola;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.sqs.Queue;

public class SqsStack extends Stack {
    private final Queue productEventsQueue;

    public SqsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public SqsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        this.productEventsQueue = Queue.Builder.create(this, "ProductEvents")
                .queueName("product-events")
                .build();
    }

    public Queue getProductEventsQueue() {
        return productEventsQueue;
    }
}
