from django.conf import settings
from django.http import HttpResponsePermanentRedirect

urlpatterns = [
    # ...
    (r'^static/(?P<path>.*)$', lambda request, path: HttpResponsePermanentRedirect(f'/static/{path}')),
]