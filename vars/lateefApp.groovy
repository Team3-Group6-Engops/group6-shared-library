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
           stage('Clone'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-id', url: 'https://github.com/Team3-Group6-Engops/group6-shared-library.git']]])
            }
           }
           stage("Scan Code") {
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
                        echo "We will make $200k"
                    }
                }
            }

           }
           stage('abbey-stage'){
                steps{
                    echo "This stage is from Engr Lateef :)"
                }
            }
       }
}
}
