from django.contrib.auth.mixins import LoginRequiredMixin, UserPassesTestMixin
from django.views.generic import UpdateView
from .models import Profile
from .forms import UserProfileForm

class ProfileUpdateView(LoginRequiredMixin, UserPassesTestMixin, UpdateView):
    model = Profile
    form_class = UserProfileForm

    def test_func(self):
        return self.request.user == self.get_object().user