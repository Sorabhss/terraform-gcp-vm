pipeline {
    agent any

    environment {
        ENV = 'dev'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'dev', url: 'https://your-repo-url.git'
            }
        }

        stage('Setup Terraform Backend') {
            steps {
                sh 'cp backend.dev.tf backend.tf'
            }
        }

        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }

        stage('Terraform Plan') {
            steps {
                sh 'terraform plan -var-file=terraform.dev.auto.tfvars'
            }
        }

        stage('Terraform Apply') {
            steps {
                sh 'terraform apply -var-file=terraform.dev.auto.tfvars -auto-approve'
            }
        }
    }

    /* post {
        success {
            script {
                if (env.BRANCH_NAME == 'dev') {
                    build job: 'release-pipeline'
                }
            }
        }
    } */
}
