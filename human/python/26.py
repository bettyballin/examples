import mechanize
import pprint
import lxml.etree as ET
import lxml.html as lh
import urllib
import urllib2

if __name__ == "__main__":
    browser=mechanize.Browser()
    browser.open("http://www.cbs.gov.il/ts/ID40d250e0710c2f/databank/series_func_e_v1.html?level_1=31&level_2=1&level_3=7")
    browser.select_form(nr=0)