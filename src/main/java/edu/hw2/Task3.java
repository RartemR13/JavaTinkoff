package edu.hw2;

public final class Task3 {
    private Task3() {
    }

    private static final double NO_THROW_PROBABILITY = 0.3;
    private static final double STABLE_PROBABILITY = 0.7;

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public final static class StableConnection implements Connection {
        @Override
        public void execute(String command) {
        }

        @Override
        public void close() {
        }
    }

    public final static class FaultyConnection implements Connection {

        @Override
        public void execute(String command) {
            if (Math.random() > NO_THROW_PROBABILITY) {
                throw new ConnectionException();
            }
        }

        @Override
        public void close() {
        }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public final static class DefaultConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            if (Math.random() <= STABLE_PROBABILITY) {
                return new StableConnection();
            }

            return new FaultyConnection();
        }
    }

    public final static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static final class ConnectionException extends RuntimeException {
        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }

        public ConnectionException() {
        }
    }

    public final static class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) {
            for (int i = 0; i < maxAttempts - 1; ++i) {
                try (Connection connection = manager.getConnection()) {
                    connection.execute(command);
                    return;
                } catch (Exception e) {

                }
            }

            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
            } catch (Exception e) {
                throw new ConnectionException("Can`t execute " + command, e);
            }
        }
    }

}
