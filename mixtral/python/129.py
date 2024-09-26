from django.db import transaction
from django.shortcuts import render_to_response
from django.template import RequestContext
from .forms import CaseEditForm
from .models import Case

def edit_case(request, case_id):
    with transaction.atomic():
        try:
            case = Case.objects.select_for_update().get(pk=case_id)

            if request.method == 'POST':
                data = request.POST.copy()
                form = CaseEditForm(data, instance=case)

                if form.is_valid():
                    res = form.save()

            else:
                form = CaseEditForm(instance=case)

        except Exception as e:
            print("Error:", str(e))

    variables = RequestContext(request, {"form": form})

    return render_to_response('sample/edit_case.html', variables)