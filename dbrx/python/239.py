import bleach

def sanitize_html(html):
    tags = ['strong', 'em', 'p']
    attrs = {
        '*': ['class'],
        'a': ['href', 'title']
    }
    return bleach.clean(html, tags=tags, attributes=attrs)

# Test the function
html = "<p>Hello, <strong>world!</strong> <a href='#' title='Link'>Click me!</a></p>"
print(sanitize_html(html))