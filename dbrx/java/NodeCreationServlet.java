import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.Node;

public class NodeCreationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Validate user input
        if (isValidName(name) && isValidEmail(email)) {
            try {
                createNodeInNeo4j(name, email);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        } else {
            throw new ServletException("Invalid data provided.");
        }
    }

    private boolean isValidName(String name) {
        return name != null && !name.isEmpty() && name.matches("[a-zA-Z\\s]+");
    }

    private boolean isValidEmail(String email) {
        // Implement your own validation logic
        return email != null && email.contains("@");
    }

    private void createNodeInNeo4j(String name, String email) {
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase("path/to/neo4j/db");

        try (Transaction tx = graphDb.beginTx()) {
            Node node = graphDb.createNode();
            node.setProperty("name", name);
            node.setProperty("email", email);

            // Add relationships, labels, or other properties as needed

            tx.success();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            graphDb.shutdown();
        }
    }
}