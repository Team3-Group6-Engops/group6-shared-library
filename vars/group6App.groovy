def call(String repoUrl){
pipeline{
    agent any 
    stages{
        stage('clone-stage'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkinsgit', url: 'https://github.com/Team3-Group6-Engops/group6-shared-library.git']]])
            }
        }
        stage('parallel-1'){
            parallel{
                stage('abayomi-parallel-stage'){
                    steps{
                     sh 'whoami'
                     echo "I am a Devops Engineer"
                    }
                }
                stage('abayomi-parallel2'){
                    steps{
                        echo "This is a parallel pipeline"
                    }
                }
            }
        }
        stage('check-cpu'){
            steps{
                sh 'lscpu'
            }
        }
        stage('parallel-2'){
            parallel{
                stage('claudi-parallel-stage1'){
                    steps{
                        echo "My name is Claudi"
                    }
                }
                stage('claudi-parallel-stage2'){
                    steps{
                        sh 'cat /etc/passwd'
                    }
                }
            }
        }
        stage('check-pwd'){
            steps{
                sh 'pwd'
            }
        }
        stage('parallel-3'){
            parallel{
                stage('francisca-parallel-stage1'){
                    steps{
                        sh 'cat /etc/passwd'
                        echo "welcome Eng. francisca "
                    }
                }
                stage('francisca-parallel-stage2'){
                    steps{
                        echo "I am an Engineer"
                    }
                }     
            }
        }
        stage('parallel -3'){
            parallel{
                stage('Lateef-parallel-stage1'){
                    steps{
                        echo "I am Lateef"
                    }
                }
                stage('lateef-parallel-stage2'){
                    steps{
                        echo "i love DevOps alot"
                    }
                }
            }
        }
        stage('parallel-4'){
            parallel{
                stage('Annick-parallel-stage'){
                    steps{
                        echo "I am an Etech Devops Master"
                    }
                }
                stage('user-check'){
                    steps{
                        sh 'cat /etc/passwd | grep jenkins'
                    }
                }
            }
        }
        stage('parallel-5'){
            parallel{
                stage('Frank-parallel-stage1'){
                    steps{
                        echo "continue to practice DevOps"
                    }
                }
                stage('Frank-parallel-stage2'){
                    steps{
                        echo "continue to practice DevOps"
                    }
                }
            }
        }
        stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
        stage('parallel-6'){
            parallel{
                stage('abbey-parallel-stage1'){
                    steps{
                        echo "I study DevOps"
                    }
                }
                stage('abbey-parallel-stage2'){
                    steps{
                        echo "I am a DevOps Engr."
                    }
                }
            }
        }
    }
} 
