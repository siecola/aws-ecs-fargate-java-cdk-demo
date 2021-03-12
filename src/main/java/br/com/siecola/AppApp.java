package br.com.siecola;

import software.amazon.awscdk.core.App;

public class AppApp {
    public static void main(final String[] args) {
        App app = new App();

        new AppStack(app, "AppStack");

        app.synth();
    }
}
