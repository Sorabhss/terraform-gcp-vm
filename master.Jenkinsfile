pipeline {
    agent any
    environment {
        GOOGLE_APPLICATION_CREDENTIALS = credentials('gcp-credentials')
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                    // Extract the branch name from the SCM context
                    def scmVars = checkout scm
                    env.BRANCH_NAME = scmVars.GIT_BRANCH.replaceFirst(/^origin\//, '')
                    echo "Checked out branch: ${env.BRANCH_NAME}"
                }
            }
        }
        stage('Determine Environment') {
            steps {
                script {
                    // Automatically determine the environment based on the branch name
                    if (env.BRANCH_NAME == 'main') {
                        env.ENV = 'dev'
                    } else if (env.BRANCH_NAME == 'staging') {
                        env.ENV = 'staging'
                    } else if (env.BRANCH_NAME == 'master') {
                        env.ENV = 'prod'
                    } else {
                        error "Unsupported branch: ${env.BRANCH_NAME}"
                    }
                }
            }
        }
        stage('Terraform Init') {
            steps {
                script {
                    def backendConfigFile = "backend.${env.ENV}.tf"
                    // Read the backend configuration from the file
                    def backendConfig = readFile(file: backendConfigFile)
                    // Split the configuration into lines and construct the init command
                    def backendConfigLines = backendConfig.split('\n')
                    def initCommand = "terraform init"
                    for (line in backendConfigLines) {
                        def parts = line.split('=')
                        if (parts.length == 2) {
                            def key = parts[0].trim()
                            def value = parts[1].trim().replaceAll('"', '')
                            initCommand += " -backend-config=\"${key}=${value}\""
                        }
                    }
                    // Set GOOGLE_APPLICATION_CREDENTIALS environment variable for Terraform
                    withCredentials([file(credentialsId: 'gcp-credentials', variable: 'GCP_CREDS')]) {
                        sh """
                           export GOOGLE_APPLICATION_CREDENTIALS=\$GCP_CREDS
                           ${initCommand}
                        """
                    }
                }
            }
        }
        stage('Terraform Plan') {
            steps {
                script {
                     sh "terraform plan -out=tfplan -var-file=terraform.${env.ENV}.tfvars"
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
