import re

def safe_format(template: str, **kwargs) -> str:
    """
    Custom template rendering function that only allows specific placeholders.

    :param template: The user-submitted template string.
    :param kwargs: Keyword arguments containing allowed variables and their values.
    :return: A formatted string with the provided data.
    """

    # Define a whitelist of supported placeholder types
    WHITELIST = ["item.price", "item.description"]

    def replace_placeholder(match):
        """
        Replace placeholders in the template using keyword arguments.

        :param match: The matched placeholder pattern from the user-submitted template string.
        :return: A formatted value based on the provided data or an empty string if not found.
        """

        key = match.group(1)
        return str(kwargs.get(key, ""))

    # Replace placeholders in the input template with their corresponding values
    result = re.sub(r"{(\w+)}", replace_placeholder, template)

    # Ensure that only allowed placeholder types are used and reject any other patterns
    if not all(p in WHITELIST for p in set(re.findall(r"{\w+}", result))):
        raise ValueError("Invalid placeholders found")

    return result

# Example usage:
template = "{item[price]} - {item[description]}"
data = {"item": {"price": 10, "description": "Sample item"}}
print(safe_format(template, **data))  # Output: "10 - Sample item"