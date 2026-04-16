# Git Commands and Workflow Guide

## Prerequisites
- Git installed on your machine
- GitHub account created
- Repository already exists (or will be created)

---

## Current Status

### Check Git Status
```bash
git status
```
This shows which files are modified, untracked, or staged for commit.

**Expected Output:**
```
On branch mainBackUp
Your branch is up to date with 'origin/mainBackUp'.

Changes not staged for commit:
  modified:   src/GUI/Runtime.java
  modified:   other files...

Untracked files:
  CHANGES.md
  GUI_BUTTON_GUIDE.md
  GIT_GUIDE.md
```

---

## Viewing Git Branches

### List All Local Branches
```bash
git branch
```
Shows all branches on your local machine.

### List All Remote Branches
```bash
git branch -r
```
Shows all branches on the remote repository (GitHub).

### List Both Local and Remote Branches
```bash
git branch -a
```
Shows both local and remote branches with visual indicators.

### Current Output (Example):
```
* mainBackUp
  main
  remotes/origin/main
  remotes/origin/mainBackUp
```

---

## Preparing Changes for Push

### Step 1: Stage All Changes
```bash
git add .
```
This stages all modified and new files for commit.

**Alternative - Stage Specific Files:**
```bash
git add src/GUI/Runtime.java
git add CHANGES.md
git add GUI_BUTTON_GUIDE.md
```

### Step 2: View Staged Changes
```bash
git diff --cached
```
Shows what will be committed.

### Step 3: Create a Commit
```bash
git commit -m "Fix GUI button display for all insurance tabs

- Implemented action listeners for Båt Forsikring add/view/save buttons
- Fully implemented Reise Forsikring tab with input fields and buttons
- Enhanced Hus og Innbo Forsikring tab with complete button handlers
- Enhanced Fritidsbolig Forsikring tab with complete button handlers
- Fixed method calls and exception handling
- Added comprehensive GUI button documentation
- Application compiles successfully with UTF-8 encoding"
```

---

## Pushing to GitHub

### Push to Remote Branch (mainBackUp)
```bash
git push origin mainBackUp
```
This pushes your commits to the mainBackUp branch on GitHub.

### Push to Main Branch
```bash
git push origin main
```
Use this if you want to merge into the main branch.

### Push All Branches
```bash
git push origin --all
```
Pushes all local branches to GitHub.

### Push with All Tags
```bash
git push origin --all --tags
```
Pushes branches and tags.

---

## Complete Workflow to Push Changes

### Full Sequence:
```bash
# 1. Check status
git status

# 2. View branches
git branch -a

# 3. Ensure you're on the correct branch
git checkout mainBackUp

# 4. Pull latest changes from remote
git pull origin mainBackUp

# 5. Stage all changes
git add .

# 6. Review what will be committed
git status

# 7. Create commit with descriptive message
git commit -m "GUI button fixes and documentation"

# 8. Push to remote
git push origin mainBackUp

# 9. Verify push was successful
git log --oneline -5
```

---

## Merging mainBackUp to main

### When Ready to Merge to Main:

```bash
# 1. Switch to main branch
git checkout main

# 2. Pull latest main branch
git pull origin main

# 3. Merge mainBackUp into main
git merge mainBackUp

# 4. Push main branch
git push origin main

# 5. Verify
git log --oneline -5
```

---

## Viewing Commits

### View Last 5 Commits
```bash
git log --oneline -5
```

### View Last 10 Commits with Details
```bash
git log --oneline -10
```

### View Commits by Author
```bash
git log --author="Your Name" --oneline
```

### View All Commits Between Two Branches
```bash
git log mainBackUp..main --oneline
```

---

## Undoing Changes (If Needed)

### Unstage a File
```bash
git reset HEAD filename.java
```

### Discard Unstaged Changes
```bash
git checkout -- filename.java
```

### Undo Last Commit (Keep Changes)
```bash
git reset --soft HEAD~1
```

### Undo Last Commit (Discard Changes)
```bash
git reset --hard HEAD~1
```

---

## Viewing Changes

### See What Changed in a File
```bash
git diff src/GUI/Runtime.java
```

### See Changes in Staged Files
```bash
git diff --cached
```

### Compare Two Branches
```bash
git diff main mainBackUp
```

---

