package ex1;




public class ConnectionManager {
    /**
     * 4theme
     * exercise1
     * @author Vitalii Reshetnyk
     */
    private static final int MAX_CONNECTIONS = 5; // desired number of connections.
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];
    private static int currentConnectionIndex = 0;

    private ConnectionManager() {
        // Private constructor to prevent explicit creation of ConnectionManager objects.
    }

    public static Connection getConnection() {
        if (currentConnectionIndex < MAX_CONNECTIONS) {
            if (connections[currentConnectionIndex] == null) {
                connections[currentConnectionIndex] = new Connection(currentConnectionIndex);
            }
            return connections[currentConnectionIndex++];
        } else {
            System.out.println("No more available connections. Terminating.");
            System.exit(0);
            return null;
        }
    }

    public static void releaseConnection(Connection connection) {

    }

    public static class Connection {
        private int id;

        private Connection(int id) {
            this.id = id;
        }

        public void executeQuery(String query) {
            System.out.println("Executing query: " + query + " on connection " + id);
            // query execution logic here.
        }
    }

    public static void main(String[] args) {
        // Example
        Connection conn1 = ConnectionManager.getConnection();
        conn1.executeQuery("SELECT * FROM table1");

        Connection conn2 = ConnectionManager.getConnection();
        conn2.executeQuery("UPDATE table2 SET column1 = 'value'");

        ConnectionManager.releaseConnection(conn1);
        ConnectionManager.releaseConnection(conn2);
    }
}
