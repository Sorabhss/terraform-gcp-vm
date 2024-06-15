def folderName = 'GCP'
def folderPath = folderName

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
}.addToFolder(folderPath)

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
}.addToFolder(folderPath)

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
}.addToFolder(folderPath)
