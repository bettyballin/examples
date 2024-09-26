
from django.urls import re_path
from django.http import HttpResponse

def return_404(request):
    return HttpResponse("Not Found", status=404)

urlpatterns = [
    re_path(
        r"^.*(\.jsp|(%3B)).*$",
        return_404,
    ),
]

