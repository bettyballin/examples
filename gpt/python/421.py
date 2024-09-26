
def detail(request, question_id):
    return HttpResponseRedirect(reverse('hello:results', args=(question.id,)))

