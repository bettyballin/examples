from django.http import HttpResponseRedirect

class BrowserMiddleware(object):
    def __init__(self, get_response):
        self.get_response = get_response

    def __call__(self, request):
        allowed_browsers = ['Chrome', 'Firefox']  # Add your list of verified browsers

        user_agent = request.META.get('HTTP_USER_AGENT', '').split(' ')

        for browser in allowed_browsers:
            if any(browser == agent or f'{browser}/' in agent for agent in user_agent):
                return self.get_response(request)

        # If the above loop didn't find a match redirect to disallow page

        path = request.build_absolute_uri('/disallow/')

        response = HttpResponseRedirect(path)

        return response