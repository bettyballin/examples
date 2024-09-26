
from django.conf import settings
from django.contrib.auth import SESSION_KEY
from django.contrib.contenttypes.models import ContentType
from django.utils.deprecation import MiddlewareMixin

class AdminSessionTimeoutMiddleware(MiddlewareMixin):
    def process_request(self, request):
        if request.path.startswith('/admin/') and request.user.is_authenticated:
            # Set the timeout to your desired value (e.g., 30 minutes)
            request.session.set_expiry(1800)

