from twisted.web import server, reactor

class MyResource(server.Resource):
    def render_GET(self, request):
        return b"Hello, world!"

def myErrorHandler(request, failure):
    return server.NOT_DONE_YET

myResource = MyResource()
site = server.Site(myResource)
site.errorHandler = myErrorHandler

# Disable sending traceback to remote hosts
site.errorPageClass.sendStack = False

reactor.listenTCP(8080, site)
reactor.run()