pipeline {
    agent any

    environment {
        GIT_USERNAME = credentials('github-credentials').username
        GIT_TOKEN = credentials('github-credentials').password
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Sorabhss/terraform-gcp-vm.git']]])
            }
        }
        stage('Merge to Master') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'github-token')]) {
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
