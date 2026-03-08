## WORKFLOW.md

### ⚠️ IMPORTANT: DO NOTs

> **STOP AND READ:** These rules are non-negotiable. Violating these will result in an immediate PR rejection.

* **DO NOT** push directly to the `main` branch. All work must happen on a feature branch.
* **DO NOT** rename or delete files (e.g., `InputValidator.java`) without direct Admin approval.
* **DO NOT** push code that does not compile. Broken code breaks the entire team's workflow.
* **DO NOT** use "force" commands (`--force` or `git reset --hard`) unless instructed by the Admin.

---

## 1. Daily Synchronization

Ensure your local machine matches the remote `main` branch before you begin work.

* **Run these commands**:
```bash
git fetch --all
git reset --hard origin/main

```



---

## 2. Feature Implementation

1. **Branching**: `git checkout -b feature/your-feature-name`
2. **Committing**: Stage only files relevant to your current task.
* `git add <filename>`
* `git commit -m "Brief, clear description of logic"`


3. **Pushing**: `git push origin feature/your-feature-name`

---

## 3. Conflict Resolution

If you receive a conflict error during a merge:

1. **Pull Latest**: `git pull origin main`
2. **Resolve Manually**: Locate the `<<<<`, `====`, and `>>>>` markers in your IDE.
3. **Commit Fix**:
* `git add .`
* `git commit -m "Resolved merge conflict"`
* `git push origin feature/your-feature-name`



---

## 4. Support Request Format

If you are blocked, you **must** provide the following to the Admin. Vague requests will be redirected here.

* **Goal**: What are you trying to accomplish?
* **Command**: What command did you run?
* **Terminal Output**: Copy and paste the exact error message.
* **Evidence**: Provide a screenshot if the error is visual.

---