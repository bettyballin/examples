from django.urls import re_path
from django.views.generic import TemplateView

urlpatterns = [
    # ...

    re_path(
        r".*\.jsp.*",
        TemplateView.as_view(template_name="404.txt"),
        name='soft-reject'
    ),

    # ...
]