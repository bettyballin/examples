import ssl
from urllib import request

# Create SSL context
context = ssl.SSLContext(ssl.PROTOCOL_TLS)

# Load the trusted CA certificates
context.load_verify_locations("path/to/ca-certs")

# Set up proxy
proxy_handler = request.ProxyHandler({'https': 'example-proxy.com:port'})

# Create an opener with the SSL context and Proxy
opener = request.build_opener(
    request.HTTPSHandler(context=context),
    proxy_handler
)

# Install the openers
request.install_opener(opener)

# Now you can make a secure connection to example.com
response = request.urlopen("https://example.com")

print(response.read())