## Configuration (First Time Setup)

### Set Your Name
```bash
git config --global user.name "Your Name"
```

### Set Your Email
```bash
git config --global user.email "your.email@example.com"
```

### Verify Configuration
```bash
git config --global user.name
git config --global user.email
```

---

## Quick Reference Commands

| Command | Purpose |
|---------|---------|
| `git status` | Check status of changes |
| `git branch -a` | List all branches |
| `git add .` | Stage all changes |
| `git commit -m "message"` | Create commit |
| `git push origin mainBackUp` | Push to GitHub |
| `git pull origin mainBackUp` | Pull from GitHub |
| `git log --oneline -5` | View last 5 commits |
| `git checkout branch-name` | Switch branch |
| `git diff filename` | View changes in file |

---

## Recommended Push Sequence for This Project

```bash
# Navigate to project directory
cd "/Users/lungamajola/Documents/Personal/JAVA 2024/IntelijWorkAndImprovments"

# Step 1: Check current status
git status

# Step 2: Check branches
git branch -a

# Step 3: Ensure on mainBackUp branch
git checkout mainBackUp

# Step 4: Pull latest from remote
git pull origin mainBackUp

# Step 5: Stage all changes
git add .

# Step 6: Review staged changes
git status

# Step 7: Create meaningful commit
git commit -m "Fix: Implement complete GUI button functionality for all insurance tabs

Fixes:
- BaatForsikring: Added add/view/save button handlers
- ReiseForsikring: Implemented complete tab with input fields
- HusogInnbo: Added button action listeners  
- Fritidsbolig: Added button action listeners
- Fixed method names and exception handling
- Compilation successful with UTF-8 encoding

Features:
- Input validation on all forms
- Error dialogs for invalid input
- File persistence for all insurance types
- User feedback and confirmation messages
- Customer lookup verification

Documentation:
- Added CHANGES.md for detailed change log
- Added GUI_BUTTON_GUIDE.md for user guide
- Added GIT_GUIDE.md for Git workflow"

# Step 8: Push to GitHub
git push origin mainBackUp

# Step 9: Verify successful push
git log --oneline -5

# Step 10: (Optional) Merge to main branch
git checkout main
git pull origin main
git merge mainBackUp
git push origin main

# Step 11: View final branches
git branch -a
```

---

## Tips and Best Practices

✓ **Always pull before pushing** - Prevents merge conflicts
✓ **Use descriptive commit messages** - Makes history clear
✓ **Commit frequently** - Keep changes logical and organized
✓ **Review changes before committing** - Use `git diff` to verify
✓ **Never force push** - Use `git push --force` only if you know what you're doing
✓ **Keep commits atomic** - Each commit should represent one logical change
✓ **Test before pushing** - Verify code compiles and runs
✓ **Write meaningful branch names** - Use feature/feature-name format

---

## Common Issues and Solutions

### Issue: "Please pull before pushing"
```bash
git pull origin mainBackUp
git push origin mainBackUp
```

### Issue: "Merge conflict"
```bash
# View conflicts
git status

# Open conflicted files and resolve manually
# Then:
git add .
git commit -m "Resolve merge conflicts"
git push origin mainBackUp
```

### Issue: "Detached HEAD state"
```bash
git checkout mainBackUp
```

### Issue: "No changes to commit"
```bash
# Verify files exist
git status

# Add them if untracked
git add .
git status
```

---

## Useful Aliases (Optional)

Add these to your `.gitconfig` for shortcuts:

```bash
git config --global alias.st status
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.ci commit
git config --global alias.unstage 'reset HEAD --'
git config --global alias.last 'log -1 HEAD'
git config --global alias.visual 'log --graph --oneline --all'
```

Then use:
```bash
git st        # instead of git status
git co main   # instead of git checkout main
git ci -m ""  # instead of git commit -m ""
```

---

## Summary of Current State

✓ All changes made to Runtime.java
✓ Documentation files created (CHANGES.md, GUI_BUTTON_GUIDE.md)
✓ Code compiles successfully
✓ .gitignore exists and configured
✓ Ready to push to GitHub

**Next Steps:**
1. Run the recommended push sequence above
2. Monitor GitHub for successful push
3. Create pull request from mainBackUp to main if needed
4. Merge to main branch when ready


