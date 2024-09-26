import logging

class Request:
    def __init__(self):
        self.headers = {
            'items': lambda: [('Content-Type', 'text/html'), ('Host', 'www.example.com')],
            'environ': {'REQUEST_METHOD': 'GET', 'PATH_INFO': '/index.html'}
        }

class Logger:
    def __init__(self):
        self.request = Request()

    def log(self):
        logging.basicConfig(level=logging.INFO)
        logging.info('request headers: %s', self.request.headers['items']())
        logging.info('request env: %s', self.request.headers['environ'])

Logger().log()