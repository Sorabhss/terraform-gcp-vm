pipeline {
    agent any
    environment {
        GOOGLE_APPLICATION_CREDENTIALS = credentials('gcp-credentials')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Terraform Init') {
            steps {
                script {
                    // Set GOOGLE_APPLICATION_CREDENTIALS environment variable for Terraform
                    withCredentials([file(credentialsId: 'gcp-credentials', variable: 'GOOGLE_APPLICATION_CREDENTIALS')]) {
                        sh 'terraform init -backend-config=backend.dev.tf'
                    }
                }
            }
        }
        stage('Terraform Plan') {
            steps {
                script {
                    sh 'terraform plan -out=tfplan'
                }
            }
        }
        stage('Manual Approval') {
            steps {
                input "Approve?"
            }
        }
        stage('Terraform Apply') {
            steps {
                script {
                    sh 'terraform apply tfplan'
                }
            }
        }
    }
}
