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
                    //script
                    // Set Git configuration
                    sh 'git config user.email "salokhesourabh09@gmail.com"'
                    sh 'git config user.name "Sorabhss"'

                    // Checkout and merge the main branch into master
                    sh 'git checkout master'
                    sh 'git merge origin/main'

                    // Push the changes to GitHub
                    withCredentials([string(credentialsId: 'github-token', variable: 'GITHUB_TOKEN')]) {
                        sh "git push https://Sorabhss:${GITHUB_TOKEN}@github.com/Sorabhss/terraform-gcp-vm.git master"
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
