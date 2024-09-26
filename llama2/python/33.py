from django import forms
from .models import MyModel

class MyForm(forms.ModelForm):
    class Meta:
        model = MyModel
        fields = ('comment',)

    def clean(self):
        cleaned_data = super().clean()
        cleaned_data['comment'] = self.instance.clean_comment()
        return cleaned_data