import java.util.Objects;
import java.util.Optional;

public class Temp1310 {
    public static void main(String[] args) {
        // Example usage
        CurrentUser currentUser = new CurrentUser(1L);
        BlogForm blogForm = new BlogForm();
        blogForm.setBlogId(1L);
        blogForm.setId(1L);

        Temp1310 temp = new Temp1310();
        try {
            Blog blog = temp.saveOrUpdate(currentUser, 1L, blogForm);
            System.out.println("Blog saved/updated: " + blog);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Blog saveOrUpdate(CurrentUser currentUser, Long userId, BlogForm blogForm) {
        if (blogForm.getBlogId() == null || !Objects.equals(userId, findById(blogForm.getBlogId()).orElseThrow().getUserId())) {
            throw new AccessDeniedException("Unauthorized access to this post");
        }

        Blog blog = new Blog(blogForm.getBlogId(), userId);

        if (blogForm.getId() != null) {
            Optional<Blog> existingPostOptional = findById(blogForm.getBlogId());

            if (!existingPostOptional.isPresent()) {
                throw new EntityNotFoundException("No post found with id: " + blogForm.getBlogId());
            }
        }

        return blog;
    }

    private Optional<Blog> findById(Long blogId) {
        // Stub method for example purposes
        if (blogId.equals(1L)) {
            return Optional.of(new Blog(blogId, 1L));
        } else {
            return Optional.empty();
        }
    }

    class CurrentUser {
        private Long userId;

        public CurrentUser(Long userId) {
            this.userId = userId;
        }

        public Long getUserId() {
            return userId;
        }
    }

    class BlogForm {
        private Long blogId;
        private Long id;

        public Long getBlogId() {
            return blogId;
        }

        public void setBlogId(Long blogId) {
            this.blogId = blogId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    class Blog {
        private Long blogId;
        private Long userId;

        public Blog(Long blogId, Long userId) {
            this.blogId = blogId;
            this.userId = userId;
        }

        public Long getBlogId() {
            return blogId;
        }

        public Long getUserId() {
            return userId;
        }

        @Override
        public String toString() {
            return "Blog{" + "blogId=" + blogId + ", userId=" + userId + '}';
        }
    }

    class AccessDeniedException extends RuntimeException {
        public AccessDeniedException(String message) {
            super(message);
        }
    }

    class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }
}