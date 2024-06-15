pipeline {
    agent {
        docker {
            image 'hashicorp/terraform:latest'
        }
    }
    environment {
        TF_CLI_ARGS = "-input=false"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }
        stage('Terraform Plan') {
            steps {
                sh 'terraform plan'
            }
        }
        stage('Trigger Master Pipeline') {
            steps {
                build job: 'Master Pipeline Job', wait: false
            }
        }
    }
}
