import bleach
html = """
<h1> Page Title </h1>
<script> alert("Boom!")</script>
"""
allowed_tags = [
    'a', 'abbr', 'acronym', 'b', 'blockquote', 'br',
    'code', 'dd', 'del', 'div', 'dl', 'dt', 'em',
    'em', 'h1', 'h2', 'h3', 'hr', 'i', 'img', 'li',
    'ol', 'p', 'pre', 's', 'strong', 'sub', 'sup',
    'table', 'tbody', 'td', 'th', 'thead', 'tr', 'ul'
]
# Attributes deemed safe
allowed_attrs = {
    '*': ['class'],
    'a': ['href', 'rel'],
    'img': ['src', 'alt']
}
# Sanitize the html using bleach 
# Convert text links to actual links
html_sanitized = bleach.clean(
    html,
    tags=allowed_tags,
    attributes=allowed_attrs
)
print(html_sanitized)