from django.shortcuts import render
from .forms import FormsLista

def index(request):   
    if request.method == 'POST':
        form = FormsLista(request.POST)
        if form.is_valid():
            form.save()
    else:
        form = FormsLista()
    return render(request, 'index.html', {'form': form})