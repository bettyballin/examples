import os
import time
import hashlib

class Random:
    def __init__(self):
        self.gauss_next = None

    def seed(self, a=None):
        """Initialize internal state from hashable object.

        None or no argument seeds from current time or from an operating
        system specific randomness source if available.

        If a is not None or an int or long, hash(a) is used instead.
        """

        if a is None:
            try:
                a = int(hashlib.sha256(os.urandom(16)).hexdigest(), 16)
            except NotImplementedError:
                a = int(time.time() * 256) # use fractional seconds

        if not isinstance(a, (int)):
            a = int(hashlib.sha256(str(a).encode()).hexdigest(), 16)

        self.__class__.__bases__[0].seed(self, a)
        self.gauss_next = None

# usage
random = Random()
random.seed()