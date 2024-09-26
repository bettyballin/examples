import webapp2
from webapp2_extras import routes
from webtest import TestApp
from google.appengine.ext import testbed

class DDTHandler(webapp2.RequestHandler):
    def view_request(self):
        self.response.out.write('DDTHandler')

class RootPage(DDTHandler):

    def get(self):      
        self.view_request()

app = webapp2.WSGIApplication([
    webapp2.Route(r'/', RootPage),
], debug=True)

def main():
    from paste import httpserver
    httpserver.serve(app, host='127.0.0.1', port='8080')

if __name__ == '__main__':
    main()