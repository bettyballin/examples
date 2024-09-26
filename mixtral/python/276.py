from django.shortcuts import render, redirect
from django.contrib import messages
from .forms import ApiForm
from cryptography.fernet import InvalidToken

def homepage(request):
    if request.method == 'POST':
        form = ApiForm(request.POST)

        # check whether it's valid
        if form.is_valid():
            send = form.save()

            try:
                decrypted_key = send.key
                decrypted_secret = send.secret

                # Perform tasks using the API keys

            except InvalidToken as e:
                messages.error(request, f"Error while trying to use encrypted data")

    else:
        form = ApiForm()

    return render(request, "main/home.html", context={"form": form})