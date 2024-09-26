import bleach

def strip_html(html):
    return bleach.clean(html, strip=True)

if __name__ == "__main__":
    html = "<p>Hello, <b>world!</b></p>"
    print("Before:", html)
    print("After:", strip_html(html))