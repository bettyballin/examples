import time

RATE_LIMIT_INTERVAL = 60  # define the rate limit interval in seconds

class RequestHandler:
    def __init__(self):
        self._last_request_time = 0

    def post(self):
        current_time = int(time.time())
        time_diff = current_time - self._last_request_time

        if time_diff < RATE_LIMIT_INTERVAL:
            return "Too many requests. Please try again later."

        self._last_request_time = current_time
        # rest of your post method code here

# create an instance of the RequestHandler class
handler = RequestHandler()

# call the post method
print(handler.post())