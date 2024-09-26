import requests

blocked_domains = ["facebook.com", "twitter.com"]

def is_domain_blocked(domain):
    return domain.lower() in (d.lower() for d in blocked_domains)

url = input("Enter a URL: ")
if not is_domain_blocked(url.split("/")[2]):
    try:
        response = requests.get(url)
        print(response.text)
    except requests.exceptions.RequestException as e:
        print(f"An error occurred: {e}")
else:
    print(f"The domain {url} has been restricted.")