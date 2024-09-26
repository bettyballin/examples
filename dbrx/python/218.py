def _apply_decorators(view_func):
    def decorator(*args, **kwargs):
        view = view_func.view_class()
        for dec in reversed(getattr(view_func, 'decorators', [])):
            if hasattr(dec, '__get__'):
                # Handle bound methods (e.g class-based views)
                decorated_view = dec.__get__(view, type(view))
        return view(*args, **kwargs)
    return decorator