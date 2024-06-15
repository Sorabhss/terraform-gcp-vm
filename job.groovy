folder('GCP') {
    pipelineJob('Dev Pipeline Job') {
        triggers {
            githubPush() // Trigger on GitHub push events
        }
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
        triggers {
            githubPush() // Trigger on GitHub push events
        }
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
        triggers {
            githubPush() // Trigger on GitHub push events
        }
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
