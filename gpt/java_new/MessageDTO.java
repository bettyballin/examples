import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class MessageDTO {
    private Long messageId;
    private String title;
    private String text; // Include other fields as necessary

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Include other getters and setters as necessary
}

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Other autowired services, like one that checks privileges
    
    public MessageDTO getMessageDTO(Long messageId) {
        return messageRepository.findById(messageId)
                .map(message -> {
                    MessageDTO dto = new MessageDTO();
                    dto.setMessageId(message.getId());
                    dto.setTitle(message.getTitle());
                    dto.setText(message.getText());
                    return dto;
                }).orElse(null);
    }
}

// Assuming MessageRepository is an interface extending JpaRepository or another Spring Data repository interface
interface MessageRepository {
    // Method signatures e.g.,
    java.util.Optional<Message> findById(Long id);
}