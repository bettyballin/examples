from mechanize import Browser

browser = Browser()
browser.open("your_url_here")  # replace with the URL you want to open

browser.select_form(nr=1)

choices=[item.attrs['value'] for item in browser.form.controls[-2].items]
print(choices)
# ['1576', '1581', '1594', '1595', '1596', '1598', '1597', '1593']

browser.form['name_ser']=['1576']
browser.submit()

browser.select_form(nr=2)

choices=[item.attrs['value'] for item in browser.form.controls[-2].items]
print(choices)
# ['32', '33', '34', '35', '36', '37', '38', '39', '40', '41']

browser.form['data_kind']=['33']
browser.submit()

browser.select_form(nr=3)
browser.form['ybegin']=['2010']
browser.form['mbegin']=['1']
browser.form['yend']=['2011']
browser.form['mend']=['5']
browser.submit()