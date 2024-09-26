import lxml.etree as ET

# Sample XML data
xml_data = '''
<series_ts>
    <Data_Set>
        <Series calc_kind="Weighted" name_ser="Number Of Companies That Answered" get_time="2011-06-21" name_topic="Business Tendency Survey - Distributions Of Businesses By Industry, Kind Of Questions And Answers  - Manufacturing - Company'S Experience Over The Past Three Months - Orders For Export" time_unit="Month" code_series="22978" data_kind="5-10 Employed Persons" decimals="0" unit_kind="Number">
            <obs time_period="2010-12" value="40"/>
            <obs time_period="2011-01" value="38"/>
            <obs time_period="2011-02" value="40"/>
            <obs time_period="2011-03" value="36"/>
            <obs time_period="2011-04" value="30"/>
            <obs time_period="2011-05" value="33"/>
        </Series>
    </Data_Set>
</series_ts>
'''

# Parse XML data
doc = ET.fromstring(xml_data)

# Execute the provided code
for series in doc.xpath('/series_ts/Data_Set/Series'):
    print(series.attrib)
    for elt in series.xpath('obs'):
        print(elt.attrib)