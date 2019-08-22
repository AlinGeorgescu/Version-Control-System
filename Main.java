import utils.Context;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        String input = args[0];
        String output = args[1];
        Context context = Context.getInstance();

        context.init(input, output);
        context.run();
    }
}
