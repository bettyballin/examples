import requests
from bs4 import BeautifulSoup

def main():
    headers = {
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:55.0) Gecko/20100101 Firefox/55.0',
    }

    try:
        r = requests.get("http://pythonhow.com/example.html", headers=headers)
        r.raise_for_status()  # Raise an exception for HTTP errors
        c = r.content
        print(c)
    except requests.exceptions.RequestException as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    main()