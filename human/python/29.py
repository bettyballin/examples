import urllib
from lxml import html as lh
from mechanize import Browser

browser = Browser()
url = 'http://www.cbs.gov.il/ts/databank/data_ts_format_e.xml'
browser.open(url)

content = browser.response().read()
doc = lh.fromstring(content)
params = dict((elt.attrib['name'],elt.attrib['value']) for elt in doc.xpath('//input'))
params['king_format'] = 2

params = urllib.urlencode(dict((p,params[p]) for p in [
    'king_format',
    'tod',
    'time_unit_list',
    'mend',
    'yend',
    'co_code_list',
    'name_tatser_list',
    'ybegin',
    'mbegin',
    'code_list',
    'co_name_tatser_list',
    'level_1',
    'level_2',
    'level_3']))

browser.open(url+'?'+params)
content = browser.response().read()