package edu.hw2;

public final class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        try {
            throw new ToGetStackTrace();
        } catch (ToGetStackTrace e) {
            var stackTraceArray = e.getStackTrace();
            var needStackTrace = stackTraceArray[1];
            return new CallingInfo(needStackTrace.getClassName().split("\\$")[1], needStackTrace.getMethodName());
        }
    }

    public record CallingInfo(String className, String methodName) {
    }

    private static final class ToGetStackTrace extends Exception {
    }
}
