from django.urls import re_path
from django.views.generic import TemplateView
from urllib.parse import unquote
from django.http import HttpResponse

def soft_reject(request):
    path = request.get_full_path()

    # Decode the URL
    decoded_url = unquote(path)

    if ".jsp" in decoded_url:
        return TemplateView.as_view(template_name="404.txt")(request)

urlpatterns = [
    re_path("^.*$", soft_reject, name='soft-reject'),
]