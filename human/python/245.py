from django.db import transaction
from django.shortcuts import get_object_or_404, HttpResponseRedirect, reverse
from .models import Case
from .forms import CaseEditForm

def edit_case(request, case_id, data):
    with transaction.atomic():
        case = get_object_or_404(Case.objects.select_for_update(), pk=case_id)
        form = CaseEditForm(data, instance=case)
        if form.is_valid():
            res = form.save()
            return HttpResponseRedirect(reverse("case_list"))