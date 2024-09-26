import webapp2

class MainHandler(webapp2.RequestHandler):
    def get(self):
        if self.request.headers.get('X-Appengine-Inbound-Appid') != 'your-app-id':
            self.abort(403)
        else:
            self.response.write('Valid request')

app = webapp2.WSGIApplication([
    ('/', MainHandler)
], debug=True)

def main():
    from paste import httpserver
    httpserver.serve(app, host='localhost', port='8080')

if __name__ == '__main__':
    main()