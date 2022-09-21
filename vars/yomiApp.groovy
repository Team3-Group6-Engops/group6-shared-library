def call(String repoUrl){
pipeline {
       agent any
       tools {
           maven 'maven'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh 'mvn --version'
                   sh 'java -version'
               }
           }
           stage('checkout stage'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-id', url: 'https://github.com/Team3-Group6-Engops/group6-shared-library.git']]])
            }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage("to-test-maven") {
               steps {
                   sh 'mvn -v'
               }
           }
           stage('parallel-stage'){
            parallel{
                stage('sub-job1'){
                    steps{
                        sh 'cat /etc/passwd'
                    }
                }
                stage('sub-job2'){
                    steps{
                        echo "we are Etech engineers"
                    }
                }
            }
            
           }
           stage('abayomi-stage'){
                steps{
                    echo "This stage is from Engr Abayomi"
                }
            }
       }
}
}
