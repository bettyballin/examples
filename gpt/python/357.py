
# myapp/middleware.py

from django.http import HttpResponseRedirect
from django.urls import reverse

class BrowserOsCheckMiddleware:
    def __init__(self, get_response):
        self.get_response = get_response

    def __call__(self, request):
        # Get the user-agent of the request
        user_agent = request.META.get('HTTP_USER_AGENT', '')

        # Check if the user-agent matches your criteria
        if not self.is_allowed_user_agent(user_agent):
            # Redirect to the disallow page if the user-agent is not allowed
            return HttpResponseRedirect(reverse('disallow'))

        # Continue processing if the user-agent is allowed
        response = self.get_response(request)
        return response

    def is_allowed_user_agent(self, user_agent):
        # Define your
