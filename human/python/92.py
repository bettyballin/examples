from django.contrib.auth.decorators import login_required
from django.utils.decorators import method_decorator
from django.views.generic import UpdateView
from .models import Profile
from .forms import UserProfileForm

class ProfileUpdateView(UpdateView):
    model = Profile
    form_class = UserProfileForm

    def get_object(self):
        """
        Returns the request's user.
        """
        return self.request.user.get_profile()

    @method_decorator(login_required, name='dispatch')
    def dispatch(self, *args, **kwargs):
        return super().dispatch(*args, **kwargs)