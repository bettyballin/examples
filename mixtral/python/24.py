from blinker import signal

class FakeSignal(signal.Signal):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

    def connect_via(self, app):
        return self

# Monkey patch Blinker's Signal class with the custom FakeSignal
signal.Signal = FakeSignal

if __name__ == "__main__":
    pass