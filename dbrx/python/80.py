import logging

# Create logger
logger = logging.getLogger('selenium.webdriver.remote.remote_connection')
logger.setLevel(logging.WARNING)

# Optionally create formatter and add it to the handler
formatter = logging.Formatter('%(asctime)s - %(levelname)s - %(message)s')
handler = logging.StreamHandler()
handler.setFormatter(formatter)
logger.addHandler(handler)

# Now use your logger instead of print statements or other loggers in Selenium code.
if __name__ == "__main__":
    logger.warning("This is a warning message.")
    logger.info("This is an info message.")
    logger.error("This is an error message.")