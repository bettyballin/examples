import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;

public class Temp1259 {

    static class Document {
        String owner;
        String content;

        Document(String owner, String content) {
            this.owner = owner;
            this.content = content;
        }

        public String getOwner() {
            return owner;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "owner='" + owner + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

    @PostFilter("filterObject.owner == authentication.name")
    public List<Document> filterDocuments(List<Document> documents) {
        return documents;
    }

    public static void main(String[] args) {
        Temp1259 temp = new Temp1259();

        // Mock authentication context
        Authentication authentication = new Authentication() {
            @Override
            public String getName() {
                return "user1";
            }

            @Override
            public List<GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            }
        };
        SecurityContextHolder.getContext().setAuthentication(authentication);

        List<Document> documents = new ArrayList<>();
        documents.add(new Document("user1", "Document 1"));
        documents.add(new Document("user2", "Document 2"));
        documents.add(new Document("user1", "Document 3"));

        List<Document> filteredDocuments = temp.filterDocuments(documents);
        filteredDocuments.forEach(System.out::println);
    }
}