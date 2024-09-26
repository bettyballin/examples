import requests
from bs4 import BeautifulSoup

headers = {
    'User-Agent': 'MyBot/1.0 (http://mywebsite.com/)'
}

r = requests.get("https://pythonhow.com/example.html", headers=headers)
c = r.content
print(c)