
from werkzeug.wrappers import Request, Response
import socket

class SilentMiddleware(object):
    def __init__(self, app, silent_paths=None):
        self.app = app
        self.silent_paths = silent_paths if silent_paths else []

    def __call__(self, environ, start_response):
        request = Request(environ)
        # Check if the request
