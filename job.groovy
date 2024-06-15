folder('GCP') {
    pipelineJob('Dev Pipeline Job') {
        triggers {
            githubPush{
                branchFilter('main')
            } // Trigger on GitHub push events
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
        githubPush{
                branchFilter('master')
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
