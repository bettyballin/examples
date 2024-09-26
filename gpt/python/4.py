
import requests
from requests_kerberos import HTTPKerberosAuth

# Initialize the Kerberos Auth
kerberos_auth = HTTPKerberosAuth()

# Make a request to the protected webpage
response = requests.get('http://your-protected-webpage.com', auth=kerberos_auth)

# Check if the request was successful
if response.ok:
    print('Successfully authenticated with Kerberos')
