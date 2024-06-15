import javaposse.jobdsl.dsl.Job
Job folder = folder('TerraformGcp') {
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
}
