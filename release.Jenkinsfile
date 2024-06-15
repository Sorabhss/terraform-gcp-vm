pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Merge to Master') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'github', passwordVariable: 'GIT_TOKEN', usernameVariable: 'GIT_USERNAME')]) {
                        sh 'git config user.email "salokhesourabh09@gmail.com"'
                        sh 'git config user.name "Sorabhss"'
                        sh 'git checkout master'
                        sh 'git merge origin/main'
                        sh 'git push origin master'
                    }
                }
            }
        }
        stage('Trigger Master Pipeline') {
            steps {
                build job: 'Master Pipeline Job', wait: false
            }
        }
    }
}
