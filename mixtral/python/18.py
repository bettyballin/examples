from pathlib import Path

def validate_path(user_input):
    base_dir = Path('/my/self/defined/path')
    full_path = (base_dir / user_input).resolve()
    if not full_path.is_relative_to(base_dir):
        raise ValueError("Invalid path")

if __name__ == "__main__":
    user_input = '../../'
    try:
        validate_path(user_input)
    except ValueError as e:
        print(e)