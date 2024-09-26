
from twisted.web.server import Site
from twisted.web.resource import Resource
from twisted.python import log
from twisted.web.util import redirectTo

class ErrorHandlingResource(Resource):
    isLeaf = True
    
    def render_GET(self, request):
        request.setResponseCode(500)
        return b'<html><body>Internal Server Error</body></html>'

class RootResource(Resource):
    # Your other resources and methods here.

    def getChild(self, name, request):
        try:
            return Resource.getChild(self, name, request)
        except Exception as e:
            log.err(e)  # Make sure to
