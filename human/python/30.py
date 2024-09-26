import xml.etree.ElementTree as ET

content = """your_xml_string_here"""
content = content.replace('iso-8859-8-i','iso-8859-8')
doc = ET.fromstring(content)