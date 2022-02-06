package steps

def fxLogs() {
    return {
        stage('-1 logs') {
                steps {
                    //- Generar análisis con sonar para cada ejecución
                    //- Cada ejecución debe tener el siguiente formato de nombre:
                    //- {nombreRepo}-{rama}-{numeroEjecucion} ejemplo:
                    //- ms-iclab-feature-estadomundial(Si está usando el CRUD ms-iclab-feature-[nombre de su crud])
                    script {
                        env.GIT_REPO_NAME = env.GIT_URL.replaceFirst(/^.*\/([^\/]+?).git$/, '$1')
                        currentBuild.displayName = GIT_REPO_NAME + '-' + BRANCH_NAME + '-' + BUILD_NUMBER
                    }
                    sh "echo 'branchname: '" + BRANCH_NAME
                script { STAGE = '-1 logs ' }
                }
        }
    }
}
