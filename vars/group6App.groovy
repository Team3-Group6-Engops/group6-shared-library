pipeline{
    agent any 
    stages{
        stage('clone-stage'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkinsgit', url: 'https://github.com/Team3-Group6-Engops/project9.git']]])
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
                        sh 'chmod +x yomi.sh'
                        sh 'bash -x yomi.sh'
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
                        sh 'cat /etc/passwd'
                        echo "My name is Claudi"
                    }
                }
                stage('claudi-parallel-stage2'){
                    steps{
                        sh 'chmod +x claudi.sh'
                        sh 'bash -x claudi.sh'
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
                        sh 'chmod +x francisca.sh'
                        sh 'bash -x francisca.sh'
                    }
                }     
            }
        }
        stage('parallel -3'){
            parallel{
                stage('Lateef-parallel-stage1'){
                    steps{
                        sh 'chmod +x adewale.sh'
                        sh 'bash -x adewale.sh'
                    }
                }
                stage('lateef-parallel-stage2'){
                    steps{
                        sh 'echo i love DevOps alot'
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
                stage('Frank-parallel-stage'){
                    steps{
                        sh 'echo continue to practice DevOps'
                        sh 'chmod +x frank.sh'
                        sh 'bash -x frank.sh'
                    }
                }
                stage('Frank-parallel-stage'){
                    steps{
                        sh 'echo continue to practice DevOps'
                    }
                }
            }
        }
        stage('parallel-6'){
            parallel{
                stage('abbey-parallel-stage1'){
                    steps{
                        sh 'chmod +x abbey.sh'
                        sh 'bash -x abbey.sh'
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
