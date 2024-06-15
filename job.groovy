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
        triggers {
            changeset {
                scm('git') {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        credentials('git-tokens')
                    }
                    target('main')
                }
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
        triggers {
            changeset {
                scm('git') {
                    remote {
                        url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                        credentials('git-tokens')
                    }
                    target('master')
                }
            }
        }
    }
}
