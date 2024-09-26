import requests

response = requests.get('https://www.facebook.com')
headers = response.headers

print(headers)

# To print only the CSP header
csp_header = headers.get("Content-Security-Policy")
if csp_header:
    print(f"CSP Header: {csp_header}")
else:
    print("No Content Security Policy (CSP) found.")