class UserAgentMiddleware:
    def __init__(self, get_response):
        self.get_response = get_response

    def process_view(self, request, view_func, view_args, view_kwargs):
        # Check if user-agent matches allowed values and redirect or return 403 error otherwise.
        allowed_agents = ['Mozilla/5.0', 'Googlebot/2.1']
        user_agent = request.META.get('HTTP_USER_AGENT')
        if user_agent not in allowed_agents:
            from django.http import HttpResponseForbidden
            return HttpResponseForbidden("Forbidden")

MIDDLEWARE = [
    'path.to.UserAgentMiddleware',
]