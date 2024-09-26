import requests

url = "http://localhost:8081/"
headers = {
    "Referer": "http://localhost:8081/_ah/login?continue=http%3A//localhost%3A8081/",
    "Accept-Charset": "ISO-8859-7,utf-8;q=0.7,*;q=0.3",
    "Cookie": "hl=en_US; dev_appserver_login=\"test@example.com:False:185804764220139124118\"",
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1312.52 Safari/537.17",
    "Host": "localhost:8081",
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Accept-Language": "en-US,en;q=0.8,el;q=0.6"
}

response = requests.get(url, headers=headers)
print(response.text)