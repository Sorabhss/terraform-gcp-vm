pipelineJob('Dev Pipeline Job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        branch('main')
                    }
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}

pipelineJob('Release Job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        branch('main')
                    }
                }
            }
            scriptPath('release.Jenkinsfile')
        }
    }
}

pipelineJob('Master Pipeline Job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        branch('master')
                    }
                }
            }
            scriptPath('master.Jenkinsfile')
        }
    }
}

@NonCPS
def createJobs() {
    pipelineJob('Dev Pipeline Job') {
        // Job definition here
    }

    pipelineJob('Release Job') {
        // Job definition here
    }

    pipelineJob('Master Pipeline Job') {
        // Job definition here
    }
}

createJobs()
