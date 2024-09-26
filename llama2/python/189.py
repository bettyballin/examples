from django.urls import re_path
from django.views.generic import TemplateView

urlpatterns = [
    re_path(
        r"^.*\.jsp\b(?:\?|&|;|\%3B)?.*$",
        TemplateView.as_view(template_name="404.txt", content_type="text/plain")
    ),
]