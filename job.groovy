folder('GCP') {
    displayName('GCP Pipelines')
    description('Folder containing all GCP related pipeline jobs')
}

// Dev Pipeline Job
pipelineJob('GCP/Dev Pipeline Job') {
    displayName('Dev Pipeline Job')
    description('Pipeline job for the development branch')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        credentials('git-credentials-id')
                    }
                    branches('*/main')
                    scriptPath('Jenkinsfile')
                }
            }
        }
    }
    triggers {
        githubPush()
    }
}

// Release Pipeline Job
pipelineJob('GCP/Release Pipeline Job') {
    displayName('Release Pipeline Job')
    description('Pipeline job for the release branch')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        credentials('git-credentials-id')
                    }
                    branches('*/main')
                    scriptPath('release.Jenkinsfile')
                }
            }
        }
    }
    triggers {
        githubPush()
    }
}

// Master Pipeline Job
pipelineJob('GCP/Master Pipeline Job') {
    displayName('Master Pipeline Job')
    description('Pipeline job for the master branch')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        credentials('git-credentials-id')
                    }
                    branches('*/master')
                    scriptPath('master.Jenkinsfile')
                }
            }
        }
    }
    triggers {
        githubPush()
    }
}
