from flask import current_user, Response

def is_admin(fn):
    def decorate(*args, **kwargs):
        if not current_user.is_authenticated or not current_user.is_admin:        
            return Response(status=500)
        return fn(*args,**kwargs)
    return decorate