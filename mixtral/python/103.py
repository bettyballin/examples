from werkzeug.exceptions import HTTPException

class SilentMiddleware(object):
    def __init__(self, app):
        self.app = app

    def __call__(self, environ, start_response):

        if "/" in environ["PATH_INFO"]:
            return self.app(environ, start_response)

        try:
            return self.app(environ, start_response)

        except HTTPException as e:
            # Log the exception
            import logging
            logging.exception(e)

            response = e.get_response()

            return response(environ, start_response)