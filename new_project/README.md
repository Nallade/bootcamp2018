### Setup
1. In IDEA open project `new_project` from "C:/Users/Student/Desktop/new_project"
2. In IDEA check in project structure, that:
   * Project has Project SDK: 1.8
   * Modules has "new_project" with "src" folder selected as "Sources"
   * Libraries has all the jars from "lib" folder:
     * hamcrest-core-1.3
     * junit-4.12
     * selenium-server-standalone-3.4.0
3. Pull the latest changes:
   ![Alt text](img/git_pull.png?raw=true "git pull via IDEA")
5. Create a branch:
   ![Alt text](img/git_new_branch_1.png?raw=true "git new branch 1 via IDEA")
   ![Alt text](img/git_new_branch_2.png?raw=true "git new branch 2 via IDEA")
   ![Alt text](img/git_new_branch_3.png?raw=true "git new branch 3 via IDEA")

Note: replace branch_name with your name and surname (NO SPACES)

---
### How to add, commit and push changes to 
Open git bash from project folder (new_project) and do:
   ![Alt text](img/git_add.png?raw=true "git add via IDEA")
   ![Alt text](img/git_commit_1.png?raw=true "git commit 1 via IDEA")
   ![Alt text](img/git_commit_2.png?raw=true "git commit 2 via IDEA")
   ![Alt text](img/git_commit_3.png?raw=true "git commit 3 via IDEA")
   ![Alt text](img/git_push_1.png?raw=true "git push 1 via IDEA")
   ![Alt text](img/git_push_2.png?raw=true "git push 2 via IDEA")
   
Note: replace branch_name with your name and surname (NO SPACES)
  
---
### Feedback

---
### Samples and SampleTask so far...
* Opening a page and printing out url/page title:
    * [Sample1.java](../master/src/selenium/sample/Sample1.java)
    * [Sample1Task.java](../master/src/selenium/sample/Sample1Task.java)
* Locators (id, class, name):
    * [Sample2.java](../master/src/selenium/sample/Sample2.java)
    * [Sample2Task.java](../master/src/selenium/sample/Sample2Task.java)
* Asserts:
    * [Sample3.java](../master/src/selenium/sample/Sample3.java)
    * [Sample3Task.java](../master/src/selenium/sample/Sample3Task.java)
* Actions (click, send keys):
    * [Sample4.java](../master/src/selenium/sample/Sample4.java)
    * [Sample4Task.java](../master/src/selenium/sample/Sample4Task.java)
* Alerts:
    * [Sample5.java](../master/src/selenium/sample/Sample5.java)
    * [Sample5Task.java](../master/src/selenium/sample/Sample5Task.java)
* Locators (xPath, CSS):
    * [Sample6.java](../master/src/selenium/sample/Sample6.java)
    * [Sample6Task.java](../master/src/selenium/sample/Sample6Task.java)
* Actions (checkbox, radio button and option selector) + bonus of calendar:
    * [Sample7.java](../master/src/selenium/sample/Sample7.java)
    * [Sample7Task.java](../master/src/selenium/sample/Sample7Task.java)
* Styles:
    * [Sample8.java](../master/src/selenium/sample/Sample8.java)
    * [Sample8Task.java](../master/src/selenium/sample/Sample8Task.java)
* Waits:
    * [Sample9.java](../master/src/selenium/sample/Sample9.java)
* Into to Page Object:    
    * [Sample10.java](../master/src/selenium/sample/Sample10.java)
    * [GenericPageSample.java](../master/src/pages/GenericPageSample.java)
    * [MainPageSample.java](../master/src/pages/MainPageSample.java)
    * [PageSample.java](../master/src/pages/PageSample.java)
    
---
### Individual Tasks:
* Tasks:
    * [Task1.java](../master/src/selenium/tasks/Task1.java)
    * [Task3.java](../master/src/selenium/tasks/Task3.java)

#### Test on locators

---
### Bonuses in case of boredom
* Driver Navigation:
    * [extra1.java](../master/src/selenium/sample/extra/extra1.java)
    * [extra1Task.java](../master/src/selenium/sample/extra/extra1Task.java)
* Using different browsers:
    * [extra2.java](../master/src/selenium/sample/extra2.java)
    * [extra2Task.java](../master/src/selenium/sample/extra2Task.java)
* Wait:
    * [Task2.java](../master/src/selenium/tasks/Task2.java) -> `loadGreenAndBlueBonus()`
 * Calendar picker:   
    * [Sample7Task.java](../master/src/selenium/sample/Sample7Task.java) -> `chooseDateViaCalendarBonus()` and `chooseDateViaTextBoxBonus()`
 * Page Object + Page Factory:
    * [Task4.java](../master/src/selenium/tasks/Task4.java)
    
---
### Switching to Cucumber project
1. open git on Desktop (but your project) and do:
``git clone https://github.com/KristineK/cucumber_project.git``
2. see set-up from page https://github.com/KristineK/cucumber_project
