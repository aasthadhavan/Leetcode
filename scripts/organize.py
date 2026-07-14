import os
import shutil

ROOT = "."

for item in os.listdir(ROOT):
    path = os.path.join(ROOT, item)

    if not os.path.isdir(path):
        continue

    if item in ["Easy", "Medium", "Hard", ".git", ".github", "scripts"]:
        continue

    readme = os.path.join(path, "README.md")

    if not os.path.exists(readme):
        continue

    with open(readme, encoding="utf-8") as f:
        text = f.read().lower()

    if "easy" in text:
        dest = os.path.join("Easy", item)
    elif "medium" in text:
        dest = os.path.join("Medium", item)
    elif "hard" in text:
        dest = os.path.join("Hard", item)
    else:
        continue

    if not os.path.exists(dest):
        shutil.move(path, dest)

print("Finished!")
