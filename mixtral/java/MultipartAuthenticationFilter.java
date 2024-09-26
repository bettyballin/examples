import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.filter.OncePerRequestFilter;

public class MultipartAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        if (request.getContentType() != null && request.getContentType().contains("multipart/form-data")) {
            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : items) {
                    if (!item.isFormField() || !"token".equals(item.getFieldName()))
                        continue;

                    String token = item.getString();

                    // Validate the token and set authenticated user details in SecurityContextHolder or thread-local variable
                }
            } catch (Exception e) {
                throw new ServletException("Failed to parse multipart request", e);
            }
        }

        chain.doFilter(request, response);
    }
}