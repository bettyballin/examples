from django.conf.urls import url
from django.urls import path, include
from . import profileviews

urlpatterns = [
    url(r'^profile/edit/$', profileviews.ProfileUpdateView.as_view(), name='profile_edit'),
]