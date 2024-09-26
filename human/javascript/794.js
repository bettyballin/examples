That is not JavaScript code, it appears to be a snippet of Python code, possibly from a Django project. 

Here's a very basic example of how you might use it in a Django project:

python
from django.urls import path
from . import views

urlpatterns = [
    path('maps_api/', views.gmapAPI, name='maps_api'),
]