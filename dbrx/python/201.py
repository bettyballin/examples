from django import forms 
from .models import MyModel 
from django.shortcuts import render, redirect
from django.http import HttpResponse

class ApiForm(forms.ModelForm):  
    class Meta:    
        model = MyModel   
        fields = ('key', 'secret')

def homepage(request):
    if request.method == 'POST':
         # create a form instance and populate it with data from the request:
        form = ApiForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('homepage')
    else:
        form = ApiForm()

    return render(request, 'home.html', {'form': form})