signals_available = False
try:
    from blinker import Namespace
    signals_available = True
except ImportError:
    class _FakeSignal(object):
        def __init__(self, name, doc=None):
            self.name = name
            self.doc = doc

        def connect(self, *args, **kwargs):
            pass

        def send(self, *args, **kwargs):
            pass

    class Namespace(object):
        def signal(self, name, doc=None):
            return _FakeSignal(name, doc)