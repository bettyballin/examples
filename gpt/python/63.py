
import webapp2

class MainPage(webapp2.RequestHandler):
    def get(self):
        # Access headers from the request object
        user_agent = self.request.headers.get('User-Agent', None)
        custom_header = self.request.headers.get('X-Custom-Header', None)

        # Perform your validation
        if not user_agent or not custom_header:
            # If either header is missing or malformed, you could return an error
            self.response.status = 400
            self.response.write('Invalid request')
        else:
            # Continue with processing if headers are valid
            self.response.write('Hello, World!')

app = webapp2.WSGIApplication([
    ('/', MainPage),
], debug=True)

