# group6-shared-library
to create our shared library 

Configuration to perfom a shared library:

Each shared library requires users to define a name and a method of retrieving source code. These methods include local files, Git repositories, and Jenkins SCM plugins. Optionally, users can also set a default library version.

Step 1: Create a Groovy Script
First, create a Groovy script using the code you want to save to the library.
def call(String repoUrl){
echo 'git clone $repoUrl'

Step 2: Add the Script to a Git Repository
Create a new Git repository containing a directory named vars. nd save the script in the vars directory eg. “annickApp.groovy”

Step 3: Add a Shared Library in Jenkins
1.	Open the Jenkins dashboard in your web browser.
2.	Click the Manage Jenkins link on the left-hand side of the Jenkins dashboard.
3.	Under System Configuration, click the Configure System button.
4.	Scroll down to the Global Pipeline Libraries section and click the Add button.
5.	A new dialog opens prompting you to set up library details, such as name and SCM method. Fill in the details to configure the library:
•	Name: The name of the new Shared Library.
•	Default version: Set a default version for the new Shared Library. Depending on the SCM, this can be a branch name, eg. “Main”
•	Load implicitly: Checking this option allows scripts to automatically access the library without needing to request it.
•	Include @Library changes in job recent changes: Checking this option causes changes to the library to affect all the builds that use the library.
•	Retrieval method: Choose Modern SCM (when using Jenkins SCM plugins) or Legacy SCM (when using SCM methods not integrated with Jenkins) from the drop-down menu. Selecting Modern SCM lets you choose an SCM plugin (GIT) and add project repository and credentials
6.	Once you are done configuring the new library, click the Apply and Save buttons to save the changes to Jenkins.


Step 4: Use a Shared Library in a Jenkins Pipeline
Create a new Git repository and refer to it by adding your Jenkinsfile including the script with function:
@library('$libraryname') _
$scriptname '$repoUrl'

After you add the shared library from the Git repository to Jenkins, you can refer to it in your pipeline scripts.
1.	Back to Jenkins server, create a new pipeline item in Jenkins. Type the item's name and select Pipeline as the project type. Click OK once done.
2.	From here, make the necessary configuration by adding the corresponding Jenkinsfile repository Url from your Git repo and corresponding credentials. 
3.	You can also add your script that loads the shared library directly from your pipeline script or by creating your repository Jenkinsfile on github. 
4.	Click apply and save to save the changes to the pipeline.
5.	Building the pipeline and checking the console output reveals that the shared library correctly loads and interacts with the user input.
