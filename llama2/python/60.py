import logging
from selenium import webdriver

# Initialize the driver with the desired log level
driver = webdriver.Firefox(log_level=logging.WARNING)

# Or set the log level after initialization
# driver.set_log_level(logging.WARNING)