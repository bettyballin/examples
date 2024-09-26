from django.http import JsonResponse
from django.conf import settings

def logout(request):
    response = JsonResponse({'detail': 'Logged out'})
    # Clear session id and set httponly flag explicitly.
    request.session.flush()
    response.set_cookie(
        key=settings.SESSION_COOKIE_NAME,
        max_age=0,
        path='/',
        domain=None,
        secure=False,
        httponly=True
    )
    return response