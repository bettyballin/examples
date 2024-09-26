from django import forms
from django.db import transaction
from .models import Case

class CaseEditForm(forms.ModelForm):
    class Meta:
        model = Case
        fields = ('name', 'description')

    def save(self, *args, **kwargs):
        with transaction.atomic():
            # Acquire row-level lock
            case = self.instance
            Case.objects.select_for_update().filter(pk=case.pk).values('id').first()

            # Call the original save method
            res = super().save(*args, **kwargs)

        # The lock is released when the transaction ends.
        return res