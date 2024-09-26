
from xml.dom.minidom import Document

doc = Document()

# Create an element
element = doc.createElement('example')
doc.appendChild(element)

# Set text content
text_string = "Some text with special characters: <, >, &, ' and \""
text_node = doc.createTextNode(text_string)
element.appendChild(text_node)

# Set an attribute
attribute_string = "Attribute with special characters: <, >, &, ' and \""
element.setAttribute('myAttribute', attribute_string)

# Output the XML
print(doc.toprettyxml(indent="  "))

