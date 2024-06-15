import javaposse.jobdsl.dsl.DslFactory

def folderName = 'MyGCP'

folder(folderName) {
    DslFactory dslFactory = new DslFactory()
    dslFactory.setUseJobDslPlugin(true)

    def jobs = [
        'Dev Pipeline Job': ['main', 'Jenkinsfile'],
        'Release Job': ['main', 'release.Jenkinsfile'],
        'Master Pipeline Job': ['master', 'master.Jenkinsfile']
    ]

    jobs.each { jobName, scriptInfo ->
        def branch = scriptInfo[0]
        def scriptPath = scriptInfo[1]

        dslFactory.pipelineJob(jobName) {
            definition {
                cpsScm {
                    scm {
                        git {
                            remote {
                                url('https://github.com/Sorabhss/terraform-gcp-vm.git')
                                branch(branch)
                            }
                        }
                    }
                    scriptPath(scriptPath)
                }
            }
        }
    }
}
