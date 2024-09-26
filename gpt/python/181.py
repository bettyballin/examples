
from django.shortcuts import get_object_or_404, render
from django.http import HttpResponseRedirect
from django.core.urlresolvers import reverse
from django.db import transaction
from django.template import RequestContext

from .forms import CaseEditForm
from .models import Case

@transaction.atomic  # This decorator starts a database transaction
def edit_case(request, case_id):
    # Lock the case row at the beginning of the transaction
    case = Case.objects.select_for_update().get(pk=case_id)

    if request.method == 'POST':
        form = CaseEditForm(request.POST, instance=case)
        if form.is_valid():
            form.save()
            # The transaction is committed on exit from the `with` block
