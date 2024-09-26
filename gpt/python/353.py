
import bleach

# List of allowed tags, attributes, and styles
allowed_tags = ['p', 'b', 'i', 'u', 'em', 'strong', 'a']
allowed_attributes = {'a': ['href', 'title']}
allowed_styles = []

# User input
dirty_html = '<script>alert("xss");</script><p>This is a <a href="http://example.com" title="Link">link</a>.</p>'

# Sanitize user input
clean_html = bleach.clean(dirty_html, tags=allowed_tags, attributes=allowed_attributes, styles=allowed_styles)

# Now clean_html can be safely rendered in an HTML template

