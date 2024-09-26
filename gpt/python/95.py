
from django.shortcuts import get_object_or_404
from django.contrib.auth.mixins import LoginRequiredMixin
from django.core.exceptions import PermissionDenied

class ProfileUpdateView(LoginRequiredMixin, UpdateView):
    model = Profile
    form_class = UserProfileForm
    template_name = 'profile_edit.html'

    def get_object(self, queryset=None):
        """Override get_object to return the current user's profile."""
        # If no specific queryset provided, use the default queryset for the model
        if queryset is None:
            queryset = self.get_queryset()

        # Retrieve the current user's profile based on the user relation
        # This assumes Profile model has a user field that relates to the User model
        profile = get_object_or_404(queryset, user=self.request.user)

        return profile

    # Optionally, you might want to override the get_success_url method
    #
