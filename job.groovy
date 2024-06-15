folder('GCP') {
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
    }.moveInto('GCP')

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
    }.moveInto('GCP')

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
    }.moveInto('GCP')
}
