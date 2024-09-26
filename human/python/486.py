from django.http import redirect
from django.utils.deprecation import MiddlewareMixin

def restrict_middleware(get_response):
    def middleware(request):
        if 'HTTP_USER_AGENT' in request.META and request.META['HTTP_USER_AGENT'] == '...':
            return redirect('/disallow/')
        else:
            return get_response(request)
    return middleware

# or using MiddlewareMixin
class RestrictMiddleware(MiddlewareMixin):
    def process_request(self, request):
        if 'HTTP_USER_AGENT' in request.META and request.META['HTTP_USER_AGENT'] == '...':
            return redirect('/disallow/')