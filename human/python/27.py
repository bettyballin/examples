from bs4 import BeautifulSoup
from mechanize import Browser
from pprint import pprint

# Initialize the browser
browser = Browser()

# Assume the URL is already opened
# url = "your_url"
# browser.open(url)

# Parse the HTML content
# soup = BeautifulSoup(browser.response().read(), 'html.parser')

# Get the form
# form = browser.form

# Get the items from the second last control in the form
pprint(browser.form.controls[-2].items)

# Extract the values from the items
choices = [item.attrs['value'] for item in browser.form.controls[-2].items]
print(choices)

# Select the second option
browser.form['name_tatser'] = ['2']

# Submit the form
browser.submit()