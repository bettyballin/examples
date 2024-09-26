class _FakeSignal(object):
    """If blinker is unavailable, create a fake class with the same
    interface that allows sending of signals but will fail with an
    error on anything else.  Instead of doing anything on send, it
    will just ignore the arguments and do nothing instead.
    """

    def __init__(self, name, doc=None):
        self.name = name
        self.__doc__ = doc

    def _fail(self, *args, **kwargs):
        raise RuntimeError('signalling support is unavailable '
                           'because the blinker library is '
                           'not installed.')

    def send(self, *args, **kwargs):
        pass

    def connect(self, *args, **kwargs):
        self._fail(*args, **kwargs)

    def disconnect(self, *args, **kwargs):
        self._fail(*args, **kwargs)

    def has_receivers_for(self, *args, **kwargs):
        self._fail(*args, **kwargs)

    def receivers_for(self, *args, **kwargs):
        self._fail(*args, **kwargs)

    def temporarily_connected_to(self, *args, **kwargs):
        self._fail(*args, **kwargs)

    def connected_to(self, *args, **kwargs):
        self._fail(*args, **kwargs)