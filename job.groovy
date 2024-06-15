pipelineJob('Application Pipeline') {
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

def createJobs() {
    // Define the folder name
    def folderName = 'Your Application Name'

    // Create the folder
    folder(folderName) {
        // Define Dev Pipeline Job
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

        // Define Release Job
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

        // Define Master Pipeline Job
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
    }
}

// Call the method to create the jobs
createJobs()
