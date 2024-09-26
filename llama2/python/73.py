from django.shortcuts import render
from .forms import CaseEditForm
from .models import Case
from django.db import transaction

def edit_case(request):
    if request.method == 'POST':
        form = CaseEditForm(request.POST, instance=Case.objects.get(pk=request.POST['id']))

        # Acquire row-level lock
        case = form.instance
        with transaction.atomic():
            Case.objects.select_for_update().get(pk=case.pk)
            if form.is_valid():
                form.save()
                return render(request, 'case_detail.html', {'case': case})
    else:
        form = CaseEditForm()
    return render(request, 'case_edit.html', {'form': form})