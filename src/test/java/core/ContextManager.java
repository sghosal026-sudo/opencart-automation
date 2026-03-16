package core;

public class ContextManager {

    private static final ThreadLocal<TestContext> context = new ThreadLocal<>();

    public static TestContext getContext() {
        return context.get();
    }

    public static void setContext(TestContext testContext) {
        context.set(testContext);
    }

    public static void unload() {
        context.remove();
    }
}