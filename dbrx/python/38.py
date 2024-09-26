from twisted.web.server import Site
from twisted.web.resource import Resource
from twisted.internet import reactor

class HelloWorld(Resource):
    isLeaf = True

    def render(self, request):
        return b"Hello, world!"

resource = HelloWorld()
factory = Site(resource)
factory.setDebugging(False)  # Disable debugging/tracebacks in responses.
reactor.listenTCP(8080, factory)
reactor.run()